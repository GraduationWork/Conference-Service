package com.conference.restful.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conference.restful.api.dto.UserDto;

@RestController
@RequestMapping(UsersRestController.RESOURCE_PATH)
public class UsersRestController {

	public static final String RESOURCE_PATH = "/users";
	
//	@Autowired private IUserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value="/register", headers = "Accept=application/json,application/xml")
	public ResponseEntity<?> registerUser(@RequestBody @Valid UserDto userDto, Errors errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<List<ObjectError>>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
	}
	
	
}
