package com.conference.dataprovider.dao.impl.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.conference.dataprovider.dao.IUserDao;
import com.conference.dataprovider.domain.User;

@Repository("hibernateUserDao")
public class HibernateUserDao implements IUserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User readUserByUsername(String username) {
		return sessionFactory.getCurrentSession().get(User.class, username);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> readUsers() {
		return sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> readUsers(int page, int pageSize) {
		return sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setFirstResult((page - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

}
