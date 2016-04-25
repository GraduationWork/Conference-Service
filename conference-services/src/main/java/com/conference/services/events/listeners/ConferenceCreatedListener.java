package com.conference.services.events.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.conference.core.domain.Conference;
import com.conference.services.events.ConferenceCreated;
import com.google.common.base.Preconditions;

@Component
public class ConferenceCreatedListener implements ApplicationListener<ConferenceCreated>{

	@Override
	public void onApplicationEvent(ConferenceCreated event) {
		Preconditions.checkNotNull(event);
		Conference conference = event.getConference();
		//AlertBuilder. 
		//Push to ab queue
	}

}
