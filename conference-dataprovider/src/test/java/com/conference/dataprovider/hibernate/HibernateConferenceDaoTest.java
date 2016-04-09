package com.conference.dataprovider.hibernate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.conference.core.domain.Conference;
import com.conference.core.domain.Place;
import com.conference.core.domain.Speaker;
import com.conference.dataprovider.dao.IConferenceDao;
import com.conference.dataprovider.dao.IPlaceDao;
import com.conference.dataprovider.dao.ISpeakersDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dp-context.xml" })
@Transactional
@Rollback(false)
public class HibernateConferenceDaoTest {

	
	@Autowired
	@Qualifier("hibernateConferenceDao")
	private IConferenceDao conferenceDao;
	
	@Autowired
	@Qualifier("hibernateSpeakerDao")
	private ISpeakersDao speakersDao;
	
	@Autowired
	@Qualifier("hibernatePlaceDao")
	private IPlaceDao placeDao;
	
	@Test
	public void creationTest() {
		Speaker speaker = new Speaker();
		speaker.setName("Александр Кассиров");
		speaker.setPhotoUrl("https://avatars0.githubusercontent.com/u/7274814?v=3&s=460");
		speaker.setTitle("Software Engineer в Epam Systems");
		speakersDao.createSpeaker(speaker);
//		
//		Place place = new Place();
//		place.setAdministrativeAreaName("1");
//		place.setCountryName("1");
//		place.setInfo("1");
//		place.setLocalityName("1");
//		place.setPositionX((float) 1.0);
//		place.setPositionY((float) 1.0);
//		place.setPremiseNumber("1");
//		place.setQuery("1");
//		place.setThoroughfareName("1");
//		placeDao.createPlace(place);
//		
//		Conference conference = new Conference();
//		conference.setLogoUrl("http://vk.com");
//		conference.setPlace(place);
//		conference.setPlaceDetails("Кабинет 210");
//		conference.setSpeakers(Arrays.asList(speaker));
//		conference.setStartTime(new Date(2016, 5, 24));
//		conference.setEndTime(new Date(2016, 5, 25));
//		conference.setTitle("Выпускной вечер ГрГУ");
//		conference.setVideoId("fake id");
		
//		conferenceDao.createConference(conference);
	}
	
//	@Test
	public void readConferences() {
//		List<Conference> conferences = conferenceDao.readConferences();
//		conferences.get(0).getPlace();
//		conferences.get(0).getSpeakersAsList();
	}
	
}
