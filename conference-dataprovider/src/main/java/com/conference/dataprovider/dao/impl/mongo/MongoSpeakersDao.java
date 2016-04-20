package com.conference.dataprovider.dao.impl.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.conference.core.domain.Speaker;
import com.conference.dataprovider.dao.ISpeakersDao;

@Repository
public class MongoSpeakersDao implements ISpeakersDao{

	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public void createSpeaker(Speaker speaker) {
		mongoOperations.insert(speaker);
	}

	@Override
	public Speaker readSpeaker(String id) {
		return mongoOperations.findById(id, Speaker.class);
	}

	@Override
	public List<Speaker> readSpeakersByName(String name) {
		return mongoOperations.find(Query.query(Criteria.where("name").regex(name)), Speaker.class);
	}

	@Override
	public List<Speaker> readSpeakers() {
		return mongoOperations.findAll(Speaker.class);
	}

	@Override
	public List<Speaker> readSpeakers(int page, int pageSize) {
		Query query = new Query();
		query.skip((page-1)* pageSize);
		query.limit(pageSize);
		return mongoOperations.find(query, Speaker.class);
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		mongoOperations.save(speaker);
	}

	@Override
	public void deleteSpeaker(Speaker speaker) {
		mongoOperations.remove(speaker);
	}

	@Override
	public void deleteSpeakerById(String id) {
		mongoOperations.remove(mongoOperations.findById(id, Speaker.class));
	}

}
