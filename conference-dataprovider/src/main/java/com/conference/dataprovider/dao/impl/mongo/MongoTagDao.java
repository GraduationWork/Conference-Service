package com.conference.dataprovider.dao.impl.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.conference.dataprovider.dao.ITagDao;
import com.conference.dataprovider.domain.Tag;

@Repository
public class MongoTagDao implements ITagDao{

	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public void createTag(Tag tag) {
		mongoOperations.insert(tag);
	}

	@Override
	public void deleteTag(Tag tag) {
		mongoOperations.remove(tag);
	}

	@Override
	public List<Tag> readTags() {
		return mongoOperations.findAll(Tag.class);
	}

}
