package model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource {

	@JsonProperty(value = "Id")
	private String recordID;

	@JsonProperty(value = "Name")
	@JsonSerialize(include = Inclusion.NON_NULL)
	private String employeeNumber;

	@JsonProperty(value = "IDNumber__c")
	@JsonSerialize(include = Inclusion.NON_NULL)
	private String idNumber;

	@JsonProperty(value = "FirstName__c")
	@JsonSerialize(include = Inclusion.NON_NULL)
	private String firstName;

	@JsonProperty(value = "LastName__c")
	@JsonSerialize(include = Inclusion.NON_NULL)
	private String lastName;

	@JsonProperty(value = "MiddleName__c")
	@JsonSerialize(include = Inclusion.NON_NULL)
	private String middleName;

	@JsonProperty(value = "SickLeaveEntitlement__c")
	@JsonSerialize(include = Inclusion.NON_NULL)
	private double slCredits;

	@JsonProperty(value = "VacationLeaveEntitlement__c")
	@JsonSerialize(include = Inclusion.NON_NULL)
	private double vlCredits;

	@JsonProperty(value = "SickLeavesUsed__c")
	@JsonSerialize(include = Inclusion.NON_NULL)
	private double sickLeavesUsed;

	@JsonProperty(value = "VacationLeavesUsed__c")
	@JsonSerialize(include = Inclusion.NON_NULL)
	private double vacationLeavesUsed;

	@JsonProperty(value = "LeaveRequest__r")
	@JsonSerialize(include = Inclusion.NON_NULL)
	private List<LeaveRequest> leaveRequests;
	
	@JsonProperty(value = "ImmediateManagerEmail__c")
	@JsonSerialize(include = Inclusion.NON_NULL)
	private String immediateManagerEmail;
	
	@JsonProperty(value = "ImmediateManagerName__c")
	private String immediateManagerName;

	public String getRecordID() {
		return recordID;
	}

	public void setRecordID(String recordID) {
		this.recordID = recordID;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public double getSlCredits() {
		return slCredits;
	}

	public void setSlCredits(double slCredits) {
		this.slCredits = slCredits;
	}

	public double getVlCredits() {
		return vlCredits;
	}

	public void setVlCredits(double vlCredits) {
		this.vlCredits = vlCredits;
	}

	public double getSickLeavesUsed() {
		return sickLeavesUsed;
	}

	public void setSickLeavesUsed(double sickLeavesUsed) {
		this.sickLeavesUsed = sickLeavesUsed;
	}

	public double getVacationLeavesUsed() {
		return vacationLeavesUsed;
	}

	public void setVacationLeavesUsed(double vacationLeavesUsed) {
		this.vacationLeavesUsed = vacationLeavesUsed;
	}

	public List<LeaveRequest> getLeaveRequests() {
		return leaveRequests;
	}

	public void setLeaveRequests(List<LeaveRequest> leaveRequests) {
		this.leaveRequests = leaveRequests;
	}

	public String getImmediateManagerEmail() {
		return immediateManagerEmail;
	}

	public void setImmediateManagerEmail(String immediateManagerEmail) {
		this.immediateManagerEmail = immediateManagerEmail;
	}

	public String getImmediateManagerName() {
		return immediateManagerName;
	}

	public void setImmediateManagerName(String immediateManagerName) {
		this.immediateManagerName = immediateManagerName;
	}
}
