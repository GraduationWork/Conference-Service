package com.conference.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conference.dataprovider.dao.IUserDao;
import com.conference.dataprovider.domain.User;
import com.conference.services.IUserService;
import com.conference.services.confirmation.IConfirmationProvider;

@Service
public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	private IConfirmationProvider confirmationProvider;

	@Autowired
	public UserServiceImpl(IUserDao userDao,
			IConfirmationProvider confirmationProvider) {
		this.userDao = userDao;
		this.confirmationProvider = confirmationProvider;
	}

	@Override
	public void registerUser(User user) {
		userDao.exists(user.getUsername());
		userDao.createUser(user);
	}

	@Override
	public User getUser(String username) {
		return userDao.readUserByUsername(username);
	}

	@Override
	public void activateUser(String username, boolean isActive) {
		userDao.activateUser(username, isActive);
	}

}
