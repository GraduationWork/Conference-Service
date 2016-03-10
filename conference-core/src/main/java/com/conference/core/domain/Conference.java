package com.conference.core.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Conference {
	private String id;
	private String title;
	private Date startTime;
	private Date endTime;
	private String placeDetails;
	private String logoUrl;
	private String videoId;
	private Date created;
	private Date updated;
	private Place place;
	private Set<Speaker> speakers;

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

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
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

	public Set<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(Set<Speaker> speakers) {
		this.speakers = speakers;
	}
	
	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = new HashSet<Speaker>(speakers);
	}
	
}
