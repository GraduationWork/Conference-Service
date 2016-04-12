package com.conference.services.exceptions;

public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = 2262565004580535816L;

	public ServiceException(String message) {
		super(message);
	}
	
}
