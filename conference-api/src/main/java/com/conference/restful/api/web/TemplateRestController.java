package com.conference.restful.api.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.conference.core.domain.Template;
import com.conference.restful.api.dto.TemplateDto;
import com.conference.restful.api.web.events.ResourceCreated;
import com.conference.restful.api.web.exception.ResourceNotFoundException;
import com.conference.services.ITemplateService;

@RestController
@RequestMapping(TemplateRestController.RESOURCE_PATH)
public class TemplateRestController {

	public static final String RESOURCE_PATH = "/templates";
	
	@Autowired
	private ITemplateService templatesService;
	
	@Autowired
    private ApplicationEventPublisher eventPublisher;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createTemplate(
			@RequestBody @Valid TemplateDto templateDto,
			HttpServletResponse response) {
		Template template = new Template();
		BeanUtils.copyProperties(templateDto, template);
		templatesService.createTemplate(template);
		eventPublisher.publishEvent(new ResourceCreated(this, response, template.getId()));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getTemplateById(@PathVariable String id) {
		Template template = templatesService.getTemplate(id);
		if (template == null ) {
			throw new ResourceNotFoundException();
		}
		return new ResponseEntity<TemplateDto>(new TemplateDto(template), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<TemplateDto> getTemplates() {
		List<Template> templates = templatesService.getTemplates();
		List<TemplateDto> templatesDto = convertTemplatesToDto(templates);
		return templatesDto;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateTemplate(
			@RequestBody @Valid TemplateDto templateDto,
			HttpServletResponse response) {
		Template template = new Template();
		BeanUtils.copyProperties(templateDto, template);
		templatesService.updateTemplate(template);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteTemplate(@PathVariable String id) {
		templatesService.deleteTemplateById(id);
	}
	
	
	public List<TemplateDto> convertTemplatesToDto(List<Template> Templates) {
		List<TemplateDto> TemplatesDto = new ArrayList<TemplateDto>();
		for (Template Template: Templates) {
			TemplatesDto.add(new TemplateDto(Template));
		}
		return TemplatesDto;
	}
	
}
