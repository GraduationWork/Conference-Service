package com.conference.services.common.sender;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.commons.lang3.Validate;
import org.springframework.jms.core.MessageCreator;

public class DefaultMessageCreator<T extends Serializable> implements MessageCreator {

	private T message;

	public DefaultMessageCreator(T message) {
		Validate.notNull(message);
		this.message = message;
	}
	
	@Override
	public Message createMessage(Session session) throws JMSException {
		return session.createObjectMessage(message);
	}

}
