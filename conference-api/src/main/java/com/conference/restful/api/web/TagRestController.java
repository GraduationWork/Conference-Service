package com.conference.restful.api.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.conference.core.domain.Tag;
import com.conference.restful.api.dto.TagDto;
import com.conference.services.ITagService;

@RestController
@RequestMapping(TagRestController.RESOURCE_PATH)
public class TagRestController {

	public static final String RESOURCE_PATH = "/tags";
	
	@Autowired
	private ITagService tagService;
	
	@Autowired
    private ApplicationEventPublisher eventPublisher;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createTag(
			@RequestBody @Valid TagDto tagDto,
			HttpServletResponse response) {
		Tag tag = new Tag();
		BeanUtils.copyProperties(tagDto, tag);
		tagService.createTag(tag);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<TagDto> getTags() {
		List<Tag> tags = tagService.getTags();
		List<TagDto> tagsDto = convertTagsToDto(tags);
		return tagsDto;
	}
	
	public List<TagDto> convertTagsToDto(List<Tag> tags) {
		List<TagDto> tagsDto = new ArrayList<TagDto>();
		for (Tag tag: tags) {
			tagsDto.add(new TagDto(tag));
		}
		return tagsDto;
	}
}
