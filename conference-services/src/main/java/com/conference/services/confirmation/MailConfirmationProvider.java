package com.conference.services.confirmation;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.Validate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.conference.dataprovider.domain.User;
import com.conference.services.mail.IMessageComposer;

public class MailConfirmationProvider implements IConfirmationProvider{

	private JavaMailSender mailSender;
	private IMessageComposer messageComposer
	
	public MailConfirmationProvider(JavaMailSender mailSender) {
		Validate.notNull(mailSender);
		this.mailSender = mailSender;
	}
	
	@Override
	public void sendConfirmation(User user) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo("aliaksandr.kassirau@gmail.com");
			helper.setFrom("registration@conference.com");
			helper.setSubject(String.format("%s registration confirm required" , user.getUsername()));
			mailSender.send(helper.getMimeMessage());
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
