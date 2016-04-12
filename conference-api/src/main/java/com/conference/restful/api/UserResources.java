package com.conference.restful.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.conference.dataprovider.domain.User;
import com.conference.restful.api.auth.domain.AuthenticatedUser;
import com.conference.restful.api.dto.UserDto;
import com.conference.services.IUserService;


@Component
@Path(UserResources.RESOURCE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class UserResources {
	
	public static final String RESOURCE_PATH = "/users";
	
	@Autowired
	private IUserService userService;
	
	//login
	//logout
	
	@GET
	@Path("/signed")
	public Response getSignedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) auth.getPrincipal();
		User user = userService.getUser(authenticatedUser.getUsername());
		UserDto userDto = new UserDto(user);
		return Response.ok().entity(userDto).build();
	}
	
	
	@POST
	@Path("/register")
	public Response registerUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		userService.registerUser(user);
		return Response.status(Status.CREATED).build();
	}
	
	@GET
	@Path("/confirm")
	public Response confirmRegisteredMail(@QueryParam("token") String token) {
		return Response.ok().entity("Success").build();
	}
	
}
