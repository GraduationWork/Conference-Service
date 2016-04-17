package com.conference.restful.api.dto;

import java.util.Date;

//import org.codehaus.jackson.map.annotate.JsonSerialize;
//import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.BeanUtils;

import com.conference.dataprovider.domain.Speaker;

//@JsonSerialize(include=Inclusion.NON_NULL)
//@XmlRootElement
public class SpeakerDto {

	private String id;
	private String name;
	private String title;
	private String photoUrl;
	
//	@JsonSerialize(using=JsonDateSerializer.class)
	private Date created;
	
//	@JsonSerialize(using=JsonDateSerializer.class)
	private Date updated;

	public SpeakerDto() {}
	public SpeakerDto(Speaker speaker) {
		BeanUtils.copyProperties(speaker, this);
	}
	
//	@XmlElement
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
//	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//	@XmlElement
	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

//	@XmlElement
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

//	@XmlElement
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
