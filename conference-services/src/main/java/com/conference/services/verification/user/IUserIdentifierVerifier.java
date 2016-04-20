package com.conference.services.verification.user;

import com.conference.core.domain.User;

public interface IUserIdentifierVerifier {
	public User verifyToken(String token);
	public void rejectToken(String token);
}
