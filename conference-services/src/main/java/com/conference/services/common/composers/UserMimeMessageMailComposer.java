package com.conference.services.common.composers;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.Validate;

import com.conference.dataprovider.domain.User;
import com.conference.services.common.mail.ISessionProvider;

public class UserMimeMessageMailComposer implements
		IMessageComposer<User, MimeMessage> {

	private static final String SUBJECT = "%s - email verification";
	
	private ITranformationService transformationService;
	private ISessionProvider<MimeMessage> sessionProvider;
	private IMailConfiguration configuration;

	public UserMimeMessageMailComposer(
			ITranformationService transformationService,
			ISessionProvider<MimeMessage> sessionProvider) {
		Validate.notNull(transformationService);
		Validate.notNull(sessionProvider);
		Validate.notNull(configuration);
		this.transformationService = transformationService;
		this.sessionProvider = sessionProvider;
		this.configuration = configuration;
	}

	@Override
	public MimeMessage compose(User user) {
		String emailContent = transformationService.prepareContent();
		MimeMessage message = sessionProvider.createMessage();
		message.setFrom(new InternetAddress(""));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
		message.setSubject(String.format(SUBJECT, user.getUsername()));
		message.setContent(emailContent, "text/html; charset=utf-8");
		return message;
	}

}
