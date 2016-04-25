package com.conference.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conference.core.domain.Template;
import com.conference.dataprovider.dao.ITemplateDao;
import com.conference.services.ITemplateService;

@Service
@Transactional
public class TemplateServiceImpl implements ITemplateService{

	private ITemplateDao templateDao;
	
	@Autowired
	public TemplateServiceImpl(ITemplateDao templateDao) {
		this.templateDao = templateDao;
	}
	
	@Override
	public void createTemplate(Template template) {
		templateDao.createTemplate(template);
	}

	@Override
	public Template getTemplate(String id) {
		return templateDao.readTemplate(id);
	}

	@Override
	public List<Template> getTemplates() {
		return templateDao.readTemplates();
	}

	@Override
	public void updateTemplate(Template template) {
		templateDao.updateTemplate(template);
	}

	@Override
	public void deleteTemplateById(String id) {
		templateDao.deleteTemplate(id);
	}

}
