package com.conference.restful.api.dto;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.BeanUtils;

import com.conference.dataprovider.domain.Place;
import com.conference.restful.api.dto.serializers.JsonDateSerializer;

@JsonSerialize(include=Inclusion.NON_NULL)
public class PlaceDto {
	private String id;
	private String countryName;
	private String administrativeAreaName;
	private String localityName;
	private String thoroughfareName;
	private String premiseNumber;
	private String query;
	private String info;
	private float positionX;
	private float positionY;
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date created;
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date updated;
	
	public PlaceDto() {}
	public PlaceDto(Place place) {
		BeanUtils.copyProperties(place, this);
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getAdministrativeAreaName() {
		return administrativeAreaName;
	}
	public void setAdministrativeAreaName(String administrativeAreaName) {
		this.administrativeAreaName = administrativeAreaName;
	}
	public String getLocalityName() {
		return localityName;
	}
	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}
	public String getThoroughfareName() {
		return thoroughfareName;
	}
	public void setThoroughfareName(String thoroughfareName) {
		this.thoroughfareName = thoroughfareName;
	}
	public String getPremiseNumber() {
		return premiseNumber;
	}
	public void setPremiseNumber(String premiseNumber) {
		this.premiseNumber = premiseNumber;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public float getPositionX() {
		return positionX;
	}
	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}
	public float getPositionY() {
		return positionY;
	}
	public void setPositionY(float positionY) {
		this.positionY = positionY;
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
