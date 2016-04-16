package com.conference.services.verification.user;

import java.util.UUID;

import com.conference.dataprovider.domain.User;

public class MemcachedUserIdentifierGenerator implements IUserIdentifierGenerator {

	public MemcachedUserIdentifierGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String generate(User user) {
		UUID.randomUUID().toString();
		return null;
	}

}
