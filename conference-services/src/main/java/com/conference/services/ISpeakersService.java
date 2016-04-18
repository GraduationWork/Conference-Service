package com.conference.services;

import java.util.List;

import com.conference.dataprovider.domain.Speaker;

public interface ISpeakersService {
	public void createSpeaker(Speaker speaker);
	public Speaker getSpeaker(String id);
	public List<Speaker> getSpeakers();
	public void updateSpeaker(Speaker speaker);
}
