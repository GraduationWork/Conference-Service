package com.conference.services;

import java.util.List;

import com.conference.core.domain.Conference;

public interface IConferenceService {
	void createConference(Conference conference);
	Conference getConference(String id);
	List<Conference> getConferences();
	List<Conference> getConferences(int page, int pageSize);
	void updateConference(Conference conference);
	void deleteConference(String id);
	
}
