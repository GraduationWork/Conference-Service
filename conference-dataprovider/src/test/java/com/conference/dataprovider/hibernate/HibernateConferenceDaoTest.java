package com.conference.dataprovider.hibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.conference.core.domain.Speaker;
import com.conference.dataprovider.dao.IConferenceDao;
import com.conference.dataprovider.dao.IPlaceDao;
import com.conference.dataprovider.dao.ISpeakersDao;
import com.conference.dataprovider.dao.ITagDao;
import com.conference.dataprovider.dao.ITemplateDao;
import com.conference.dataprovider.dao.IUserDao;

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
	
	@Autowired
	@Qualifier("hibernateTagDao")
	private ITagDao tagDao;

	@Autowired
	@Qualifier("hibernateTemplateDao")
	private ITemplateDao templateDao;

	@Autowired
	@Qualifier("hibernateUserDao")
	private IUserDao userDao;
	
	
	@Test
	public void deleteTest() {
		conferenceDao.deleteConferenceById("4028b881544d1b8e01544d1c39d10000");
	}
	
	
//	@Test
	public void creationTest() {
		
//		conferenceDao.readConferences();
		
//		Speaker speaker = new Speaker();
//		speaker.setName("Александр Кассиров");
//		speaker.setPhotoUrl("https://avatars0.githubusercontent.com/u/7274814?v=3&s=460");
//		speaker.setTitle("Software Engineer в Epam Systems");
//		speakersDao.createSpeaker(speaker);
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
