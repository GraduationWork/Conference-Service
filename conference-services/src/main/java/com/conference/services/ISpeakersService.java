package com.conference.services;

import com.conference.dataprovider.domain.Speaker;

public interface ISpeakersService {
	public void createSpeaker(Speaker speaker);
	public Speaker getSpeaker(String id);
	public void updateSpeaker(Speaker speaker);
}
