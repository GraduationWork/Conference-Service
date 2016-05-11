package com.conference.services;

import com.conference.core.domain.User;

public interface IUserService {
	public void registerUser(User user);
	public User getUser(String username, String password);
	public User getUser(String username);
	public void activateUser(String username, boolean isActive);
	public boolean isUsernameExist(String username);
	public void deleteUser(String username);
}
