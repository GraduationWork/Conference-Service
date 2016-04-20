package com.conference.services;

import com.conference.core.domain.Place;

public interface IPlaceService {
	public void createPlace(Place place);
	public Place getPlace(String id);
	public void updatePlace(Place place);
}
