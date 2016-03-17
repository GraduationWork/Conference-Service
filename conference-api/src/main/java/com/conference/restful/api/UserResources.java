package com.conference.restful.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;


@Component
@Path(UserResources.RESOURCE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class UserResources {
	
	public static final String RESOURCE_PATH = "/users";
	
	//register user
	//get users
	//get user
	//login
	//logout
	

}
