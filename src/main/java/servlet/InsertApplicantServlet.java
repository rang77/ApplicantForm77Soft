package servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import db.SalesforceDAO;
import model.Applicant;
import model.Attachment;

@WebServlet(name = "insertapplicantform", urlPatterns = { "/applicant-form/insertApplicant/*",
		"/applicant-form/insertApplicant" })
@MultipartConfig
public class InsertApplicantServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SalesforceDAO<Applicant> connector = new SalesforceDAO<>();

		connector.connect();

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

		applicant.setAvailabilityOfEmployment(availabilityOfEmployment);
		applicant.setBirthdate(birthdate);
		applicant.setCitizenship(citizenship);
		applicant.setCivilStatus(civilStatus);
		applicant.setCurrentPreviousCompany(currentPreviousCompany);
		
		if(!currentPreviousDateEnded.isEmpty())
			applicant.setCurrentPreviousDateEnded(currentPreviousDateEnded);
		
		if(!currentPreviousDateStarted.isEmpty())
			applicant.setCurrentPreviousDateStarted(currentPreviousDateStarted);
		
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

		String id = connector.create("Applicant__c", applicant);

		if (id == null || id.length() == 0) {
			response.sendRedirect("/applicant-form/error.html");
		} else {
			Part attachedResume = request.getPart("resume");

			if (attachedResume.getSize() > 0 && attachedResume.getSize() <= Attachment.MAX_FILE_SIZE) {

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

				connector.create("Attachment", resume);

			}

			response.sendRedirect("/applicant-form/success.html");
		}
	}

}
