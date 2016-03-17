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

import com.conference.dataprovider.services.IPlaceService;
import com.conference.restful.api.dto.PlaceDto;


@Component
@Path(PlaceResources.RESOURCE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class PlaceResources {

	public static final String RESOURCE_PATH = "/places";
	
//	@Autowired
//	private IPlaceService placeService;
	
	@GET
	public Response getPlaces() {
		return null;
	}
	
	@GET
	@Path("{id}")
	public Response getPlace(@PathParam("id") String id,
			@Context Request request) {
		return null;
	}
	
	@POST
	public Response createPlace(PlaceDto placeDto) {
		return null;
	}
	
	@PUT
	public Response updatePlace(PlaceDto placeDto) {
		return null;
	}
	
	@DELETE
	@Path("{id}")
	public Response deletePlace(@PathParam("id") String id) {
		return null;
	}
	
}
