package com.conference.core.domain;

public class Stakeholder {
	private Integer id;
	private String text;
//	private Integer ord;
//	private String conferenceId;
	
	public Stakeholder() {
		// TODO Auto-generated constructor stub
	}
	
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
//	public Integer getOrd() {
//		return ord;
//	}
//	public void setOrd(Integer ord) {
//		this.ord = ord;
//	}
//	public String getConferenceId() {
//		return conferenceId;
//	}
//	public void setConferenceId(String conferenceId) {
//		this.conferenceId = conferenceId;
//	}
	
	
	
	
}
