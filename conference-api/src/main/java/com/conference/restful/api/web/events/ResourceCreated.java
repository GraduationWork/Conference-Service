package com.conference.restful.api.web.events;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class ResourceCreated extends ApplicationEvent {
	
	private static final long serialVersionUID = 2471767581528808813L;
	
	private HttpServletResponse response;
	private String idOfNewResource;

	public ResourceCreated(Object source, HttpServletResponse response,
			String idOfNewResource) {
		super(source);

		this.response = response;
		this.idOfNewResource = idOfNewResource;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public String getIdOfNewResource() {
		return idOfNewResource;
	}
}