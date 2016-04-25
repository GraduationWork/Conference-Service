package com.conference.restful.api.dto;

public class StakeholderDto {
	private Integer id;
	private String text;
	
	public StakeholderDto() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
