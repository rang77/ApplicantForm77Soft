package model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Applicant {

	@JsonProperty(value = "Id")
	private String id;

	@JsonProperty(value = "Name")
	private String applicantNumber;

	@JsonProperty(value = "AchievementsCertifications__c")
	private String achievementsCertifications;
	
	@JsonProperty(value = "AvailabilityOfEmployment__c")
	private String availabilityOfEmployment;
	
	@JsonProperty(value = "Birthdate__c")
	private String birthdate;

	@JsonProperty(value = "Citizenship__c")
	private String citizenship;

	@JsonProperty(value = "CivilStatus__c")
	private String civilStatus;

	@JsonProperty(value = "CurrentPreviousCompany__c")
	private String currentPreviousCompany;

	@JsonProperty(value = "CurrentPreviousDateEnded__c")
	private String currentPreviousDateEnded;

	@JsonProperty(value = "CurrentPreviousDateStarted__c")
	private String currentPreviousDateStarted;

	@JsonProperty(value = "EducationAttainments__c")
	private String educationAttainments;

	@JsonProperty(value = "EmailAddress__c")
	private String emailAddress;

	@JsonProperty(value = "FirstName__c")
	private String firstName;

	@JsonProperty(value = "Gender__c")
	private String gender;

	@JsonProperty(value = "LastName__c")
	private String lastName;

	@JsonProperty(value = "MiddleName__c")
	private String middleName;

	@JsonProperty(value = "MobileNumber__c")
	private String mobileNumber;

	@JsonProperty(value = "CurrentPreviousManager__c")
	private String currentPreviousManager;

	@JsonProperty(value = "PermanentAddress__c")
	private String permanentAddress;

	@JsonProperty(value = "CurrentPreviousPosition__c")
	private String currentPreviousPosition;

	@JsonProperty(value = "PositionApplyingFor__c")
	private String positionApplyingFor;

	@JsonProperty(value = "PresentAddress__c")
	private String presentAddress;

	@JsonProperty(value = "Skills__c")
	private String skills;
	
	@JsonProperty(value = "TelephoneNumber__c")
	private String telephoneNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplicantNumber() {
		return applicantNumber;
	}

	public void setApplicantNumber(String applicantNumber) {
		this.applicantNumber = applicantNumber;
	}

	public String getAchievementsCertifications() {
		return achievementsCertifications;
	}

	public void setAchievementsCertifications(String achievementsCertifications) {
		this.achievementsCertifications = achievementsCertifications;
	}

	public String getAvailabilityOfEmployment() {
		return availabilityOfEmployment;
	}

	public void setAvailabilityOfEmployment(String availabilityOfEmployment) {
		this.availabilityOfEmployment = availabilityOfEmployment;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}

	public String getCurrentPreviousCompany() {
		return currentPreviousCompany;
	}

	public void setCurrentPreviousCompany(String currentPreviousCompany) {
		this.currentPreviousCompany = currentPreviousCompany;
	}

	public String getCurrentPreviousDateEnded() {
		return currentPreviousDateEnded;
	}

	public void setCurrentPreviousDateEnded(String currentPreviousDateEnded) {
		this.currentPreviousDateEnded = currentPreviousDateEnded;
	}

	public String getCurrentPreviousDateStarted() {
		return currentPreviousDateStarted;
	}

	public void setCurrentPreviousDateStarted(String currentPreviousDateStarted) {
		this.currentPreviousDateStarted = currentPreviousDateStarted;
	}

	public String getEducationAttainments() {
		return educationAttainments;
	}

	public void setEducationAttainments(String educationAttainments) {
		this.educationAttainments = educationAttainments;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber__c) {
		this.mobileNumber = mobileNumber__c;
	}

	public String getCurrentPreviousManager() {
		return currentPreviousManager;
	}

	public void setCurrentPreviousManager(String currentPreviousManager) {
		this.currentPreviousManager = currentPreviousManager;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getCurrentPreviousPosition() {
		return currentPreviousPosition;
	}

	public void setCurrentPreviousPosition(String currentPreviousPosition) {
		this.currentPreviousPosition = currentPreviousPosition;
	}

	public String getPositionApplyingFor() {
		return positionApplyingFor;
	}

	public void setPositionApplyingFor(String positionApplyingFor) {
		this.positionApplyingFor = positionApplyingFor;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
}