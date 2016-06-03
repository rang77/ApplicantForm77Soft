package db;

import java.util.List;

import model.Login;

public class LoginDAO extends SalesforceDAO<Login> {
	
	public static final Class<Login> DAOTABLE = Login.class;

	public Login retrieveLoginByEmail(String email){
		connect();
		
		List<Login> result = retrieve(String.format("SELECT Id, Email__c, Password__c, Active__c, AskForNewPassword__c, Resource__c, Salt__c, ActivationCode__c, ForgotPassword__c" +
											" FROM Login__c WHERE Email__c = '%s'"
											,email), DAOTABLE);
		
		if(!result.isEmpty()){
			return result.get(0);
		}
		
		return null;
	}
	
	public Login retrieveLoginById(String id){
		connect();
		
		List<Login> result = retrieve(String.format("SELECT Id, Email__c, Active__c, AskForNewPassword__c, Resource__c, Salt__c, ActivationCode__c" +
				" FROM Login__c WHERE Id = '%s'"
				,id), DAOTABLE);
		
		if(!result.isEmpty()){
			return result.get(0);
		}
		
		return null;
	}
	
	public Login retrieveLoginByResource(String resourceid){
		connect();
		
		List<Login> result = retrieve(String.format("SELECT Id, Email__c, Password__c, Active__c, AskForNewPassword__c, Resource__c, Salt__c, ActivationCode__c" +
				" FROM Login__c WHERE Resource__c = '%s'"
				,resourceid), DAOTABLE);
		
		if(!result.isEmpty()){
			return result.get(0);
		}
		
		return null;
	}
	
	public void updateLogin(Login login){
		connect();
		update("Login__c", login);
	}
}
