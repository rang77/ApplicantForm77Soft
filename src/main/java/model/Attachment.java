package model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Attachment implements SalesforceObject {
	
	public static final long MAX_FILE_SIZE = (1024*1024)*5;	
	
	@JsonProperty(value = "Id")
	private String id;
	
	@JsonProperty(value = "ParentId")
	private String parentId;
	
	@JsonProperty(value = "Name")
	private String name;
	
	@JsonProperty(value = "Body")
	private byte[] body;
	
	public Attachment(int fileSize){
		body = new byte[fileSize];
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public byte[] getBody() {
		return body;
	}

	public void setBody(byte[] body) {
		this.body = body;
	}	
}
