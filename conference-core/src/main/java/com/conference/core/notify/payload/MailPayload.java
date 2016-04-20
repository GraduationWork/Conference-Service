package com.conference.core.notify.payload;

import java.util.Arrays;
import java.util.List;

import com.conference.core.notify.payload.messages.IMessage;
import com.conference.core.notify.payload.messages.KeyValueMessage;
import com.conference.core.notify.payload.recipients.IRecipient;
import com.conference.core.notify.payload.recipients.MailRecipient;

public class MailPayload implements IPayload<KeyValueMessage, MailRecipient>{

	private KeyValueMessage message;
	private MailRecipient recipient;
	
	public MailPayload(KeyValueMessage message, MailRecipient recipient) {
		this.message = message;
		this.recipient = recipient;
	}
	
	@Override
	public KeyValueMessage getMessage() {
		return message;
	}

	@Override
	public List<MailRecipient> getRecipients() {
		return Arrays.asList(recipient);
	}


}
