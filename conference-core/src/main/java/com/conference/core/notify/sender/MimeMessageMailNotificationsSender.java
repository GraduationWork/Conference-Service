package com.conference.core.notify.sender;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.Validate;
import org.springframework.mail.javamail.JavaMailSender;

import com.conference.core.notify.providers.ISessionProvider;
import com.conference.core.notify.sender.request.IRequest;

public class MimeMessageMailNotificationsSender implements ISender<MimeMessage>, ISessionProvider<MimeMessage>{

	private JavaMailSender mailSender;
	
	public MimeMessageMailNotificationsSender(JavaMailSender mailSender) {
		Validate.notNull(mailSender);
		this.mailSender = mailSender;
	}

	@Override
	public void send(IRequest<MimeMessage> request) {
		MimeMessage message = request.getRequest();
		mailSender.send(message);
	}

	@Override
	public MimeMessage createMessage() {
		return mailSender.createMimeMessage();
	}

	
}
