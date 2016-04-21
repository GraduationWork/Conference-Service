package com.conference.dataprovider.hibernate;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.conference.core.domain.Speaker;
import com.conference.dataprovider.dao.ISpeakersDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hibernate-context.xml" })
@Transactional
@Rollback(false)
public class HibernateSpeakerTest {

//	@Autowired
//	private SessionFactory sessionFactory;
	
	@Autowired
	private ISpeakersDao speakerDao;

	@Test
	public void createTest() {
		Speaker speaker = new Speaker();
		speaker.setName(String.format("Test name %s", 1));
		speaker.setTitle(String.format("Test title %s", 1));
		speaker.setPhotoUrl(String.format("Test photoUrl %s", 1));
		speakerDao.createSpeaker(speaker);
	}

}
