package com.conference.dataprovider.dao;

import java.util.List;

import com.conference.core.domain.Speaker;

public interface ISpeakersDao {
	public void createSpeaker(Speaker speaker);
	public Speaker readSpeaker(String id);
	public List<Speaker> readSpeakersByName(String name);
	public List<Speaker> readSpeakers();
	public List<Speaker> readSpeakers(int page, int pageSize);
	public void updateSpeaker(Speaker speaker);
	public void deleteSpeaker(Speaker speaker);
	public void deleteSpeakerById(String id);
}
