package com.conference.restful.api.controllers.annotations;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class HeaderModifierAdvice implements ResponseBodyAdvice<Object>{

	@Override
	public boolean supports(MethodParameter returnType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType,
			MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType,
			ServerHttpRequest request, ServerHttpResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
