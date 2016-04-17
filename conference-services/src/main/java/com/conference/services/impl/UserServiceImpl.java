package com.conference.services.impl;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conference.dataprovider.dao.IUserDao;
import com.conference.dataprovider.domain.User;
import com.conference.services.IUserService;
import com.conference.services.common.IUserVerifierService;
import com.conference.services.common.sender.Action;
import com.conference.services.common.sender.INotificationSender;
import com.conference.services.exceptions.UserAlreadyExistException;
import com.conference.services.verification.user.IUserIdentifierVerifier;

@Service
public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	private IUserVerifierService verifierService;
	private INotificationSender<User> notificationSender;

	@Autowired
	public UserServiceImpl(IUserDao userDao,
			IUserVerifierService verifierService,
			IUserIdentifierVerifier userIdentifierVerifier) {
		Validate.notNull(userDao);
		Validate.notNull(verifierService);
		Validate.notNull(userIdentifierVerifier);
		this.userDao = userDao;
		this.verifierService = verifierService;
	}

	@Override
	public void registerUser(User user) {
		if (isUsernameExist(user.getUsername())) {
			throw new UserAlreadyExistException(String.format(
					"%s already registered in the system", user.getUsername()));
		}
		userDao.createUser(user);
		notificationSender.send(user, Action.VERIFY_USER);
	}

	@Override
	public User getUser(String username) {
		return userDao.readUserByUsername(username);
	}

	@Override
	public void activateUser(String username, boolean isActive) {
		userDao.activateUser(username, isActive);
	}

	@Override
	public boolean isUsernameExist(String username) {
		return userDao.exists(username);
	}

	@Override
	public void deleteUser(String username) {
		userDao.deleteUser(username);
	}

}
