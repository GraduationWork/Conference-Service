package com.conference.restful.api.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conference.dataprovider.domain.Speaker;
import com.conference.restful.api.dto.SpeakerDto;
import com.conference.services.ISpeakersService;

@Controller
@RequestMapping(SpeakersController.RESOURCE_PATH)
public class SpeakersController {

	public static final String RESOURCE_PATH = "/speakers";
	
	@Autowired private ISpeakersService speakersService;
	
	@RequestMapping(method=RequestMethod.POST)
	public String createSpeaker(Model model, @RequestBody @Valid SpeakerDto speakerDto) {
		Speaker speaker = new Speaker();
		BeanUtils.copyProperties(speakerDto, speaker);
		speakersService.createSpeaker(speaker);
		model.addAttribute("speakers", Arrays.asList(speakerDto));
		return "speakers";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getSpeakers(Model model) {
		List<Speaker> speakers = speakersService.getSpeakers();
		List<SpeakerDto> speakersDto = new ArrayList<SpeakerDto>();
		for(Speaker speaker: speakers) {
			speakersDto.add(new SpeakerDto(speaker));
		}
		model.addAttribute("speakers", speakersDto);
		return "speakers";
	}
	
}
