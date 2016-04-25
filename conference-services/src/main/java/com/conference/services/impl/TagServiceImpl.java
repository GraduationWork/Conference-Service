package com.conference.services.impl;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conference.core.domain.Tag;
import com.conference.dataprovider.dao.ITagDao;
import com.conference.services.ITagService;

@Service
@Transactional
public class TagServiceImpl implements ITagService {

	private ITagDao tagDao;
	
	@Autowired
	public TagServiceImpl(ITagDao tagDao) {
		this.tagDao = tagDao;
	}

	@Override
	public void createTag(Tag tag) {
		tagDao.createTag(tag);
	}

	@Override
	public List<Tag> getTags() {
		return tagDao.readTags();
	}

	@Override
	public void deleteTag(String tag) {
		throw new NotImplementedException("");
	}
	
}
