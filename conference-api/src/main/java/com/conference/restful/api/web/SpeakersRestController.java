package com.conference.restful.api.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.conference.dataprovider.domain.Speaker;
import com.conference.restful.api.dto.SpeakerDto;
import com.conference.restful.api.web.events.ResourceCreated;
import com.conference.restful.api.web.exception.ResourceNotFoundException;
import com.conference.services.ISpeakersService;

@RestController
@RequestMapping(SpeakersRestController.RESOURCE_PATH)
public class SpeakersRestController {

	public static final String RESOURCE_PATH = "/speakers";

	@Autowired
	private ISpeakersService speakersService;
	
	@Autowired
    private ApplicationEventPublisher eventPublisher;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createSpeaker(
			@RequestBody @Valid SpeakerDto speakerDto,
			HttpServletResponse response) {
		Speaker speaker = new Speaker();
		BeanUtils.copyProperties(speakerDto, speaker);
		speakersService.createSpeaker(speaker);
		eventPublisher.publishEvent(new ResourceCreated(this, response, speaker.getId()));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getSpeakerById(@PathVariable String id) {
		Speaker speaker = speakersService.getSpeaker(id);
		if (speaker == null ) {
			throw new ResourceNotFoundException();
		}
		return new ResponseEntity<SpeakerDto>(new SpeakerDto(speaker), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<SpeakerDto> getSpeakers() {
		List<Speaker> speakers = speakersService.getSpeakers();
		List<SpeakerDto> speakersDto = convertSpeakersToDto(speakers);
		return speakersDto;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateSpeaker(
			@RequestBody @Valid SpeakerDto speakerDto,
			HttpServletResponse response) {
		Speaker speaker = new Speaker();
		BeanUtils.copyProperties(speakerDto, speaker);
		speakersService.updateSpeaker(speaker);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteSpeaker(@PathVariable String id) {
//		speakersService.deleteSpeaker(id);
	}
	
	
	public List<SpeakerDto> convertSpeakersToDto(List<Speaker> speakers) {
		List<SpeakerDto> speakersDto = new ArrayList<SpeakerDto>();
		for (Speaker speaker: speakers) {
			speakersDto.add(new SpeakerDto(speaker));
		}
		return speakersDto;
	}

}
