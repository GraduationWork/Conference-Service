package com.conference.dataprovider.dao.impl.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.conference.core.domain.User;
import com.conference.dataprovider.dao.IUserDao;

@Repository
public class HibernateUserDao extends BaseHibernateDao implements IUserDao{
	
	@Override
	public void createUser(User user) {
		getSession().save(user);
	}

	@Override
	public boolean exists(String username) {
		User user = getSession().get(User.class, username);
		return user != null;
	}

	@Override
	public User readUserByUsername(String username) {
		return getSession().get(User.class, username);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> readUsers() {
		return getSession().createCriteria(User.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> readUsers(int page, int pageSize) {
		return  getSession()
				.createCriteria(User.class)
				.setFirstResult((page - 1) * pageSize )
				.setMaxResults(pageSize)
				.list();
	}

	@Override
	public void updateUser(User user) {
		getSession().update(user);
	}

	@Override
	public void activateUser(String username, boolean active) {
		User user = getSession().get(User.class, username);
		user.setIsActive(active);
		getSession().update(user);
	}

	@Override
	public void deleteUser(String username) {
		getSession().delete(getSession().get(User.class, username));
	}
	
}
