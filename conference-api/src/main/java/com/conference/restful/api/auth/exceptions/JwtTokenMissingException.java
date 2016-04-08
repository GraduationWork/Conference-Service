package com.conference.restful.api.auth.exceptions;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMissingException extends AuthenticationException{

	private static final long serialVersionUID = 733256075964714416L;

	public JwtTokenMissingException(String msg) {
		super(msg);
	}

}
