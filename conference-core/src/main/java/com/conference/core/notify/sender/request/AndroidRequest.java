package com.conference.core.notify.sender.request;

import java.util.List;

import com.google.android.gcm.server.Message;

public class AndroidRequest {
	private Message message;
	private List<String> recipients;
	
	public AndroidRequest(Message message,List<String> recipients) {
		this.message = message;
		this.recipients = recipients;
	}

	public Message getMessage() {
		return message;
	}

	public List<String> getRecipients() {
		return recipients;
	}
	
}
