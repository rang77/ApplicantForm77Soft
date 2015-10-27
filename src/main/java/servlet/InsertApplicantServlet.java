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

@WebServlet(name = "oauth", urlPatterns = { "/applicant-form/insertApplicant/*", "/applicant-form/insertApplicant" }, initParams = {
// clientId is 'Consumer Key' in the Remote Access UI
@WebInitParam(name = "clientId", value = "3MVG9ZL0ppGP5UrC9R5pfGadp9_.sezTYM4KyOofpmNB9S0IumaT57vNAI1j0Xbl6fJInNkjvcIDSCKZ9ypMm"),
// clientSecret is 'Consumer Secret' in the Remote Access UI
@WebInitParam(name = "clientSecret", value = "8568904816664843552"),
// This must be identical to 'Callback URL' in the Remote Access UI
@WebInitParam(name = "environment", value = "https://login.salesforce.com"), })
@MultipartConfig
public class InsertApplicantServlet extends HttpServlet {

	private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd");
	private static final long serialVersionUID = 1L;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApiConfig config = new ApiConfig();
		config.setUsername(USERNAME);
		config.setPassword(PASSWORD + SECURITY_TOKEN);
		config.setClientId(clientId);
		config.setClientSecret(clientSecret);
		config.setLoginEndpoint(environment);

		ForceApi api = new ForceApi(config);

		Applicant applicant = new Applicant();

		String achievementsCertifications = request.getParameter("achievementsCertifications");
		String availabilityOfEmployment = request.getParameter("availabilityOfEmployment");
		String birthdate = request.getParameter("birthdate");
		String citizenship = request.getParameter("citizenship");
		String civilStatus = request.getParameter("civilStatus");
		String currentPreviousCompany = request.getParameter("currentPreviousCompany");
		String currentPreviousDateEnded = request.getParameter("currentPreviousDateEnded");
		String currentPreviousDateStarted = request.getParameter("currentPreviousDateStarted");
		String educationAttainments = request.getParameter("educationAttainments");
		String emailAddress = request.getParameter("emailAddress");
		String firstName = request.getParameter("firstName");
		String gender = request.getParameter("gender");
		String lastName = request.getParameter("lastName");
		String middleName = request.getParameter("middleName");
		String mobileNumber = request.getParameter("mobileNumber");
		String currentPreviousManager = request.getParameter("currentPreviousManager");
		String permanentAddress = request.getParameter("permanentAddress");
		String currentPreviousPosition = request.getParameter("currentPreviousPosition");
		String positionApplyingFor = request.getParameter("positionApplyingFor");
		String presentAddress = request.getParameter("presentAddress");
		String skills = request.getParameter("skills");
		String telephoneNumber = request.getParameter("telephoneNumber");

		applicant.setAchievementsCertifications(achievementsCertifications);
		try {
			applicant.setAvailabilityOfEmployment(DF.parse(availabilityOfEmployment));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Birthdate: " + birthdate);
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
			response.sendRedirect("/applicant-form/error.html");
		} else {
			
			if (request.getPart("resume").getName().equals("")) {
				Part attachedResume = request.getPart("resume");

				if (attachedResume.getSize() <= Attachment.MAX_FILE_SIZE) {
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
				response.sendRedirect("/applicant-form/success.html");
			}
		}
	}

}
