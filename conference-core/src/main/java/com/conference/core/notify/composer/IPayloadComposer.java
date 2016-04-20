package com.conference.core.notify.composer;

import com.conference.core.notify.payload.IPayload;
import com.conference.core.notify.payload.messages.IMessage;
import com.conference.core.notify.payload.recipients.IRecipient;
import com.conference.core.notify.sender.request.IRequest;

public interface IPayloadComposer<Request extends IRequest, PayloadMessageType extends IMessage, PayloadRequestType extends IRecipient> {
	Request compose(IPayload<PayloadMessageType, PayloadRequestType> payload);
}
