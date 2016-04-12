package com.conference.restful.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.conference.dataprovider.domain.Conference;
import com.conference.restful.api.dto.ConferenceDto;
import com.conference.services.IConferenceService;

@Component
@Path(ConferenceResources.RESOURCE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ConferenceResources {

	public static final String RESOURCE_PATH = "/conferences";

	@Autowired
	private IConferenceService conferenceService;

	@GET
	// TODO: 304 code implemetation
	public Response getConferences() {
		List<Conference> conferences = conferenceService.getConferences();
		List<ConferenceDto> conferenceDtos = new ArrayList<ConferenceDto>();
		for(Conference conference: conferences) {
			conferenceDtos.add(new ConferenceDto(conference));
		}
		return Response.ok(conferenceDtos).build();
	}

	@GET
	@Path("{id}")
	public Response getConference(@PathParam("id") String id,
			@Context Request request) {
		// Validate.id on existance
		Date updateDate = conferenceService.getUpdateDate(id);
		ResponseBuilder responseBuilder = request
				.evaluatePreconditions(updateDate);
		if (responseBuilder == null) {
			Conference conference = conferenceService.getConference(id);
			responseBuilder = Response.ok(new ConferenceDto(conference))
					.lastModified(updateDate);
		}
		return responseBuilder.build();
	}
	
	@POST
	public Response createConference(ConferenceDto conferenceDto) {
		//validate
		Conference conference = new Conference();
		BeanUtils.copyProperties(conferenceDto, conference);
		conferenceService.createConference(conference);
		conference.getId(); // return path to created resource
		return Response.ok().build();
	}
	
	@PUT
	public Response updateConference(ConferenceDto conferenceDto) {
		//validate
		Conference conference = new Conference();
		BeanUtils.copyProperties(conferenceDto, conference);
		conferenceService.updateConference(conference);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteConference(@PathParam("id") String id) {
		//conferenceService.deleteConference();
		return Response.ok().build();
	}

}
