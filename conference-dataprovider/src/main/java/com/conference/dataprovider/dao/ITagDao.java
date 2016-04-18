package com.conference.dataprovider.dao;

import java.util.List;

import com.conference.dataprovider.domain.Tag;

public interface ITagDao {
	public void createTag(Tag tag);
	public List<Tag> readTags();
	public void deleteTag(Tag tag);
}
