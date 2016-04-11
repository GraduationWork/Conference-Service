package com.conference.dataprovider.hibernate;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.conference.dataprovider.dao.ISpeakersDao;
import com.conference.dataprovider.domain.Speaker;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dp-context.xml" })
@Transactional
public class HibernateSpeakerDaoTest {

	public static final int SPEAKERS_COUNT = 10;
	
	
	@Autowired
	@Qualifier("hibernateSpeakerDao")
	private ISpeakersDao speakersDao;
	
	@Before
	@Transactional
	public void createTest() {
		for (int i = 0; i < SPEAKERS_COUNT; i++) {
			Speaker speaker = new Speaker();
			speaker.setName(String.format("Test name %s", i));
			speaker.setTitle(String.format("Test title %s", i));
			speaker.setPhotoUrl(String.format("Test photoUrl %s", i));
			speakersDao.createSpeaker(speaker);
		}
	}
	
	@Test
	public void speakersTest() {
		List<Speaker> speakers = speakersDao.readSpeakers();
		Assert.assertTrue(speakers.size() >= SPEAKERS_COUNT );
	}
	
	
	@Test
	public void test() {
		List<Speaker> speakers = speakersDao.readSpeakers();
		Speaker expected = speakers.get(0);
		String id = expected.getId();
		Speaker actual =  speakersDao.readSpeaker(id);
		Assert.assertEquals(expected, actual);
	}
	
	@After
	public void cleanUpTest() {
		List<Speaker> speakers = speakersDao.readSpeakers();
		for(Speaker speaker: speakers) {
			speakersDao.deleteSpeaker(speaker);
		}
		List<Speaker> speakersAfter = speakersDao.readSpeakers();
		Assert.assertTrue(speakersAfter.size() == 0);
	}
	
}
