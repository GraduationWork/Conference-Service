package com.conference.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conference.dataprovider.dao.ISpeakersDao;
import com.conference.dataprovider.domain.Speaker;
import com.conference.services.ISpeakersService;

@Service("speakersServiceImpl")
@Transactional
public class SpeakersServiceImpl implements ISpeakersService {

	@Autowired
	private ISpeakersDao speakersDao;
	
	@Override
	public void createSpeaker(Speaker speaker) {
		speakersDao.createSpeaker(speaker);		
	}

	@Override
	public Speaker getSpeaker(String id) {
		return speakersDao.readSpeaker(id);
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		speakersDao.updateSpeaker(speaker);
	}

}
