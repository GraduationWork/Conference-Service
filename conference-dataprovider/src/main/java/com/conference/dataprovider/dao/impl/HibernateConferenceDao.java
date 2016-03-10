package com.conference.dataprovider.dao.impl;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.conference.core.domain.Conference;
import com.conference.dataprovider.dao.IConferenceDao;

@Repository("hibernateConferenceDao")
public class HibernateConferenceDao implements IConferenceDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void createConference(Conference conference) {
		sessionFactory.getCurrentSession().save(conference);
	}

	public Conference readConference(String id) {
		return sessionFactory.getCurrentSession().get(Conference.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Conference> readConferences() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Conference.class)
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Conference> readConferences(int page, int pageSize) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Conference.class)
				.setFirstResult((page - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	public void updateConference(Conference conference) {
		sessionFactory.getCurrentSession().update(conference);
	}

	public void deleteConference(Conference conference) {
		sessionFactory.getCurrentSession().delete(conference);
	}

	public void deleteConferenceById(String id) {
		throw new NotImplementedException("method not implemented");
	}

}
