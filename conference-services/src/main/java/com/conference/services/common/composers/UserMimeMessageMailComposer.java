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
import com.conference.services.verification.user.IUserVerifyUrlGenerator;

public class UserMimeMessageMailComposer implements
		IMessageComposer<User, MimeMessage> {

	private static final String SUBJECT = "%s - email verification";

	private ITransformer<File, String> transformer;
	private ISessionProvider<MimeMessage> sessionProvider;
	private IUserVerifyUrlGenerator urlGenerator;
	private File template;

	public UserMimeMessageMailComposer(ITransformer<File, 
			String> transformer,
			ISessionProvider<MimeMessage> sessionProvider, 
			IUserVerifyUrlGenerator urlGenerator,
			File template) {
		Validate.notNull(transformer);
		Validate.notNull(sessionProvider);
		Validate.notNull(urlGenerator);
		Validate.notNull(template);
		this.transformer = transformer;
		this.sessionProvider = sessionProvider;
		this.urlGenerator = urlGenerator;
		this.template = template;
	}

	@Override
	public MimeMessage compose(User user) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			String token = urlGenerator.generateToken(user);
			params.put("firstname", user.getFirstname());
			params.put("lastname", user.getLastname());
			params.put("verifyUrl", urlGenerator.generateVerifyUrl(token));
			params.put("rejectUrl", urlGenerator.generateRejectUrl(token));
			String emailContent = transformer.transform(template, params);
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
