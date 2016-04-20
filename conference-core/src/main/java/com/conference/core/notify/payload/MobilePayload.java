package com.conference.core.notify.payload;

import java.util.List;

import com.conference.core.notify.payload.messages.TextMessage;
import com.conference.core.notify.payload.recipients.MobileRecipient;

public class MobilePayload implements IPayload<TextMessage, MobileRecipient>{

	@Override
	public TextMessage getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MobileRecipient> getRecipients() {
		// TODO Auto-generated method stub
		return null;
	}

}
