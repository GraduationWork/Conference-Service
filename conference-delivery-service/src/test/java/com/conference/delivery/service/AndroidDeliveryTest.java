package com.conference.delivery.service;

import java.io.IOException;

import org.junit.Test;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Notification;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

public class AndroidDeliveryTest {

	@Test
	public void deliveryTest() throws IOException {
		Sender sender = new Sender("AIzaSyC6qjmx1kdVdiBFRbU7dAt_1M3DfyLTuXQ");
		String deviceToken = "c6Z2_3wxMTQ:APA91bFGtV0Znwnd8L6csj8LhPXia3-1bCDqjxqzCy0OpwZ22Z4xMLtyGBBwAPQRbk30lFGdM3bAAJ2ZlRhXhdgbteJgfbAuXEEllc7Y7aLGe1w5-HyT9mMSTjffnJ880o33v72evHSc";
		
		Message message = new Message.Builder()
				.addData("message", "Hello Aliaksandr")
				.addData("title", "Welcome message")
				.notification(new Notification.Builder("default")
					.title("Test message")
					.badge(1)
					.body("")
					.color("#ffffff")
					.build())
				.build();
		
		Result result = sender.send(message, deviceToken, 1);
		
		result.getFailure();
	}
	
}
