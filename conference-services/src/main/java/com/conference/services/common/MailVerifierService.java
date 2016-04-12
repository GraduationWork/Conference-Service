package com.conference.services.common;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.Validate;

import com.conference.dataprovider.domain.User;
import com.conference.services.common.composers.IMessageComposer;
import com.conference.services.common.mail.IMailSender;

public class MailVerifierService implements IUserVerifierService {

	private IMailSender<MimeMessage> mailSender;
	private IMessageComposer<User, MimeMessage> messageComposer;

	public MailVerifierService(IMailSender<MimeMessage> mailSender,
			IMessageComposer<User, MimeMessage> messageComposer) {
		Validate.notNull(mailSender);
		Validate.notNull(messageComposer);
		this.mailSender = mailSender;
		this.messageComposer = messageComposer;
	}

	@Override
	public void sendVerification(User user) {
		MimeMessage message = messageComposer.compose(user);
		mailSender.send(message);
	}

	@Override
	public void confirmVerification() {
		// TODO Auto-generated method stub
	}

}
