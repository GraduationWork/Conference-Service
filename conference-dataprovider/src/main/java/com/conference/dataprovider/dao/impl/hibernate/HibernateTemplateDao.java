package com.conference.dataprovider.dao.impl.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.conference.core.domain.Template;
import com.conference.dataprovider.dao.ITemplateDao;

@Repository
public class HibernateTemplateDao extends BaseHibernateDao implements ITemplateDao {

	@Override
	public void createTemplate(Template template) {
		getSession().save(template);
	}

	@Override
	public List<Template> readTemplates() {
		return getSession().createCriteria(Template.class).list();
	}

	@Override
	public void updateTemplate(Template template) {
		getSession().update(template);
	}

	@Override
	public void deleteTemplate(Template template) {
		getSession().delete(template);
	}

	@Override
	public Template readTemplate(String id) {
		return getSession().get(Template.class, id);
	}

	@Override
	public void deleteTemplate(String id) {
		Template template = new Template();
		template.setId(id);
		getSession().delete(template);
	}

}
