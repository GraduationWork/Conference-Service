package com.conference.core;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.conference.core.notify.INotificationProvider;
import com.conference.core.notify.payload.IPayload;
import com.conference.core.notify.payload.MailPayload;
import com.conference.core.notify.payload.messages.KeyValueMessage;
import com.conference.core.notify.payload.recipients.MailRecipient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-core-context.xml" })
public class MailNotificationProviderTest {

	@Autowired 
	@Qualifier("mailNotificationsProvider")
	private INotificationProvider notificationsProvider;
	
	@Test
	public void test() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", "aliaksandr.kassirau@gmail.com");
		params.put("name", "aliaksandr kassirau");
		KeyValueMessage keyValueMessage = new KeyValueMessage(params);
		MailRecipient mailRecipient = new MailRecipient("aliaksandr.kassirau@gmail.com");
		IPayload<KeyValueMessage, MailRecipient> payload = new MailPayload(keyValueMessage,mailRecipient);
		notificationsProvider.provide(payload);
	}
	
}
