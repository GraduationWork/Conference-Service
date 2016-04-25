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

import com.conference.core.domain.Conference;
import com.conference.restful.api.dto.ConferenceDto;
import com.conference.restful.api.web.events.ResourceCreated;
import com.conference.restful.api.web.exception.ResourceNotFoundException;
import com.conference.services.IConferenceService;

@RestController
@RequestMapping(ConferenceRestController.RESOURCE_PATH)
public class ConferenceRestController {

	public static final String RESOURCE_PATH = "/conferences";

	@Autowired
	private IConferenceService conferencesService;
	
	@Autowired
    private ApplicationEventPublisher eventPublisher;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createConference(
			@RequestBody @Valid ConferenceDto conferenceDto,
			HttpServletResponse response) {
		Conference conference = new Conference();
		BeanUtils.copyProperties(conferenceDto, conference);
		conferencesService.createConference(conference);
		eventPublisher.publishEvent(new ResourceCreated(this, response, conference.getId()));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getConferenceById(@PathVariable String id) {
		Conference conference = conferencesService.getConference(id);
		if (conference == null ) {
			throw new ResourceNotFoundException();
		}
		return new ResponseEntity<ConferenceDto>(new ConferenceDto(conference), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ConferenceDto> getConferences() {
		List<Conference> conferences = conferencesService.getConferences();
		List<ConferenceDto> conferencesDto = convertConferencesToDto(conferences);
		return conferencesDto;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateConference(
			@RequestBody @Valid ConferenceDto conferenceDto,
			HttpServletResponse response) {
		Conference conference = new Conference();
		BeanUtils.copyProperties(conferenceDto, conference);
		conferencesService.updateConference(conference);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteConference(@PathVariable String id) {
		conferencesService.deleteConference(id);
	}
	
	
	public List<ConferenceDto> convertConferencesToDto(List<Conference> Conferences) {
		List<ConferenceDto> ConferencesDto = new ArrayList<ConferenceDto>();
		for (Conference Conference: Conferences) {
			ConferencesDto.add(new ConferenceDto(Conference));
		}
		return ConferencesDto;
	}
}
