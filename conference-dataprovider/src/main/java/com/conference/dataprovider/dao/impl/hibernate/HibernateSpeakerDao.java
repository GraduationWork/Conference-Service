package com.conference.dataprovider.dao.impl.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

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

	@Override
	public List<Speaker> readSpeakersByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Speaker> readSpeakers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Speaker> readSpeakers(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSpeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSpeakerById(String id) {
		// TODO Auto-generated method stub
		
	}

}
