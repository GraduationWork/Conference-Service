package com.conference.dataprovider.dao.impl;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.conference.core.domain.Conference;
import com.conference.dataprovider.dao.IConferenceDao;

@Repository("hibernateConferenceDao")
public class HibernateConferenceDao implements IConferenceDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void createConference(Conference conference) {
		throw new NotImplementedException("method not implemented");
	}

	public Conference readConference(String id) {
		throw new NotImplementedException("method not implemented");
	}

	public List<Conference> readConferences() {
		throw new NotImplementedException("method not implemented");
	}

	public List<Conference> readConferences(int page, int pageSize) {
		throw new NotImplementedException("method not implemented");
	}

	public void updateConference(Conference conference) {
		throw new NotImplementedException("method not implemented");
	}

	public void deleteConference(Conference conference) {
		throw new NotImplementedException("method not implemented");
	}

	public void deleteConferenceById(String id) {
		throw new NotImplementedException("method not implemented");
	}

}
