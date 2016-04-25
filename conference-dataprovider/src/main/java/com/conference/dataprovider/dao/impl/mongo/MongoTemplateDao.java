package com.conference.dataprovider.dao.impl.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.conference.core.domain.Template;
import com.conference.dataprovider.dao.ITemplateDao;

@Repository
public class MongoTemplateDao implements ITemplateDao{

	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public void createTemplate(Template template) {
		mongoOperations.insert(template);
	}

	@Override
	public List<Template> readTemplates() {
		return mongoOperations.findAll(Template.class);		
	}

	@Override
	public void updateTemplate(Template template) {
		mongoOperations.save(template);
	}

	@Override
	public void deleteTemplate(Template template) {
		mongoOperations.remove(template);
	}

	@Override
	public Template readTemplate(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTemplate(String id) {
		// TODO Auto-generated method stub
		
	}

}
