package com.conference.services;

import java.util.List;

import com.conference.core.domain.Template;

public interface ITemplateService {
	void createTemplate(Template template);
	Template getTemplate(String id);
	List<Template> getTemplates();
	void updateTemplate(Template template);
	void deleteTemplateById(String id);
}
