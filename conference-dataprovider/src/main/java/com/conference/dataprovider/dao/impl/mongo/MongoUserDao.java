package com.conference.dataprovider.dao.impl.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.conference.core.domain.User;
import com.conference.dataprovider.dao.IUserDao;

@Repository
public class MongoUserDao implements IUserDao{

	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public void createUser(User user) {
		mongoOperations.insert(user);
	}

	@Override
	public User readUserByUsername(String username) {
		return mongoOperations.findById(username, User.class);
	}

	@Override
	public List<User> readUsers() {
		return mongoOperations.findAll(User.class);
	}

	@Override
	public List<User> readUsers(int page, int pageSize) {
		Query query = new Query();
		query.skip((page-1)* pageSize);
		query.limit(pageSize);
		return mongoOperations.find(query, User.class);
	}

	@Override
	public void updateUser(User user) {
		mongoOperations.save(user);
	}

	@Override
	public void activateUser(String username, boolean active) {
		Query searchUserQuery = new Query(Criteria.where("username").is(username));
		mongoOperations.findAndModify(searchUserQuery, Update.update("isActive", active), User.class);
	}

	@Override
	public boolean exists(String username) {
		return mongoOperations.exists(Query.query(Criteria.where("username").is(username)), User.class);
	}

	@Override
	public void deleteUser(String username) {
		mongoOperations.remove(mongoOperations.findById(username, User.class));
	}
	
	

}
