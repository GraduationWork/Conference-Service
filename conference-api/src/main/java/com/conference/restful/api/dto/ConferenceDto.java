package com.conference.restful.api.dto;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.BeanUtils;

import com.conference.core.domain.Conference;
import com.conference.restful.api.dto.serializers.JsonDateSerializer;

@JsonSerialize(include=Inclusion.NON_NULL)
public class ConferenceDto {
	
	private String id;
	
	@NotNull
	private String title;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	@NotNull
	private Date startTime;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	@NotNull
	private Date endTime;
	private String placeDetails;
	private String logoUrl;
	private String videoId;
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date created;
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date updated;
	private PlaceDto place;
	private Set<SpeakerDto> speakers;
	
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
	public PlaceDto getPlace() {
		return place;
	}
	public void setPlace(PlaceDto place) {
		this.place = place;
	}
	public Set<SpeakerDto> getSpeakers() {
		return speakers;
	}
	public void setSpeakers(Set<SpeakerDto> speakers) {
		this.speakers = speakers;
	}
	
}
