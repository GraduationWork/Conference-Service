package com.conference.restful.api.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.conference.core.domain.Place;
import com.conference.restful.api.dto.PlaceDto;
import com.conference.restful.api.web.events.ResourceCreated;
import com.conference.restful.api.web.exception.ResourceNotFoundException;
import com.conference.services.IPlaceService;

@RestController
@RequestMapping(PlaceRestController.RESOURCE_PATH)
public class PlaceRestController {

	public static final String RESOURCE_PATH = "/places";
	
	@Autowired
	private IPlaceService placeService;
	
	@Autowired
    private ApplicationEventPublisher eventPublisher;
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createPlace(
			@RequestBody @Valid PlaceDto placeDto,
			HttpServletResponse response) {
		Place place = new Place();
		BeanUtils.copyProperties(placeDto, place);
		placeService.createPlace(place);
		eventPublisher.publishEvent(new ResourceCreated(this, response, place.getId()));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPlaceById(@PathVariable String id) {
		Place place = placeService.getPlace(id);
		if (place == null ) {
			throw new ResourceNotFoundException();
		}
		return new ResponseEntity<PlaceDto>(new PlaceDto(place), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<PlaceDto> getPlaces() {
		List<Place> places = placeService.getPlaces();
		List<PlaceDto> placesDto = convertPlacesToDto(places);
		return placesDto;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updatePlace(
			@RequestBody @Valid PlaceDto placeDto,
			HttpServletResponse response) {
		Place place = new Place();
		BeanUtils.copyProperties(placeDto, place);
		placeService.updatePlace(place);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deletePlace(@PathVariable String id) {
		placeService.deletePlace(id);
	}
	
	
	public List<PlaceDto> convertPlacesToDto(List<Place> places) {
		List<PlaceDto> placesDto = new ArrayList<PlaceDto>();
		for (Place place: places) {
			placesDto.add(new PlaceDto(place));
		}
		return placesDto;
	}
	
}
