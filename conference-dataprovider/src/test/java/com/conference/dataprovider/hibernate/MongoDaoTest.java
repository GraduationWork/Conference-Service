package com.conference.dataprovider.hibernate;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.conference.dataprovider.dao.IConferenceDao;
import com.conference.dataprovider.dao.ISpeakersDao;
import com.conference.dataprovider.domain.Conference;
import com.conference.dataprovider.domain.Speaker;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dp-context.xml" })
public class MongoDaoTest {

	@Autowired
//	@Qualifier("hibernateConferenceDao")
	private IConferenceDao conferenceDao;
	
	@Autowired
//	@Qualifier("hibernateSpeakerDao")
	private ISpeakersDao speakersDao;
	
	@Test
	public void creationTest() {
		Speaker speaker = new Speaker();
		speaker.setId("1-Aliaksandr-Kassirau");
		speaker.setName("Aliaksandr Kassirau");
		speaker.setTitle("Software Engineer");
		speaker.setPhotoUrl("url");
		
		speakersDao.createSpeaker(speaker);
		
		Conference conference = new Conference();
		conference.setId("1-test-conference");
		conference.setStakeholders(Arrays.asList("For developers", "For testers"));
		conference.setSpeakers(Arrays.asList(speaker));
		
		conferenceDao.createConference(conference);

		Conference conference2 = conferenceDao.readConference("1-test-conference");
		
		speaker.setName("Aliaksandr Kassirau updated");
		speakersDao.updateSpeaker(speaker);
		Conference conference3 = conferenceDao.readConference("1-test-conference");
	}
	
}
