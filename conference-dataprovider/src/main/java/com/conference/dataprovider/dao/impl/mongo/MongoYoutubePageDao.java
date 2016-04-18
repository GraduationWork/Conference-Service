package com.conference.dataprovider.dao.impl.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.conference.dataprovider.dao.IYoutubePageDao;
import com.conference.dataprovider.domain.YoutubePage;

@Repository
public class MongoYoutubePageDao implements IYoutubePageDao{

	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public void createYoutubePage(YoutubePage youtubePage) {
		mongoOperations.insert(youtubePage);
	}

	@Override
	public YoutubePage readYoutubePage(String id) {
		return mongoOperations.findById(id, YoutubePage.class);
	}

	@Override
	public List<YoutubePage> readYoutubePages() {
		return mongoOperations.findAll(YoutubePage.class);
	}

	@Override
	public void updateYoutubePage(YoutubePage youtubePage) {
		mongoOperations.save(youtubePage);
	}

	@Override
	public void deleteYoutubePageById(String id) {
		mongoOperations.remove(mongoOperations.findById(id, YoutubePage.class));
	}

}
