package com.conference.services;

import java.util.List;

import com.conference.core.domain.Place;

public interface IPlaceService {
	void createPlace(Place place);
	Place getPlace(String id);
	List<Place> getPlaces();
	void updatePlace(Place place);
	void deletePlace(String id);
}
