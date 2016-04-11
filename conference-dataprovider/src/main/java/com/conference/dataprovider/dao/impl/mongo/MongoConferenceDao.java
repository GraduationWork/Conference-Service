package com.conference.dataprovider.dao.impl.mongo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.conference.dataprovider.dao.IConferenceDao;
import com.conference.dataprovider.domain.Conference;

@Repository
public class MongoConferenceDao implements IConferenceDao {

	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public void createConference(Conference conference) {
		mongoOperations.save(conference);
	}

	@Override
	public Conference readConference(String id) {
		return mongoOperations.findById(id, Conference.class);
	}

	@Override
	public List<Conference> readConferences() {
		return mongoOperations.findAll(Conference.class);
	}

	@Override
	public List<Conference> readConferences(int page, int pageSize) {
		return null;
	}

	@Override
	public Date readUpdateDate(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateConference(Conference conference) {
		Query searchUserQuery = new Query(Criteria.where("id").is(conference.getId()));
//		mongoOperations.findAndModify(searchUserQuery, Update, Conference.class);
	}

	@Override
	public void deleteConference(Conference conference) {
		mongoOperations.remove(conference);
		
	}

	@Override
	public void deleteConferenceById(String id) {
		mongoOperations.remove(mongoOperations.findById(id, Conference.class));
	}

}
