package com.conference.dataprovider.services;

import com.conference.core.domain.Conference;

public interface IConferenceService {
	public void createConference(Conference conference);
	public Conference getConference(String id);
	public void updateConference(Conference conference);
}
