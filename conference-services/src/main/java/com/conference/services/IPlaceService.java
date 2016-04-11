package com.conference.services;

import com.conference.dataprovider.domain.Place;
import com.conference.dataprovider.domain.Speaker;

public interface IPlaceService {
	public void createPlace(Place place);
	public Place getPlace(String id);
	public void updatePlace(Place place);
}
