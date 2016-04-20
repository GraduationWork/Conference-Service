package com.conference.services.common.listeners;

import java.io.Serializable;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.Validate;

import com.conference.core.domain.User;
import com.conference.services.common.composers.IMessageComposer;
import com.conference.services.common.mail.IMailSender;

public class UserVerificationMessageHandler implements IMessageHandler {

	private IMailSender<MimeMessage> mailSender;
	private IMessageComposer<User, MimeMessage> messageComposer;
	
	public UserVerificationMessageHandler(IMailSender<MimeMessage> mailSender,
			IMessageComposer<User, MimeMessage> messageComposer) {
		Validate.notNull(mailSender);
		Validate.notNull(messageComposer);
		this.mailSender = mailSender;
		this.messageComposer = messageComposer;
	}
	
	
	@Override
	public void handleMessage(Serializable message) {
		if (message instanceof User) {
			User user = (User) message;
			MimeMessage mailMessage = messageComposer.compose(user);
			mailSender.send(mailMessage);
		} else {
			//logging
		}
	}

}
