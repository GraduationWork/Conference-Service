package com.conference.restful.api.controllers;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conference.restful.api.dto.SpeakerDto;

//@RestController
//@RequestMapping(SpeakersRestController.RESOURCE_PATH)
public class SpeakersRestController {

	public static final String RESOURCE_PATH = "/speakers";
	
//	@Autowired private ISpeakersService speakersService;
	
//	@RequestMapping(method=RequestMethod.GET)
//	public List<SpeakerDto> getSpeakers() {
//		SpeakerDto speakerDto = new SpeakerDto();
//		speakerDto.setId("test");
//		speakerDto.setName("Aliaksandr Kassirau");
//		speakerDto.setTitle("Software Engineer");
//		speakerDto.setPhotoUrl("https://avatars0.githubusercontent.com/u/7274814?v=3&s=460");
//		speakerDto.setCreated(Calendar.getInstance().getTime());
//		speakerDto.setUpdated(Calendar.getInstance().getTime());
//		return Arrays.asList(speakerDto);
//	}
	
	
	
}
