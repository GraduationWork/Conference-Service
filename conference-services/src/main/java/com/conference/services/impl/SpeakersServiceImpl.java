package com.conference.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conference.core.domain.Speaker;
import com.conference.dataprovider.dao.ISpeakersDao;
import com.conference.services.ISpeakersService;

@Service
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

	@Override
	public List<Speaker> getSpeakers() {
		return speakersDao.readSpeakers();
	}

	@Override
	public void deleteSpeakerById(String id) {
		speakersDao.deleteSpeakerById(id);
	}

}
