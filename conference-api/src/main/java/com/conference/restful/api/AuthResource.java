package com.conference.restful.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWTSigner;
import com.conference.dataprovider.domain.Role;


@Component
@Path(AuthResource.RESOURCE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class AuthResource {

	public static final String RESOURCE_PATH = "/authenticate";
	
	
	private JWTSigner jwtSigner = new JWTSigner("SECRET");
	
	
	
	
	@GET
	//UserDto userDto
	public Response createConference() {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("username", "Aliaksandr_Kassirau");
		claims.put("password", "0");
		claims.put("isActive", true);
		claims.put("roles", Arrays.asList(Role.ROLE_CONFERENCE_ADMIN, Role.ROLE_CONFERENCE_MODERATOR, Role.ROLE_CONFERENCE_USER));
		String token = jwtSigner.sign(claims);
		return Response.ok().entity(token).build();
	}
	
}
