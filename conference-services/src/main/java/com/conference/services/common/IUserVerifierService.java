package com.conference.services.common;

import com.conference.dataprovider.domain.User;

public interface IUserVerifierService {
	public void sendVerification(User user);
	public void confirmVerification();
}
