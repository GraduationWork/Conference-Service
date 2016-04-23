package com.conference.dataprovider.dao.impl.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.conference.core.domain.Conference;
import com.conference.core.domain.Speaker;
import com.conference.dataprovider.dao.ISpeakersDao;


@Repository
public class HibernateSpeakerDao extends BaseHibernateDao implements ISpeakersDao{

	@Override
	public void createSpeaker(Speaker speaker) {
		getSession().save(speaker);		
	}

	@Override
	public Speaker readSpeaker(String id) {
		return getSession().get(Speaker.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Speaker> readSpeakersByName(String name) {
		return getSession().createCriteria(Speaker.class)
				.add(Restrictions.like("name", name))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Speaker> readSpeakers() {
		return getSession().createCriteria(Speaker.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Speaker> readSpeakers(int page, int pageSize) {
		return  getSession()
				.createCriteria(Speaker.class)
				.setFirstResult((page - 1) * pageSize )
				.setMaxResults(pageSize)
				.list();
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		getSession().update(speaker);
	}

	@Override
	public void deleteSpeaker(Speaker speaker) {
		getSession().delete(speaker);
	}

	@Override
	public void deleteSpeakerById(String id) {
		Speaker speaker = new Speaker();
		speaker.setId(id);
		deleteSpeaker(speaker);
	}

}
