package com.conference.services.common.sender;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.springframework.jms.core.JmsTemplate;

public class ActiveMQNotificationSender<T extends Serializable> implements INotificationSender<T> {

	private Map<Action, JmsTemplate> jmsTemplates;
	
	public ActiveMQNotificationSender(Map<Action, JmsTemplate> jmsTemplates) {
		Validate.notEmpty(jmsTemplates);
		this.jmsTemplates = jmsTemplates;
	}
	
	@Override
	public void send(T entity, Action action) {
		JmsTemplate jmsTemplate = jmsTemplates.get(action);
		if (jmsTemplate == null) {
			//logging
			return;
		}
		jmsTemplate.send(new DefaultMessageCreator<Serializable>(entity));
	}

}
