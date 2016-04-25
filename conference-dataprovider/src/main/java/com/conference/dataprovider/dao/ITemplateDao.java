package com.conference.dataprovider.dao;

import java.util.List;

import com.conference.core.domain.Template;

public interface ITemplateDao {
	void createTemplate(Template template);
	Template readTemplate(String id);
	List<Template> readTemplates();
	void updateTemplate(Template template);
	void deleteTemplate(Template template);
	void deleteTemplate(String id);
}
