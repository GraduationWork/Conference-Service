package com.conference.services.verification.user;

import com.conference.dataprovider.domain.User;

public interface IUserVerifyUrlGenerator {
	public String generateToken(User user);
	public String generateVerifyUrl(String token);
	public String generateRejectUrl(String token);
}
