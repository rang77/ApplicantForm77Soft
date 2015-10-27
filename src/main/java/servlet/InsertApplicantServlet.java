package servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.force.api.ApiConfig;
import com.force.api.ForceApi;

import model.Applicant;
import model.Attachment;

@WebServlet(name = "oauth", urlPatterns = { "/insertApplicant/*", "/insertApplicant" }, initParams = {
// clientId is 'Consumer Key' in the Remote Access UI
@WebInitParam(name = "clientId", value = "3MVG9ZL0ppGP5UrC9R5pfGadp9_.sezTYM4KyOofpmNB9S0IumaT57vNAI1j0Xbl6fJInNkjvcIDSCKZ9ypMm"),
// clientSecret is 'Consumer Secret' in the Remote Access UI
@WebInitParam(name = "clientSecret", value = "8568904816664843552"),
// This must be identical to 'Callback URL' in the Remote Access UI
@WebInitParam(name = "environment", value = "https://login.salesforce.com"), })
@MultipartConfig
public class InsertApplicantServlet extends HttpServlet {

	private static final DateFormat DF = new SimpleDateFormat("yyyy-mm-dd");
	private static final long serialVersionUID = 1L;
	private static final long ATTACHMENT_MAX = Double.valueOf("5E+06").longValue();

	private static final String USERNAME = "devorg@77soft.com";
	private static final String PASSWORD = "77GSIDev";
	private static final String SECURITY_TOKEN = "ta3WbXLee49bAgxiiepNipmA";
	private String clientId = null;
	private String clientSecret = null;
	private String environment = null;

	public void init() throws ServletException {
		clientId = this.getInitParameter("clientId");
		clientSecret = this.getInitParameter("clientSecret");
		environment = this.getInitParameter("environment");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		ApiConfig config = new ApiConfig();
		config.setUsername(USERNAME);
		config.setPassword(PASSWORD + SECURITY_TOKEN);
		config.setClientId(clientId);
		config.setClientSecret(clientSecret);
		config.setLoginEndpoint(environment);

		ForceApi api = new ForceApi(config);

		Applicant applicant = new Applicant();

		String achievementsCertifications = req.getParameter("achievementsCertifications");
		String availabilityOfEmployment = req.getParameter("availabilityOfEmployment");
		String birthdate = req.getParameter("birthdate");
		String citizenship = req.getParameter("citizenship");
		String civilStatus = req.getParameter("civilStatus");
		String currentPreviousCompany = req.getParameter("currentPreviousCompany");
		String currentPreviousDateEnded = req.getParameter("currentPreviousDateEnded");
		String currentPreviousDateStarted = req.getParameter("currentPreviousDateStarted");
		String educationAttainments = req.getParameter("educationAttainments");
		String emailAddress = req.getParameter("emailAddress");
		String firstName = req.getParameter("firstName");
		String gender = req.getParameter("gender");
		String lastName = req.getParameter("lastName");
		String middleName = req.getParameter("middleName");
		String mobileNumber = req.getParameter("mobileNumber");
		String currentPreviousManager = req.getParameter("currentPreviousManager");
		String permanentAddress = req.getParameter("permanentAddress");
		String currentPreviousPosition = req.getParameter("currentPreviousPosition");
		String positionApplyingFor = req.getParameter("positionApplyingFor");
		String presentAddress = req.getParameter("presentAddress");
		String skills = req.getParameter("skills");
		String telephoneNumber = req.getParameter("telephoneNumber");

		applicant.setAchievementsCertifications(achievementsCertifications);
		try {
			applicant.setAvailabilityOfEmployment(DF.parse(availabilityOfEmployment));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			applicant.setBirthdate(DF.parse(birthdate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		applicant.setCitizenship(citizenship);
		applicant.setCivilStatus(civilStatus);
		applicant.setCurrentPreviousCompany(currentPreviousCompany);
		try {
			applicant.setCurrentPreviousDateEnded(DF.parse(currentPreviousDateEnded));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			applicant.setCurrentPreviousDateStarted(DF.parse(currentPreviousDateStarted));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		applicant.setEducationAttainments(educationAttainments);
		applicant.setEmailAddress(emailAddress);
		applicant.setFirstName(firstName);
		applicant.setGender(gender);
		applicant.setLastName(lastName);
		applicant.setMiddleName(middleName);
		applicant.setMobileNumber(mobileNumber);
		applicant.setCurrentPreviousManager(currentPreviousManager);
		applicant.setPermanentAddress(permanentAddress);
		applicant.setCurrentPreviousPosition(currentPreviousPosition);
		applicant.setPositionApplyingFor(positionApplyingFor);
		applicant.setPresentAddress(presentAddress);
		applicant.setSkills(skills);
		applicant.setTelephoneNumber(telephoneNumber);

		String id = api.createSObject("Applicant__c", applicant);

		if (id == null || id.length() == 0) {
			response.sendRedirect("/error.html");
		} else {
			if (req.getPart("resume") != null) {
				Part attachedResume = req.getPart("resume");

				if (attachedResume.getSize() <= ATTACHMENT_MAX) {
					InputStream fileContent = attachedResume.getInputStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] chunk = new byte[(int) attachedResume.getSize()];
					int amountRead;
					while ((amountRead = fileContent.read(chunk)) != -1) {
						outputStream.write(chunk, 0, amountRead);
					}

					String fileName = "";

					for (String value : attachedResume.getHeader("content-disposition").split(";")) {
						if (value.trim().startsWith("filename")) {
							fileName = value.substring(value.indexOf('=') + 1).trim().replace("\"", "");
							fileName = fileName.substring(fileName.lastIndexOf('/') + 1)
									.substring(fileName.lastIndexOf('\\') + 1);
						}
					}

					Attachment resume = new Attachment(chunk.length);

					resume.setParentId(id);
					resume.setName(fileName);
					resume.setBody(outputStream.toByteArray());

					api.createSObject("Attachment", resume);
				}
			}

			response.sendRedirect("/success.html");
		}
	}

}
