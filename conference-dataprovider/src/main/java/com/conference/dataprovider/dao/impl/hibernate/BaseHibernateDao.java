package com.conference.dataprovider.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseHibernateDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
