package com.conference.restful.api.utils;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class DtoConverter<S,T> {

	public List<T> convertDto(List<S> source, List<T> target) {
		
		for (S s: source) {
			BeanUtils.copyProperties(s, target);
		}
		return null;
	}
	
	
	
}
