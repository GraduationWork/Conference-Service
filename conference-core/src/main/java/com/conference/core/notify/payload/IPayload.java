package com.conference.core.notify.payload;

import java.io.Serializable;
import java.util.List;

import com.conference.core.notify.payload.messages.IMessage;
import com.conference.core.notify.payload.recipients.IRecipient;

public interface IPayload<MessageType extends IMessage, RecipientType extends IRecipient>  extends Serializable{
	MessageType getMessage();
	List<RecipientType> getRecipients();
}
