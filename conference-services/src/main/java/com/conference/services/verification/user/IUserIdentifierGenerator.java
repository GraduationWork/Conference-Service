package com.conference.services.verification.user;

import com.conference.dataprovider.domain.User;

public interface IUserIdentifierGenerator {
	public String generate(User user);
}
