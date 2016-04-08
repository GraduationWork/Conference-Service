package com.conference.restful.api.auth.exceptions;

import org.springframework.security.core.AuthenticationException;

public class JWTTokenVerificationException extends AuthenticationException{

	private static final long serialVersionUID = -533549150638601541L;

	public JWTTokenVerificationException(String msg) {
		super(msg);
	}

}
