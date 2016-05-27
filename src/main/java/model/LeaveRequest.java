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

	@JsonProperty(value = "Resource__c")
	private String employeeID;

	@JsonProperty(value = "StartDate__c")
	private String startDate;

	@JsonProperty(value = "EndDate__c")
	private String endDate;

	@JsonProperty(value = "LeaveType__c")
	private String leaveType;

	@JsonProperty(value = "Reason__c")
	private String reason;

	@JsonProperty(value = "Halfday__c")
	private boolean halfday;
	
	@JsonProperty(value = "ApprovalCode__c")
	private String approvalCode;
	
	@JsonProperty(value = "Remarks__c")
	private boolean remarks;
	
	private String leaveStatus;

	private double daysOnLeave;

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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@JsonIgnore
	public double getDaysOnLeave() {
		return daysOnLeave;
	}

	@JsonProperty(value = "DaysOnLeave__c")
	public void setDaysOnLeave(double daysOnLeave) {
		this.daysOnLeave = daysOnLeave;
	}

	@JsonProperty(value = "LeaveStatus__c")
	public String getLeaveStatus() {
		return leaveStatus;
	}

	@JsonIgnore
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public boolean isHalfday() {
		return halfday;
	}

	public void setHalfday(boolean halfday) {
		this.halfday = halfday;
	}

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	public boolean isRemarks() {
		return remarks;
	}

	public void setRemarks(boolean remarks) {
		this.remarks = remarks;
	}	
}
