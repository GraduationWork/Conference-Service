package com.conference.core.notify.payload.recipients;


public class MailRecipient implements IRecipient<String>{ //should be replaced by email object

	private String email;
	
	public MailRecipient(String email) {
		this.email = email;
	}
	
	@Override
	public String getRecipient() {
		return email;
	}

}
