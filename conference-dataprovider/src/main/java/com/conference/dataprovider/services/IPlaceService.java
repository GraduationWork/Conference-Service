package com.conference.dataprovider.services;

import com.conference.core.domain.Place;
import com.conference.core.domain.Speaker;

public interface IPlaceService {
	public void createPlace(Place place);
	public Place getPlace(String id);
	public void updatePlace(Place place);
}
