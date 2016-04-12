package com.conference.dataprovider.dao;

import java.util.List;

import com.conference.dataprovider.domain.User;

public interface IUserDao {
	public void createUser(User user);
	public boolean exists(String username);
	public User readUserByUsername(String username);
	public List<User> readUsers();
	public List<User> readUsers(int page, int pageSize);
	public void updateUser(User user);
	public void activateUser(String username, boolean active);
}
