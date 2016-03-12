package com.conference.restful.api.dto;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.conference.restful.api.dto.serializers.JsonDateSerializer;

public class SpeakerDto {

	private String id;
	private String name;
	private String title;
	private String photoUrl;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date created;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date updated;

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
