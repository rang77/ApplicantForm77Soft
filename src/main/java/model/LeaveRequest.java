package model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaveRequest {

	@JsonProperty(value = "Id")
	private String id;

	@JsonProperty(value = "Name")
	private String requestNumber;

	@JsonProperty(value = "Employee__c")
	private String employeeID;

	@JsonProperty(value = "StartDate__c")
	private String startDate;

	@JsonProperty(value = "EndDate__c")
	private String endDate;

	@JsonProperty(value = "LeaveType__c")
	private String leaveType;

	private int daysOnLeave;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	@JsonIgnore
	public int getDaysOnLeave() {
		return daysOnLeave;
	}

	@JsonProperty(value = "DaysOnLeave__c")
	public void setDaysOnLeave(int daysOnLeave) {
		this.daysOnLeave = daysOnLeave;
	}

}
