package com.conference.services;

import java.util.List;

import com.conference.core.domain.Tag;

public interface ITagService {
	void createTag(Tag tag);
	List<Tag> getTags();
	void deleteTag(String tag);
}
