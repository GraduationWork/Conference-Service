package com.conference.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conference.dataprovider.dao.IUserDao;
import com.conference.dataprovider.domain.User;
import com.conference.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	
	@Autowired
	public UserServiceImpl(IUserDao userDao) {
		this.userDao = userDao;
	} 
	
	@Override
	public void createUser(User user) {
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
