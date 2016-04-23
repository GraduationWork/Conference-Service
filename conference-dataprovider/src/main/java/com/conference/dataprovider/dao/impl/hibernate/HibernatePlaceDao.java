package com.conference.dataprovider.dao.impl.hibernate;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.conference.core.domain.Place;
import com.conference.dataprovider.dao.IPlaceDao;

@Repository
public class HibernatePlaceDao extends BaseHibernateDao implements IPlaceDao{

	@Override
	public void createPlace(Place place) {
		getSession().save(place);
	}

	@Override
	public Place readPlace(String id) {
		return getSession().get(Place.class, id);
	}

	@Override
	public List<Place> readPlacesByName(String name) {
		throw new NotImplementedException("readPlacesByName is not implemented");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> readPlaces() {
		return getSession().createCriteria(Place.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> readPlaces(int page, int pageSize) {
		return  getSession()
				.createCriteria(Place.class)
				.setFirstResult((page - 1) * pageSize )
				.setMaxResults(pageSize)
				.list();
	}

	@Override
	public void updatePlace(Place place) {
		getSession().update(place);
	}

	@Override
	public void deletePlace(Place place) {
		getSession().delete(place);
	}

	@Override
	public void deletePlaceById(String id) {
		Place place = new Place();
		place.setId(id);
		deletePlace(place);
	}

}
