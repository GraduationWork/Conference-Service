package com.conference.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conference.core.domain.Conference;
import com.conference.dataprovider.dao.IConferenceDao;
import com.conference.services.IConferenceService;
import com.conference.services.events.ConferenceCreated;


@Service("conferenceServiceImpl")
@Transactional
public class ConferenceServiceImpl implements IConferenceService{

	private IConferenceDao conferenceDao;
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	public ConferenceServiceImpl(IConferenceDao conferenceDao,
			ApplicationEventPublisher eventPublisher) {
		this.conferenceDao = conferenceDao;
		this.eventPublisher = eventPublisher;
	}
	
	@Override
	public void createConference(Conference conference) {
		conferenceDao.createConference(conference);
		eventPublisher.publishEvent(new ConferenceCreated(this,conference));
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
	public void deleteConference(String id) {
		conferenceDao.deleteConferenceById(id);
	}

}
