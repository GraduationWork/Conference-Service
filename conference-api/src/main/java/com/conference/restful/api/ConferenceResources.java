package com.conference.restful.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.conference.core.domain.Conference;
import com.conference.dataprovider.services.IConferenceService;
import com.conference.restful.api.dto.ConferenceDto;
import com.conference.restful.api.utils.BeansUtils;

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
		BeansUtils.copyProperties(conferences, conferenceDtos);
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

}
