package model.messages;

public class PageMessage {

	public enum Type {
		INFO, SUCCESS, WARNING, ERROR;
	}
	
	private Type type;
	private String message;

	public PageMessage(Type type, String message) {
		super();
		this.type = type;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	public boolean isInfo() {
		return type.equals(Type.INFO);
	}
	
	public boolean isSuccess() {
		return type.equals(Type.SUCCESS);
	}
	
	public boolean isWarning() {
		return type.equals(Type.WARNING);
	}
	
	public boolean isError() {
		return type.equals(Type.ERROR);
	}

}
