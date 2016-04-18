package com.conference.restful.api.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.conference.dataprovider.domain.Speaker;
import com.conference.restful.api.dto.SpeakerDto;
import com.conference.services.ISpeakersService;

@RestController
@RequestMapping(SpeakersRestController.RESOURCE_PATH)
public class SpeakersRestController {

	public static final String RESOURCE_PATH = "/speakers";
	private static final String RESOURCE_PATH_BY_ID = RESOURCE_PATH + "/{id}";

	@Autowired
	private ISpeakersService speakersService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createSpeaker(
			@RequestBody @Valid SpeakerDto speakerDto) {
		Speaker speaker = new Speaker();
		BeanUtils.copyProperties(speakerDto, speaker);
		speakersService.createSpeaker(speaker);

		HttpHeaders httpHeaders = new HttpHeaders();
		URI uriOfUser = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.pathSegment(RESOURCE_PATH_BY_ID)
				.buildAndExpand(Collections.singletonMap("id", speaker.getId()))
				.toUri();
		httpHeaders.setLocation(uriOfUser);

		return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = RESOURCE_PATH_BY_ID, method = RequestMethod.GET)
	public ResponseEntity<?> getSpeakerById(@PathVariable("id") String id) {
		Speaker speaker = speakersService.getSpeaker(id);
		if (speaker == null ) {
			
		}
		return new ResponseEntity<SpeakerDto>(new SpeakerDto(speaker), HttpStatus.OK);
	}

}
