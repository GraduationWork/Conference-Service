package com.conference.dataprovider.dao;

import java.util.List;

import com.conference.core.domain.User;

public interface IUserDao {
	public void createUser(User user);
	public User readUserByUsername(String username);
	public List<User> readUsers();
	public List<User> readUsers(int page, int pageSize);
	public void updateUser(User user);
}
