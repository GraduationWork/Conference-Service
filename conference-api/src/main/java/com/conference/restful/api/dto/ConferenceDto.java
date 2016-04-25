package com.conference.restful.api.dto;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.conference.core.domain.Agenda;
import com.conference.core.domain.Conference;
import com.conference.core.domain.Place;
import com.conference.core.domain.Speaker;
import com.conference.core.domain.Stakeholder;
import com.conference.core.domain.Tag;
import com.conference.core.domain.Template;

public class ConferenceDto {
	
	private String id;
	private String title;
	private Date startTime;
	private Date endTime;
	private String videoId;
	private Place place;
	private String placeDetails;
	private Template template;
	private List<Tag> tags;
	private List<Stakeholder> stakeholders;
	private List<Agenda> agenda;
	private List<Speaker> speakers;
	private Date created;
	private Date updated;
	
	public ConferenceDto() {
	}
	
	public ConferenceDto(Conference conference) {
		BeanUtils.copyProperties(conference, this);
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

	public List<Stakeholder> getStakeholders() {
		return stakeholders;
	}

	public void setStakeholders(List<Stakeholder> stakeholders) {
		this.stakeholders = stakeholders;
	}

	public List<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
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

	
}
