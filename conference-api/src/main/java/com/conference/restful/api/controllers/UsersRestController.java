package com.conference.restful.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conference.dataprovider.domain.User;
import com.conference.restful.api.dto.UserDto;
import com.conference.services.IUserService;

@RestController
@RequestMapping(UsersRestController.RESOURCE_PATH)
public class UsersRestController {

	public static final String RESOURCE_PATH = "/users";
	
    @Autowired private IUserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value="/register")
	public ResponseEntity<?> registerUser(@RequestBody @Valid UserDto userDto) {
		userService.deleteUser(userDto.getUsername());
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		userService.registerUser(user);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/resend")
	public ResponseEntity<?> resendVerificationEmail(@RequestParam String token) {
//		userService.activateUser(username, true);
		return new ResponseEntity<UserDto>(new UserDto(userService.getUser(username)),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/verify")
	public ResponseEntity<?> verifyEmail(@RequestParam String token) {
//		userService.activateUser(username, true);
		return new ResponseEntity<UserDto>(new UserDto(userService.getUser(username)),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/reject")
	public ResponseEntity<?> rejectEmail(String username) {
//		userService.activateUser(username, true);
		return new ResponseEntity<UserDto>(new UserDto(userService.getUser(username)),HttpStatus.OK);
	}
	
	
	
	
	
}
