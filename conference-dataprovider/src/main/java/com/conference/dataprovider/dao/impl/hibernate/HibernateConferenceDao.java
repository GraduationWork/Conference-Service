package com.conference.dataprovider.dao.impl.hibernate;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.conference.dataprovider.dao.IConferenceDao;
import com.conference.dataprovider.domain.Conference;

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

	@Override
	public Date readUpdateDate(String id) {
		Timestamp timestamp = (Timestamp) sessionFactory.getCurrentSession()
				.createCriteria(Conference.class)
				.setProjection(Projections.property("updated"))
				.add(Restrictions.eq("id", id))
				.setMaxResults(1)
				.list()
				.get(0);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timestamp.getTime());
		return calendar.getTime();
	}

}
