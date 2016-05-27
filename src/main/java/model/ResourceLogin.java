package model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceLogin {

	@JsonProperty(value = "Id")
	private String id;
	
	@JsonProperty(value = "Email__c")
	private String email;
	
	@JsonProperty(value = "Password__c")
	private String password;
	
	@JsonProperty(value = "Salt__c")
	private String salt;
	
	@JsonProperty(value = "Resource__c")
	private String resource;
	
	@JsonProperty(value = "ForgotPassword__c")
	private boolean forgotPassword;
	
	@JsonProperty(value = "ForgotPasswordDate__c")
	private boolean forgotPasswordDate;
	
	@JsonProperty(value = "Active__c")
	private boolean active;
	
	@JsonProperty(value = "ActivationCode__c")
	private String activationCode;
	
	@JsonProperty(value = "AskedForNewPassword__c")
	private boolean askedForNewPassword;
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public boolean isForgotPassword() {
		return forgotPassword;
	}
	public void setForgotPassword(boolean forgotPassword) {
		this.forgotPassword = forgotPassword;
	}
	public boolean isForgotPasswordDate() {
		return forgotPasswordDate;
	}
	public void setForgotPasswordDate(boolean forgotPasswordDate) {
		this.forgotPasswordDate = forgotPasswordDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public boolean isAskedForNewPassword() {
		return askedForNewPassword;
	}
	public void setAskedForNewPassword(boolean askedForNewPassword) {
		this.askedForNewPassword = askedForNewPassword;
	}
}
