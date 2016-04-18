package com.conference.dataprovider.dao.impl.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.conference.dataprovider.dao.IPlaceDao;
import com.conference.dataprovider.domain.Place;

@Repository
public class MongoPlaceDao implements IPlaceDao {

	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public void createPlace(Place place) {
		mongoOperations.insert(place);
	}

	@Override
	public Place readPlace(String id) {
		return mongoOperations.findById(id, Place.class);
	}

	@Override
	public List<Place> readPlacesByName(String name) {
		return mongoOperations.find(Query.query(Criteria.where("name").regex(name)), Place.class);
	}

	@Override
	public List<Place> readPlaces() {
		return mongoOperations.findAll(Place.class);
	}

	@Override
	public List<Place> readPlaces(int page, int pageSize) {
		Query query = new Query();
		query.skip((page-1)* pageSize);
		query.limit(pageSize);
		return mongoOperations.find(query, Place.class);
	}

	@Override
	public void updatePlace(Place place) {
		mongoOperations.save(place);
	}

	@Override
	public void deletePlace(Place place) {
		mongoOperations.remove(place);
	}

	@Override
	public void deletePlaceById(String id) {
		mongoOperations.remove(mongoOperations.findById(id, Place.class));
	}

}
