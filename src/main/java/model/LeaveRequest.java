package model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaveRequest {

	@JsonProperty(value = "Id")
	private String id;

	@JsonProperty(value = "Name")
	private String requestNumber;

	@JsonProperty(value = "Employee__c")
	private Employee employee;

	@JsonProperty(value = "StartDate__c")
	private Date startDate;

	@JsonProperty(value = "EndDate__c")
	private Date endDate;

	@JsonProperty(value = "LeaveType__c")
	private String leaveType;

	@JsonProperty(value = "DaysOnLeave__c")
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public int getDaysOnLeave() {
		return daysOnLeave;
	}

	public void setDaysOnLeave(int daysOnLeave) {
		this.daysOnLeave = daysOnLeave;
	}

}
