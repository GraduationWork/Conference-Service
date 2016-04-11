package com.conference.services;

import com.conference.dataprovider.domain.User;

public interface IUserService {
	public void createUser(User user);
	public User getUser(String username);
	public void activateUser(String username, boolean isActive);
}
