package com.conference.services.common.mail;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.Validate;
import org.springframework.mail.javamail.JavaMailSender;

public class SpringMailSender implements IMailSender<MimeMessage>, ISessionProvider<MimeMessage>{

	private JavaMailSender mailSender;
	
	public SpringMailSender(JavaMailSender mailSender) {
		Validate.notNull(mailSender);
		this.mailSender = mailSender;
	}
	
	@Override
	public void send(MimeMessage message) {
		mailSender.send(message);
		
	}

	@Override
	public MimeMessage createMessage() {
		return mailSender.createMimeMessage();
	}

}
