package com.conference.restful.api.controllers;

import java.util.Calendar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conference.restful.api.dto.SpeakerDto;

@RestController
@RequestMapping(SpeakersRestController.RESOURCE_PATH)
public class SpeakersRestController {

	public static final String RESOURCE_PATH = "/speakers";
	
//	@Autowired private ISpeakersService speakersService;
	
	@RequestMapping(method=RequestMethod.GET)
	public SpeakerDto getSpeakers() {
		SpeakerDto speakerDto = new SpeakerDto();
		speakerDto.setId("test");
		speakerDto.setName("Aliaksandr Kassirau");
		speakerDto.setTitle("Software Engineer");
		speakerDto.setPhotoUrl("url");
		speakerDto.setCreated(Calendar.getInstance().getTime());
		speakerDto.setUpdated(Calendar.getInstance().getTime());
		return speakerDto;
	}
	
}
