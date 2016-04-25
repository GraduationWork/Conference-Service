package com.conference.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conference.core.domain.Place;
import com.conference.dataprovider.dao.IPlaceDao;
import com.conference.services.IPlaceService;

@Service
@Transactional
public class PlaceServiceImpl implements IPlaceService{

	private IPlaceDao placeDao;
	
	@Autowired
	public PlaceServiceImpl(IPlaceDao placeDao) {
		this.placeDao = placeDao;
	}
	
	@Override
	public void createPlace(Place place) {
		placeDao.createPlace(place);
	}

	@Override
	public Place getPlace(String id) {
		return placeDao.readPlace(id);
	}

	@Override
	public void updatePlace(Place place) {
		placeDao.updatePlace(place);
	}

	@Override
	public List<Place> getPlaces() {
		return placeDao.readPlaces();
	}

	@Override
	public void deletePlace(String id) {
		placeDao.deletePlaceById(id);
	}

}
