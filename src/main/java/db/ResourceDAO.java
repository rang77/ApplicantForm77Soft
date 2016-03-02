package db;

import java.util.List;

import model.Resource;

public class ResourceDAO extends SalesforceDAO<Resource> {

	public Resource retrieveResouce(String id) {
		
		connect();
		
		List<Resource> result = retrieve(
				String.format(
						"SELECT id,Name,IDNumber__c,FirstName__c,"
								+ "LastName__c,MiddleName__c,SickLeaveEntitlement__c,"
								+ "SickLeavesUsed__c,VacationLeavesUsed__c,VacationLeaveEntitlement__c,"
								+ "(SELECT Name, LeaveType__c,StartDate__c,EndDate__c,DaysOnLeave__c,Reason__c,"
								+ "CreatedDate FROM LeaveRequest__r ORDER BY CreatedDate DESC)"
								+ " FROM Resource__c WHERE IDNumber__c LIKE '%s'",
						id),
				Resource.class);
		
		if(!result.isEmpty()){
			return result.get(0);
		}
		
		return null;
	}

}
