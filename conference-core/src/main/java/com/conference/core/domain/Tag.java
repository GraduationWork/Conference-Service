package com.conference.core.domain;

import java.io.Serializable;

public class Tag implements Serializable{
	
	private static final long serialVersionUID = -6191193825247116826L;
	
	private String tag;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
