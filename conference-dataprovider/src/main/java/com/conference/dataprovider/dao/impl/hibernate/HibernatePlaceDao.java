package com.conference.dataprovider.dao.impl.hibernate;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.conference.dataprovider.dao.IPlaceDao;
import com.conference.dataprovider.domain.Place;

@Repository("hibernatePlaceDao")
public class HibernatePlaceDao implements IPlaceDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void createPlace(Place place) {
		sessionFactory.getCurrentSession().save(place);
	}

	public Place readPlace(String id) {
		return sessionFactory.getCurrentSession().get(Place.class, id);
	}

	public List<Place> readPlacesByName(String name) {
		throw new NotImplementedException(name);
	}

	@SuppressWarnings("unchecked")
	public List<Place> readPlaces() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Place.class)
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Place> readPlaces(int page, int pageSize) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Place.class)
				.setFirstResult((page - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	public void updatePlace(Place place) {
		sessionFactory.getCurrentSession().update(place);
	}

	public void deletePlace(Place place) {
		sessionFactory.getCurrentSession().delete(place);
	}

	public void deletePlaceById(String id) {
		throw new NotImplementedException(id);
	}

}
