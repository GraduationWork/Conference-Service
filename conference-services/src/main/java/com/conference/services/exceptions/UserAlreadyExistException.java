package com.conference.services.exceptions;

public class UserAlreadyExistException extends ServiceException{

	private static final long serialVersionUID = -9008697115912942724L;

	public UserAlreadyExistException(String message) {
		super(message);
	}
	
}
