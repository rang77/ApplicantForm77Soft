package model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

	@JsonProperty(value = "Id")
	private String id;

	@JsonProperty(value = "Name")
	private String idNumber;

	@JsonProperty(value = "FirstName__c")
	private String firstName;

	@JsonProperty(value = "LastName__c")
	private Date lastName;

	@JsonProperty(value = "MiddleName__c")
	private Date middleName;

	@JsonProperty(value = "SLCredits__c")
	private String slCredits;

	@JsonProperty(value = "VLCredits__c")
	private String vlCredits;

	@JsonProperty(value = "UsedSLCredits__c")
	private String usedSlCredits;

	@JsonProperty(value = "UsedVLCredits__c")
	private String usedVlCredits;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getLastName() {
		return lastName;
	}

	public void setLastName(Date lastName) {
		this.lastName = lastName;
	}

	public Date getMiddleName() {
		return middleName;
	}

	public void setMiddleName(Date middleName) {
		this.middleName = middleName;
	}

	public String getSlCredits() {
		return slCredits;
	}

	public void setSlCredits(String slCredits) {
		this.slCredits = slCredits;
	}

	public String getVlCredits() {
		return vlCredits;
	}

	public void setVlCredits(String vlCredits) {
		this.vlCredits = vlCredits;
	}

	public String getUsedSlCredits() {
		return usedSlCredits;
	}

	public void setUsedSlCredits(String usedSlCredits) {
		this.usedSlCredits = usedSlCredits;
	}

	public String getUsedVlCredits() {
		return usedVlCredits;
	}

	public void setUsedVlCredits(String usedVlCredits) {
		this.usedVlCredits = usedVlCredits;
	}

}
