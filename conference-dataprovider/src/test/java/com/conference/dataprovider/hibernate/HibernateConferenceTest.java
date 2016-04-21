package com.conference.dataprovider.hibernate;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.conference.core.domain.AgendaNode;
import com.conference.core.domain.Conference;
import com.conference.core.domain.Place;
import com.conference.core.domain.Stakeholder;
import com.conference.core.domain.Template;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hibernate-context.xml" })
@Transactional
@Rollback(false)
public class HibernateConferenceTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void testInsert() {
		
		Conference conference = new Conference();
		conference.setStartTime(Calendar.getInstance().getTime());
		conference.setEndTime(Calendar.getInstance().getTime());
		conference.setTitle("Test");
		conference.setVideoId("test");
		Place place = new Place();
		place.setId("1");
		place.setPositionX(1);
		place.setPositionY(1);
		conference.setPlace(place);
		conference.setPlaceDetails("test");
		conference.setStakeholders(Arrays.asList(new Stakeholder("Test"), new Stakeholder("For developers")));
		AgendaNode agenda = new AgendaNode();
		agenda.setStartDate(Calendar.getInstance().getTime());
		agenda.setEndDate(Calendar.getInstance().getTime());
		agenda.setInfo("test");
		conference.setAgenda("test");
		Template template = new Template();
		template.setName("temp");
		template.setPreviewImageUrl("url");
		template.setUrl("url");
		conference.setTemplate(template);
		conference.setCreatedBy("ANONYM");
		
		
//		sessionFactory.getCurrentSession().save(place);
//		sessionFactory.getCurrentSession().save(template);
		
		
		sessionFactory.getCurrentSession().save(conference);
		
		List<Conference> conferences = sessionFactory.getCurrentSession().createCriteria(Conference.class).list();
		for (Conference obtainedConference: conferences) {
			for(Stakeholder stakeholder: obtainedConference.getStakeholders()) {
				System.out.println(stakeholder.getText());
			}
		}
	}
	
}
