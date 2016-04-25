package com.conference.core.amq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

public class MessageListenerContainer extends DefaultMessageListenerContainer{

	@Autowired
	public MessageListenerContainer(CachingConnectionFactory connectionFactory, MessageListenerAdapter messageListener,
			int concurrentConsumers, boolean sessionTransacted, JmsTransactionManager transactionManager, String queueName) {
		super();
		
		Validate.notNull(connectionFactory);
		Validate.notNull(messageListener);
		Validate.notNull(transactionManager);
		Validate.notEmpty(queueName);
		Validate.isTrue(concurrentConsumers > 0);
		
		super.setConnectionFactory(connectionFactory);
		super.setMessageListener(messageListener);
		super.setTransactionManager(transactionManager);
		super.setSessionTransacted(sessionTransacted);
		super.setConcurrentConsumers(concurrentConsumers);
		super.setDestination(new ActiveMQQueue(queueName));
	}
	
}
