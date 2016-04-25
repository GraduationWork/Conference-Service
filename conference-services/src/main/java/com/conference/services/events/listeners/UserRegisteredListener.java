package com.conference.services.events.listeners;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.conference.core.amq.DefaultMessageCreator;
import com.conference.core.domain.User;
import com.conference.core.notify.payload.IPayload;
import com.conference.core.notify.payload.MailPayload;
import com.conference.core.notify.payload.messages.KeyValueMessage;
import com.conference.core.notify.payload.recipients.MailRecipient;
import com.conference.services.events.UserRegistered;
import com.google.common.base.Preconditions;

@Component
public class UserRegisteredListener implements ApplicationListener<UserRegistered>{

	@Autowired
	@Qualifier("userVerificationJmsTemplate")
	private JmsTemplate template;
	
	
	@Override
	public void onApplicationEvent(UserRegistered event) {
		Preconditions.checkNotNull(event);
		User user = event.getUser();
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("firstname", user.getFirstname());
		params.put("lastname", user.getLastname());
		params.put("verification.url", "");
		KeyValueMessage message = new KeyValueMessage(params);
		MailRecipient recipient = new MailRecipient(user.getEmail());
		IPayload payload = new MailPayload(message, recipient);
		template.send(new DefaultMessageCreator<IPayload>(payload));
	}

}
