package com.conference.core.notify;

import org.apache.commons.lang3.Validate;

import com.conference.core.notify.composer.IPayloadComposer;
import com.conference.core.notify.payload.IPayload;
import com.conference.core.notify.payload.messages.IMessage;
import com.conference.core.notify.payload.recipients.IRecipient;
import com.conference.core.notify.sender.ISender;
import com.conference.core.notify.sender.request.IRequest;
import com.conference.core.notify.validator.IValidator;

public class BaseNotificationsProvider implements INotificationProvider{

	private IValidator<IPayload> validator;
	private IPayloadComposer<IRequest, IMessage, IRecipient> composer;
	private ISender<IRequest> sender; 

	public BaseNotificationsProvider(
			IValidator<IPayload> validator,
			IPayloadComposer<IRequest, IMessage, IRecipient> composer,
			ISender<IRequest> sender) {
		Validate.notNull(validator);
		Validate.notNull(composer);
		Validate.notNull(sender);
		this.validator = validator;
		this.composer = composer;
		this.sender = sender;
	}

	@Override
	public void provide(IPayload payload) {
		validator.validate(payload);
		IRequest request = composer.compose(payload);
		sender.send(request);
	}
	
}
