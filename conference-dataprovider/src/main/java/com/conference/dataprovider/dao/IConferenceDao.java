package com.conference.dataprovider.dao;

import java.util.List;

import com.conference.dataprovider.domain.Conference;

public interface IConferenceDao {
	public void createConference(Conference conference);
	public Conference readConference(String id);
	public List<Conference> readConferences();
	public List<Conference> readConferences(int page, int pageSize);
	public void updateConference(Conference conference);
	public void deleteConference(Conference conference);
	public void deleteConferenceById(String id);
}
