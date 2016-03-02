package db;

import model.LeaveRequest;

public class LeaveRequestDAO extends SalesforceDAO<LeaveRequest> {

	public String createLeaveRequest(LeaveRequest leaveRequest){
		connect();
		return create("LeaveRequest__c", leaveRequest);
	}
	
}
