package model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

	@JsonProperty(value = "Id")
	private String id;

	@JsonProperty(value = "Name")
	private String employeeNumber;

	@JsonProperty(value = "IDNumber__c")
	private String idNumber;

	@JsonProperty(value = "FirstName__c")
	private String firstName;

	@JsonProperty(value = "LastName__c")
	private String lastName;

	@JsonProperty(value = "MiddleName__c")
	private String middleName;

	@JsonProperty(value = "SLCredits__c")
	private String slCredits;

	@JsonProperty(value = "VLCredits__c")
	private String vlCredits;

	@JsonProperty(value = "UsedSLCredits__c")
	private String usedSlCredits;

	@JsonProperty(value = "UsedVLCredits__c")
	private String usedVlCredits;

	@JsonProperty(value = "LeaveRequests__r")
	private List<LeaveRequest> leaveRequests;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getSlCredits() {
		return slCredits;
	}

	public void setSlCredits(String slCredits) {
		this.slCredits = slCredits;
	}

	public String getVlCredits() {
		return vlCredits;
	}

	public void setVlCredits(String vlCredits) {
		this.vlCredits = vlCredits;
	}

	public String getUsedSlCredits() {
		return usedSlCredits;
	}

	public void setUsedSlCredits(String usedSlCredits) {
		this.usedSlCredits = usedSlCredits;
	}

	public String getUsedVlCredits() {
		return usedVlCredits;
	}

	public void setUsedVlCredits(String usedVlCredits) {
		this.usedVlCredits = usedVlCredits;
	}

	public List<LeaveRequest> getLeaveRequests() {
		return leaveRequests;
	}

	public void setLeaveRequests(List<LeaveRequest> leaveRequests) {
		this.leaveRequests = leaveRequests;
	}

}
