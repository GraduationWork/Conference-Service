package com.conference.dataprovider.dao.impl.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.conference.core.domain.Tag;
import com.conference.dataprovider.dao.ITagDao;

@Repository
public class HibernateTagDao extends BaseHibernateDao implements ITagDao {

	@Override
	public void createTag(Tag tag) {
		getSession().save(tag);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tag> readTags() {
		return getSession().createCriteria(Tag.class).list();
	}

	@Override
	public void deleteTag(Tag tag) {
		getSession().delete(tag);
	}

}
