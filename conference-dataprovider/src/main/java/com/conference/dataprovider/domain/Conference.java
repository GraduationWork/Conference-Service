package com.conference.dataprovider.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Conference implements Serializable{
	
	private static final long serialVersionUID = -8888370563151919700L;
	
	@Id
	private String id;
	private String title;
	private Date startTime;
	private Date endTime;
	private String videoId;
	@DBRef
	private Place place;
	private String placeDetails;
	@DBRef
	private Template template;
	@DBRef
	private List<Tag> tags;
	private List<String> stakeholders;
	private List<AgendaNode> agenda;
	@DBRef
	private List<Speaker> speakers;
	private Date created;
	private Date updated;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public String getPlaceDetails() {
		return placeDetails;
	}
	public void setPlaceDetails(String placeDetails) {
		this.placeDetails = placeDetails;
	}
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public List<String> getStakeholders() {
		return stakeholders;
	}
	public void setStakeholders(List<String> stakeholders) {
		this.stakeholders = stakeholders;
	}
	public List<Speaker> getSpeakers() {
		return speakers;
	}
	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<AgendaNode> getAgenda() {
		return agenda;
	}
	public void setAgenda(List<AgendaNode> agenda) {
		this.agenda = agenda;
	}
}
