package com.conference.services.mail;

import org.springframework.mail.javamail.JavaMailSender;

public class MailSender implements IMessageSender {
	private IMessageComposer messageComposer;
	private JavaMailSender mailSender;
	
	@Override
	public void send() {
		mailSender.send(arg0);
	}
	
}
