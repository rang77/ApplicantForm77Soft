package db;

import java.util.List;

import model.ResourceLogin;

public class ResourceLoginDAO extends SalesforceDAO<ResourceLogin> {
	
	public static final Class<ResourceLogin> DAOTABLE = ResourceLogin.class;

	public ResourceLogin retrieveLogin(String email){
		connect();
		
		List<ResourceLogin> result = retrieve(String.format("SELECT Email__c, Active__c, AskedForNewPassword__c, Resource__c, Salt__c" +
											" FROM ResourceLogin__c WHERE Email__c = '%s'"
											,email), DAOTABLE);
		
		if(!result.isEmpty()){
			return result.get(0);
		}
		
		return null;
	}
}
