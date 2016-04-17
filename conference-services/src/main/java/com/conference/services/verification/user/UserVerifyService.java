package com.conference.services.verification.user;

import java.util.UUID;

import org.apache.commons.lang3.Validate;

import com.conference.cache.ICacheManager;
import com.conference.dataprovider.domain.User;
import com.conference.services.exceptions.ServiceException;

public class UserVerifyService implements IUserVerifyUrlGenerator,
		IUserIdentifierVerifier {

	private ICacheManager cacheManager;
	private String verifyUrl;
	private String rejectUrl;
	private int keyExpiry;

	public UserVerifyService(ICacheManager cacheManager,
			String verifyUrl,
			String rejectUrl,
			int keyExpiry) {
		Validate.notNull(cacheManager);
		Validate.notEmpty(verifyUrl);
		Validate.notEmpty(rejectUrl);
		Validate.isTrue(keyExpiry > 0);
		this.cacheManager = cacheManager;
		this.verifyUrl = verifyUrl;
		this.rejectUrl = rejectUrl;
		this.keyExpiry = keyExpiry;
	}

	@Override
	public String generateToken(User user) {
		String generatedSessionId = UUID.randomUUID().toString();
		cacheManager.put(generatedSessionId, user, keyExpiry);
		return generatedSessionId;
	}

	@Override
	public String generateVerifyUrl(String token) {
		return String.format(verifyUrl, token);
	}
	
	@Override
	public String generateRejectUrl(String token) {
		return String.format(rejectUrl, token);
	}

	@Override
	public User verifyToken(String token) {
		User user = (User) cacheManager.get(token);
		if (user == null) {
			throw new ServiceException("Invalid user token");
		}
		return user;
	}

	@Override
	public void rejectToken(String token) {
		//token validation since value can be passed to clean cache for any entry
		cacheManager.flush(token);
	}



}
