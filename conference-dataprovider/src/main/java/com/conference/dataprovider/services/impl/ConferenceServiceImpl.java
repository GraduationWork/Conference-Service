package com.conference.dataprovider.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conference.core.domain.Conference;
import com.conference.dataprovider.services.IConferenceService;


@Service("conferenceServiceImpl")
@Transactional
public class ConferenceServiceImpl implements IConferenceService{

//	@Autowired
//	private I
	//Factory
	
	@Override
	public void createConference(Conference conference) {
		
	}

	@Override
	public Conference getConference(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateConference(Conference conference) {
		// TODO Auto-generated method stub
		
	}
	
}
