package com.conference.dataprovider.dao;

import java.util.List;

import com.conference.core.domain.Template;

public interface ITemplateDao {
	public void createTemplate(Template template);
	public List<Template> readTemplates();
	public void updateTemplate(Template template);
	public void deleteTemplate(Template template);
}
