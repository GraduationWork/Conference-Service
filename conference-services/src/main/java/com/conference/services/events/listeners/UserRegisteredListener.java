package com.conference.services.events.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.conference.core.domain.User;
import com.conference.services.events.UserRegistered;
import com.google.common.base.Preconditions;

@Component
public class UserRegisteredListener implements ApplicationListener<UserRegistered>{

	@Override
	public void onApplicationEvent(UserRegistered event) {
		Preconditions.checkNotNull(event);
		User user = event.getUser();
		//send to user
	}

}
