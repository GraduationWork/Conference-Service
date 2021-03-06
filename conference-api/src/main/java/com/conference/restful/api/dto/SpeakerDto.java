package com.conference.restful.api.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
//import org.codehaus.jackson.map.annotate.JsonSerialize;
//import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.BeanUtils;

import com.conference.core.domain.Speaker;

public class SpeakerDto {

	private String id;
	
	@NotEmpty
	private String name;
	@NotEmpty
	private String title;

	@NotEmpty
	@URL
	private String photoUrl;
	
	private Date created;
	private Date updated;

	public SpeakerDto() {}
	public SpeakerDto(Speaker speaker) {
		BeanUtils.copyProperties(speaker, this);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
