package model.messages;

import java.util.ArrayList;
import java.util.List;

public class PageMessages {
	
	private List<PageMessage> pageMessages;
	
	public PageMessages() {
		pageMessages = new ArrayList<>();
	}
	
	public List<PageMessage> getPageMessages() {
		return pageMessages;
	}

	private void addMessage(PageMessage.Type type, String message) {
		pageMessages.add(new PageMessage(type, message));
	}
	
	public void addInfoMessage(String message) {
		addMessage(PageMessage.Type.INFO, message);
	}
	
	public void addSuccessMessage(String message) {
		addMessage(PageMessage.Type.SUCCESS, message);
	}
	
	public void addWarningMessage(String message) {
		addMessage(PageMessage.Type.WARNING, message);
	}
	
	public void addErrorMessage(String message) {
		addMessage(PageMessage.Type.ERROR, message);
	}

}
