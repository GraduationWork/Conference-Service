package com.conference.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conference.dataprovider.dao.IConferenceDao;
import com.conference.dataprovider.domain.Conference;
import com.conference.services.IConferenceService;


//@Service("conferenceServiceImpl")
public class ConferenceServiceImpl implements IConferenceService{

	private IConferenceDao conferenceDao;

//	@Autowired
	public ConferenceServiceImpl(IConferenceDao conferenceDao) {
		this.conferenceDao = conferenceDao;
	}
	
	@Override
	public void createConference(Conference conference) {
		conferenceDao.createConference(conference);
	}

	@Override
	public Conference getConference(String id) {
		return conferenceDao.readConference(id);
	}

	@Override
	public void updateConference(Conference conference) {
		conferenceDao.updateConference(conference);
	}

	@Override
	public List<Conference> getConferences() {
		return conferenceDao.readConferences();
	}

	@Override
	public List<Conference> getConferences(int page, int pageSize) {
		return conferenceDao.readConferences(page, pageSize);
	}

	@Override
	public Date getUpdateDate(String id) {
		return conferenceDao.readUpdateDate(id);
	}
	
}
