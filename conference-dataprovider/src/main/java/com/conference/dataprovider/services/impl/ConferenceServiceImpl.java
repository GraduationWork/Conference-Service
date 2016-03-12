package com.conference.dataprovider.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conference.core.domain.Conference;
import com.conference.dataprovider.dao.IConferenceDao;
import com.conference.dataprovider.services.IConferenceService;


@Service("conferenceServiceImpl")
@Transactional
public class ConferenceServiceImpl implements IConferenceService{

	@Autowired
	private IConferenceDao conferenceDao;
	
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
