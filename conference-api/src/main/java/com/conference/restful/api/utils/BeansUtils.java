package com.conference.restful.api.utils;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.conference.core.domain.Conference;
import com.conference.restful.api.dto.ConferenceDto;

public class BeansUtils {

	public static void copyProperties(List<Conference> source, List<ConferenceDto> target) {
		source.forEach(obj -> {
			ConferenceDto targetObj = new ConferenceDto();
			BeanUtils.copyProperties(obj, targetObj);
			target.add(targetObj);
		});
	}
	
}
