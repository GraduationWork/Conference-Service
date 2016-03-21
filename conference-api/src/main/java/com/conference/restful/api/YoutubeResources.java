package com.conference.restful.api;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Component;

import com.conference.restful.api.dto.YoutubePageDto;
import com.conference.restful.api.utils.GoogleOAuthHelper;

@Component
@Path(YoutubeResources.RESOURCE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class YoutubeResources {

	public static final String RESOURCE_PATH = "/youtube/pages";
	
	
	
	private String clientId = "698605801531-furmbme5fbdrt3njt95rrgrn4ed59vc0.apps.googleusercontent.com";
	private String redirectUrl = "http://localhost:8083/conference-api/oauth2callback/youtube";
	private static List<String> scopes = Arrays.asList(
			"https://www.googleapis.com/auth/youtube",
			"https://www.googleapis.com/auth/youtube.force-ssl"
			);
	
	
	
//	@GET
//	public Response getConferences() {
//		List<Conference> conferences = conferenceService.getConferences();
//		List<ConferenceDto> conferenceDtos = new ArrayList<ConferenceDto>();
//		for(Conference conference: conferences) {
//			conferenceDtos.add(new ConferenceDto(conference));
//		}
//		return Response.ok(conferenceDtos).build();
//	}
//
//	@GET
//	@Path("{id}")
//	public Response getConference(@PathParam("id") String id,
//			@Context Request request) {
//		// Validate.id on existance
//		Date updateDate = conferenceService.getUpdateDate(id);
//		ResponseBuilder responseBuilder = request
//				.evaluatePreconditions(updateDate);
//		if (responseBuilder == null) {
//			Conference conference = conferenceService.getConference(id);
//			responseBuilder = Response.ok(new ConferenceDto(conference))
//					.lastModified(updateDate);
//		}
//		return responseBuilder.build();
//	}
//	
	@POST
	public Response createYoutubePage(YoutubePageDto youtubePageDto) throws ClientProtocolException, IOException {
		Map<String,String> headers = new HashMap<String, String>();
		headers.put("conference-name", youtubePageDto.getName());
		headers.put("conference-redirect-success", "pass values from FE.");
		GoogleOAuthHelper.authenticate(clientId, redirectUrl, scopes, headers);
		//get header with id and get from db and respond entity to client 
		return Response.ok().build();
	}
//	
//	@PUT
//	public Response updateConference(ConferenceDto conferenceDto) {
//		//validate
//		Conference conference = new Conference();
//		BeanUtils.copyProperties(conferenceDto, conference);
//		conferenceService.updateConference(conference);
//		return Response.ok().build();
//	}
//	
//	@DELETE
//	@Path("{id}")
//	public Response deleteConference(@PathParam("id") String id) {
//		//conferenceService.deleteConference();
//		return Response.ok().build();
//	}
	
}
