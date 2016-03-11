package com.conference.dataprovider.services;

import com.conference.core.domain.Speaker;

public interface ISpeakersService {
	public void createSpeaker(Speaker speaker);
	public Speaker getSpeaker(String id);
	public void updateSpeaker(Speaker speaker);
}
