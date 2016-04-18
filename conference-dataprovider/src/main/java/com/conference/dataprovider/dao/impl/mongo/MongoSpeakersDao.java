package com.conference.dataprovider.dao.impl.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.conference.dataprovider.dao.ISpeakersDao;
import com.conference.dataprovider.domain.Speaker;

@Repository
public class MongoSpeakersDao implements ISpeakersDao{

	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public void createSpeaker(Speaker speaker) {
		mongoOperations.save(speaker);
	}

	@Override
	public Speaker readSpeaker(String id) {
		return mongoOperations.findById(id, Speaker.class);
	}

	@Override
	public List<Speaker> readSpeakersByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Speaker> readSpeakers() {
		return mongoOperations.findAll(Speaker.class);
	}

	@Override
	public List<Speaker> readSpeakers(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		Query searchUserQuery = new Query(Criteria.where("id").is(speaker.getId()));	
		
		Update update = new Update();
//		update.
		
//		mongoOperations.findAndModify(searchUserQuery, Update.fromDBObject(speaker)), Speaker.class);
//		mongoOperations.findAndModify(searchUserQuery, Update.update("name", speaker.getName()), Speaker.class);
	}

	@Override
	public void deleteSpeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSpeakerById(String id) {
		// TODO Auto-generated method stub
		
	}

}
