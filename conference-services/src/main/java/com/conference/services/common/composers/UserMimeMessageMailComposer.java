package com.conference.services.common.composers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.Validate;

import com.conference.dataprovider.domain.User;
import com.conference.services.common.mail.ISessionProvider;
import com.conference.services.common.transformers.ITransformer;
import com.conference.services.exceptions.ServiceException;

public class UserMimeMessageMailComposer implements
		IMessageComposer<User, MimeMessage> {

	private static final String SUBJECT = "%s - email verification";

	private ITransformer<File, String> transformer;
	private ISessionProvider<MimeMessage> sessionProvider;

	// private IMailConfiguration configuration;

	public UserMimeMessageMailComposer(ITransformer<File, String> transformer,
			ISessionProvider<MimeMessage> sessionProvider) {
		Validate.notNull(transformer);
		Validate.notNull(sessionProvider);
		// Validate.notNull(configuration);
		this.transformer = transformer;
		this.sessionProvider = sessionProvider;
		// this.configuration = configuration;
	}

	@Override
	public MimeMessage compose(User user) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("name", user.getUsername());
			String emailContent = transformer
					.transform(
							new File(this.getClass()
									.getResource("/xslt/invitation.xslt").toURI()),
							params);
			MimeMessage message = sessionProvider.createMessage();
			message.setFrom(new InternetAddress("conference@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(user.getEmail()));
			message.setSubject(String.format(SUBJECT, user.getUsername()));
			message.setContent(emailContent, "text/html; charset=utf-8");
			return message;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

}
