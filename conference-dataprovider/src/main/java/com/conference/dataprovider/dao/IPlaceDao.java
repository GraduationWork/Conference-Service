package com.conference.dataprovider.dao;

import java.util.List;

import com.conference.core.domain.Place;

public interface IPlaceDao {
	public void createPlace(Place place);
	public Place readPlace(String id);
	public List<Place> readPlacesByName(String name);
	public List<Place> readPlaces();
	public List<Place> readPlaces(int page, int pageSize);
	public void updatePlace(Place place);
	public void deletePlace(Place place);
	public void deletePlaceById(String id);
}
