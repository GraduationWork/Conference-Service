package com.conference.services;

import java.util.Date;
import java.util.List;

import com.conference.dataprovider.domain.Conference;

public interface IConferenceService {
	public void createConference(Conference conference);
	public Conference getConference(String id);
	public List<Conference> getConferences();
	public List<Conference> getConferences(int page, int pageSize);
	public Date getUpdateDate(String id);
	public void updateConference(Conference conference);
}
