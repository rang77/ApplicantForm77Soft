package db;

import model.LeaveRequest;

public class LeaveRequestDAO extends SalesforceDAO<LeaveRequest> {

	public static final Class<LeaveRequest> DAOTABLE = LeaveRequest.class;	
	
	public String createLeaveRequest(LeaveRequest leaveRequest){
		connect();
		return create("LeaveRequest__c", leaveRequest);
	}
	
}
