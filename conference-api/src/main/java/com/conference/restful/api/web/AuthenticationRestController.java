package com.conference.restful.api.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWTSigner;
import com.conference.core.domain.User;
import com.conference.restful.api.dto.LoginDto;
import com.conference.restful.api.utils.ClaimsUtils;
import com.conference.restful.api.web.exception.ResourceNotFoundException;
import com.conference.services.IUserService;

@RestController
@RequestMapping(AuthenticationRestController.RESOURCE_PATH)
public class AuthenticationRestController {

	public static final String RESOURCE_PATH = "/auth";
	
	@Autowired
	private JWTSigner jwtSigner;
	@Autowired
	private IUserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value="/login")
	public ResponseEntity<?> authenticateUser(@RequestBody @Valid LoginDto userDto) {
		User user = userService.getUser(userDto.getUsername(), userDto.getPassword());
		if (user == null) {
			throw new ResourceNotFoundException();
		}
		Map<String,Object> claims = ClaimsUtils.generateClaims(user);
		return new ResponseEntity<String>(jwtSigner.sign(claims), HttpStatus.OK);
	}
	
}
