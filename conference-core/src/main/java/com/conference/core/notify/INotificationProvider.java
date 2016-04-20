package com.conference.core.notify;

import com.conference.core.notify.payload.IPayload;
import com.conference.core.notify.payload.messages.IMessage;
import com.conference.core.notify.payload.recipients.IRecipient;

public interface INotificationProvider<MessageType extends IMessage, RecipientType extends IRecipient> {
	void provide(IPayload<MessageType,RecipientType> payload);
}
