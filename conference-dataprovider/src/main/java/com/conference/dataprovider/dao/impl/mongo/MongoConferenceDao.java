package com.conference.dataprovider.dao.impl.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.conference.core.domain.Conference;
import com.conference.dataprovider.dao.IConferenceDao;

@Repository
public class MongoConferenceDao implements IConferenceDao {

	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public void createConference(Conference conference) {
		mongoOperations.insert(conference);
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
		Query query = new Query();
		query.skip((page-1)* pageSize);
		query.limit(pageSize);
		return mongoOperations.find(query, Conference.class);
	}

	@Override
	public void updateConference(Conference conference) {
		mongoOperations.save(conference);
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
