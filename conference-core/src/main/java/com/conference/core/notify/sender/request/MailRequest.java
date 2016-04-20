package com.conference.core.notify.sender.request;

import javax.mail.Message;

import org.apache.commons.lang3.Validate;

public class MailRequest implements IRequest<Message>{

	private Message message;
	
	public MailRequest(Message message) {
		Validate.notNull(message);
		this.message = message;
	}
	
	@Override
	public Message getRequest() {
		return message;
	}

}
