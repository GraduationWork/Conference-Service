package com.conference.services;

import java.util.List;

import com.conference.core.domain.Speaker;

public interface ISpeakersService {
	void createSpeaker(Speaker speaker);
	Speaker getSpeaker(String id);
	List<Speaker> getSpeakers();
	void updateSpeaker(Speaker speaker);
	void deleteSpeakerById(String id);
}
