package com.conference.dataprovider.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.conference.core.domain.Speaker;
import com.conference.dataprovider.dao.ISpeakersDao;

@Repository("hibernateSpeakerDao")
public class HibernateSpeakerDao implements ISpeakersDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void createSpeaker(Speaker speaker) {
		sessionFactory.getCurrentSession().save(speaker);
	}

	public Speaker readSpeaker(String id) {
		return sessionFactory.getCurrentSession().get(Speaker.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Speaker> readSpeakersByName(String name) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Speaker.class);
		criteria.add(Restrictions.eq("name", name));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Speaker> readSpeakers() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Speaker.class)
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Speaker> readSpeakers(int page, int pageSize) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Speaker.class)
				.setFirstResult((page - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	public void updateSpeaker(Speaker speaker) {
		sessionFactory.getCurrentSession().update(speaker);
	}

	public void deleteSpeaker(Speaker speaker) {
		sessionFactory.getCurrentSession().delete(speaker);
	}

	public void deleteSpeakerById(String id) {
		Speaker speaker = new Speaker();
		speaker.setId(id);
		sessionFactory.getCurrentSession().delete(speaker);
	}

}
