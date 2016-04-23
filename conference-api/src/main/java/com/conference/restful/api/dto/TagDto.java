package com.conference.restful.api.dto;

import org.springframework.beans.BeanUtils;

import com.conference.core.domain.Tag;

public class TagDto {

	private String tag;
	
	public TagDto() {
	}
	public TagDto(Tag tag) {
		BeanUtils.copyProperties(tag, this);
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
}
