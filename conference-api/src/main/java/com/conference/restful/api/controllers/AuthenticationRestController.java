package com.conference.restful.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWTSigner;
import com.conference.restful.api.dto.LoginDto;
import com.conference.restful.api.dto.UserDto;
import com.conference.services.IUserService;

@RestController
@RequestMapping(AuthenticationRestController.RESOURCE_PATH)
public class AuthenticationRestController {

	public static final String RESOURCE_PATH = "/auth";
	
//	@Autowired
//	private JWTSigner jwtSigner;
	
	@Autowired
	private IUserService userService;
	
	
	@RequestMapping(method = RequestMethod.POST, value="/login")
	public ResponseEntity<?> registerUser(@RequestBody @Valid LoginDto userDto) {
		return null;
	}
	
}
