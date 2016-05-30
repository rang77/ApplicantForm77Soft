package db;

import java.util.List;

import model.Login;

public class LoginDAO extends SalesforceDAO<Login> {
	
	public static final Class<Login> DAOTABLE = Login.class;

	public Login retrieveLogin(String email){
		connect();
		
		List<Login> result = retrieve(String.format("SELECT Email__c, Active__c, AskedForNewPassword__c, Resource__c, Salt__c" +
											" FROM Login__c WHERE Email__c = '%s'"
											,email), DAOTABLE);
		
		if(!result.isEmpty()){
			return result.get(0);
		}
		
		return null;
	}
}
