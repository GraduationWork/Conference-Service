package com.conference.core.domain;

public class Stakeholder {
	private Integer id;
	private String text;
	
	public Stakeholder() {}
	public Stakeholder(String text) {
		this.text = text;
	}
	
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
