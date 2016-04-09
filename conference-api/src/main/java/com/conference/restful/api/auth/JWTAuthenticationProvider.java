package com.conference.restful.api.auth;

import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.auth0.jwt.JWTVerifier;
import com.conference.restful.api.auth.domain.AuthenticatedUser;
import com.conference.restful.api.auth.exceptions.JWTTokenVerificationException;

public class JWTAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider  {

	private JWTVerifier jwtVerifier;
	
	public JWTAuthenticationProvider(String secret) {
		Validate.notNull(secret);
		this.jwtVerifier = new JWTVerifier(secret);
	}
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0,
			UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
	}

	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
		String authToken = jwtAuthenticationToken.getToken();
		UserDetails userDetails;
		try {
			Map<String,Object> claims =  jwtVerifier.verify(authToken);
			userDetails = new AuthenticatedUser(claims);
		} catch (Exception e) {
			throw new JWTTokenVerificationException(e.getMessage());
		}
		
		return userDetails;
	}
	
	

}
