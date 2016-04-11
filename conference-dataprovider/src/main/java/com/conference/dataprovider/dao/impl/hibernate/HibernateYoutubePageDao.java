package com.conference.dataprovider.dao.impl.hibernate;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.conference.dataprovider.dao.IYoutubePageDao;
import com.conference.dataprovider.domain.YoutubePage;

@Repository("hibernateYoutubePageDao")
public class HibernateYoutubePageDao implements IYoutubePageDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createYoutubePage(YoutubePage youtubePage) {
		sessionFactory.getCurrentSession().save(youtubePage);
	}

	@Override
	public YoutubePage readYoutubePage(String id) {
		return sessionFactory.getCurrentSession().get(YoutubePage.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<YoutubePage> readYoutubePages() {
		return sessionFactory.getCurrentSession()
				.createCriteria(YoutubePage.class)
				.list();
	}

	@Override
	public void updateYoutubePage(YoutubePage youtubePage) {
		sessionFactory.getCurrentSession().update(youtubePage);
	}

	@Override
	public void deleteYoutubePageById(String id) {
		throw new NotImplementedException("method not implemented");
	}

}
