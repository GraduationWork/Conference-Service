package com.conference.restful.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.conference.core.domain.Speaker;
import com.conference.dataprovider.services.ISpeakersService;
import com.conference.restful.api.dto.SpeakerDto;

@Component
@Path(SpeakerResources.RESOURCE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class SpeakerResources {

	public static final String RESOURCE_PATH = "/speakers";

	@Autowired
	private ISpeakersService speakersService;

	@GET
	public Response getSpeakers() {
//		speakersService.getSpeakers();
		return null;
	}

	@GET
	public Response getSpeaker(int page) {
		return null;
	}

	@GET
	@Path("{id}")
	public Response getSpeaker(@PathParam("id") String id,
			@Context Request request) {
		Speaker speaker = speakersService.getSpeaker(id);
		SpeakerDto speakerDto = new SpeakerDto(speaker);
		return null;

	}

	@POST
	public Response createSpeaker(SpeakerDto speakerDto) {
		return null;
	}

	@PUT
	public Response updateSpeaker(SpeakerDto speakerDto) {
		return null;
	}

	@DELETE
	@Path("{id}")
	public Response deleteSpeaker(@PathParam("id") String id) {
		return null;
	}

}
