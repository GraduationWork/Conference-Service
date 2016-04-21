package com.conference.core.notify.sender;

import java.util.List;

import org.apache.commons.lang3.Validate;

import com.conference.core.notify.sender.request.AndroidRequest;
import com.conference.core.notify.sender.request.IRequest;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;

public class BaseGcmPushNotificationsSender implements ISender<AndroidRequest> {

	private Sender sender;
	private int retryCount;

	public BaseGcmPushNotificationsSender(Sender sender,int retryCount) {
		Validate.notNull(sender);
		this.sender = sender;
		this.retryCount = retryCount;
	}

	@Override
	public void send(IRequest<AndroidRequest> request) {
		try {
			AndroidRequest androidRequest = request.getRequest();
			Message message = androidRequest.getMessage();
			List<String> recipients = androidRequest.getRecipients();
			MulticastResult result = sender.send(message, recipients,
					retryCount);
			//send results of delivery to queue for async process
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
