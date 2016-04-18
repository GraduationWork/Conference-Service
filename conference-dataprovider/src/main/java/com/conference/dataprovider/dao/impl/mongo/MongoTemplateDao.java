package com.conference.dataprovider.dao.impl.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.conference.dataprovider.dao.ITemplateDao;
import com.conference.dataprovider.domain.Template;

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

}
