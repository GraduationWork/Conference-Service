package com.conference.restful.api;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.conference.dataprovider.services.IConferenceService;

@Component
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ConferenceResources {

	@Autowired
	private IConferenceService conferenceService;
	
	@GET
	public Response getFacebookMapping() {
		Date time = Calendar.getInstance().getTime();
		return Response.ok(time).build();
	}
	
}
