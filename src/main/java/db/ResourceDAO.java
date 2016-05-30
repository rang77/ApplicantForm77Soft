package db;

import java.util.List;

import model.Resource;

public class ResourceDAO extends SalesforceDAO<Resource> {

	public static final Class<Resource> DAOTABLE = Resource.class;	
	
	public Resource retrieveResource(String id){
		connect();
		
		List<Resource> result = retrieve(
				String.format(
						"SELECT id,Name,IDNumber__c,FirstName__c,"
								+ "LastName__c,MiddleName__c,SickLeaveEntitlement__c,"
								+ "SickLeavesUsed__c,VacationLeavesUsed__c,VacationLeaveEntitlement__c,"
								+ "ImmediateManagerName__c, ImmediateManagerEmail__c,"
								+ "(SELECT Name, LeaveType__c,StartDate__c,EndDate__c,DaysOnLeave__c,Reason__c,Halfday__c,LeaveStatus__c,"
								+ "CreatedDate FROM LeaveRequest__r ORDER BY CreatedDate DESC)"
								+ " FROM Resource__c WHERE Id = '%s'",
						id),
				DAOTABLE);
		
		if(!result.isEmpty()){
			return result.get(0);
		}
		
		return null;		
	}
}
