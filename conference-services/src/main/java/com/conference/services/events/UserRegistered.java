package com.conference.services.events;

import org.springframework.context.ApplicationEvent;

import com.conference.core.domain.User;

public class UserRegistered extends ApplicationEvent {

	private static final long serialVersionUID = -8118035387799912263L;
	
	private User user;
	
	public UserRegistered(Object source, User user) {
		super(source);
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
}
