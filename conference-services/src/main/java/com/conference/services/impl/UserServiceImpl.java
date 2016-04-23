package com.conference.services.impl;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conference.core.domain.User;
import com.conference.dataprovider.dao.IUserDao;
import com.conference.services.IUserService;
import com.conference.services.events.UserRegistered;
import com.conference.services.exceptions.UserAlreadyExistException;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
    private ApplicationEventPublisher eventPublisher;

	@Autowired
	public UserServiceImpl(IUserDao userDao,
			ApplicationEventPublisher eventPublisher) {
		Validate.notNull(userDao);
		Validate.notNull(eventPublisher);
		this.userDao = userDao;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public void registerUser(User user) {
		if (isUsernameExist(user.getUsername())) {
			throw new UserAlreadyExistException(String.format(
					"%s already registered in the system", user.getUsername()));
		}
		userDao.createUser(user);
		eventPublisher.publishEvent(new UserRegistered(this, user));
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
