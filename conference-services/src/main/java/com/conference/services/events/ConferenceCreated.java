package com.conference.services.events;

import org.springframework.context.ApplicationEvent;

import com.conference.core.domain.Conference;

public class ConferenceCreated extends ApplicationEvent {

	private static final long serialVersionUID = 5318333072501298238L;
	
	private Conference conference;
	
	public ConferenceCreated(Object source,Conference conference) {
		super(source);
		this.conference = conference;
	}

	public Conference getConference() {
		return conference;
	}
	
}
