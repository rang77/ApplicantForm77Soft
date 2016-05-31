package db;

import java.util.List;

import model.LeaveRequest;
import model.Login;

public class LeaveRequestDAO extends SalesforceDAO<LeaveRequest> {

	public static final Class<LeaveRequest> DAOTABLE = LeaveRequest.class;	
	
	public String createLeaveRequest(LeaveRequest leaveRequest){
		connect();
		return create("LeaveRequest__c", leaveRequest);
	}
	
	public void updateLeaveRequest(LeaveRequest request){
		connect();
		update("LeaveRequest__c", request);
	}
	
	public LeaveRequest retrieveRequestById(String id){
		connect();
		
		List<LeaveRequest> result = retrieve(String.format("SELECT Id, Name, Resource__c, StartDate__c, EndDate__c, LeaveType__c,"
				+ "Reason__c, Halfday__c, ApprovalCode__c, Remarks__c, LeaveStatus__c" +
				" FROM LeaveRequest__c WHERE Id = '%s'"
				,id), DAOTABLE);
		
		if(!result.isEmpty()){
			return result.get(0);
		}
		
		return null;
	}
	
}
