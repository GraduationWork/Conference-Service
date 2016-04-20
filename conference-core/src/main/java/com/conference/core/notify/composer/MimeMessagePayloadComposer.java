package com.conference.core.notify.composer;

import java.io.File;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.Validate;

import com.conference.core.notify.composer.transformer.ITransformer;
import com.conference.core.notify.payload.IPayload;
import com.conference.core.notify.payload.messages.KeyValueMessage;
import com.conference.core.notify.payload.recipients.MailRecipient;
import com.conference.core.notify.providers.ISessionProvider;
import com.conference.core.notify.sender.request.MailRequest;

public class MimeMessagePayloadComposer implements IPayloadComposer<MailRequest, KeyValueMessage, MailRecipient>{

	private static final String SUBJECT = "%s - email verification";
	
	private ITransformer<File, String> transformer;
	private ISessionProvider<MimeMessage> sessionProvider;
	private File template;
	
	public MimeMessagePayloadComposer(ITransformer<File, String> transformer,
			ISessionProvider<MimeMessage> sessionProvider,
			File template) {
		Validate.notNull(transformer);
		Validate.notNull(sessionProvider);
		Validate.notNull(template);
		this.transformer = transformer;
		this.sessionProvider = sessionProvider;
		this.template = template;
	}
	
	@Override
	public MailRequest compose(IPayload<KeyValueMessage, MailRecipient> payload) {
		try {
			KeyValueMessage message = payload.getMessage();
			List<MailRecipient> recipients = payload.getRecipients();
			String emailContent = transformer.transform(template, message.getMessage());
			MimeMessage mimeMessage = sessionProvider.createMessage();
			mimeMessage.setFrom(new InternetAddress("conference@gmail.com"));
			mimeMessage.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse((String) message.getMessage().get("email")));
			mimeMessage.setSubject(String.format(SUBJECT, message.getMessage().get("name")));
			mimeMessage.setContent(emailContent, "text/html; charset=utf-8");
			return new MailRequest(mimeMessage);
		} catch(Exception e) {
			throw new RuntimeException("Composing error");
		}
	}


}
