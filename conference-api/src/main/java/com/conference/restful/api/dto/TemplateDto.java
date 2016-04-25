package com.conference.restful.api.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.conference.core.domain.Template;

public class TemplateDto {

	private String id;
	private String name;
	private String previewImageUrl;
	private String url;
	private Date created;
	private Date updated;
	
	public TemplateDto() {
	}
	public TemplateDto(Template template) {
		BeanUtils.copyProperties(template, this);
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
	public String getPreviewImageUrl() {
		return previewImageUrl;
	}
	public void setPreviewImageUrl(String previewImageUrl) {
		this.previewImageUrl = previewImageUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
