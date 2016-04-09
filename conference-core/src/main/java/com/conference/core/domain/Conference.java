package com.conference.core.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;

public class Conference {
	private String id;
	private String title;
	private Date startTime;
	private Date endTime;
	private String videoId;
	private Date created;
	private Date updated;
	private Place place;
	private String placeDetails;
	private Template template;
	private Set<Tag> tags;
	private Set<Stakeholder> stakeholders;
//	private Agenda agenda;
	private Set<Speaker> speakers;

	public List<Speaker> getSpeakersAsList() {
		return Lists.newArrayList(speakers);
	}

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

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<Stakeholder> getStakeholders() {
		return stakeholders;
	}

	public void setStakeholders(Set<Stakeholder> stakeholders) {
		this.stakeholders = stakeholders;
	}

	public Set<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(Set<Speaker> speakers) {
		this.speakers = speakers;
	}
	
}
