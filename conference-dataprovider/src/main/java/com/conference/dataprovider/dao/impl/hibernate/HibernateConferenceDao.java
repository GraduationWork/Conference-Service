package com.conference.dataprovider.dao.impl.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.conference.core.domain.Conference;
import com.conference.dataprovider.dao.IConferenceDao;

@Repository
public class HibernateConferenceDao extends BaseHibernateDao implements IConferenceDao {

	@Override
	public void createConference(Conference conference) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conference readConference(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Conference> readConferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Conference> readConferences(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateConference(Conference conference) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteConference(Conference conference) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteConferenceById(String id) {
		// TODO Auto-generated method stub
		
	}

}
