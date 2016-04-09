package com.conference.restful.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.conference.restful.api.auth.domain.AuthenticatedUser;


@Component
@Path(RegistrationResource.RESOURCE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RegistrationResource {

	protected static final String RESOURCE_PATH = "/register";
	
	@POST
	@Path("/conference/{id}")
	public Response registerOnConference(
			@PathParam("id") String id, 
			@Context Request request) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) auth.getPrincipal();
		String username = authenticatedUser.getUsername();
		
		
		return null;
	}
	
	
	
	
}
