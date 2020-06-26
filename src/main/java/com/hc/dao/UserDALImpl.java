package com.hc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.hc.model.User1;

@Repository
public class UserDALImpl implements UserDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<User1> getAllUsers() {
		return mongoTemplate.findAll(User1.class);
	}

	@Override
	public User1 getUserById(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		return mongoTemplate.findOne(query, User1.class);
	}

	@Override
	public User1 addNewUser(User1 user) {
		mongoTemplate.save(user);
		// Now, user object will contain the ID as well
		return user;
	}

	@Override
	public Object getAllUserSettings(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		User1 user = mongoTemplate.findOne(query, User1.class);
		return user != null ? user.getUserSettings() : "User not found.";
	}

	@Override
	public String getUserSetting(String userId, String key) {
		Query query = new Query();
		query.fields().include("userSettings");
		query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("userSettings." + key).exists(true)));
		User1 user = mongoTemplate.findOne(query, User1.class);
		return user != null ? user.getUserSettings().get(key) : "Not found.";
	}

	@Override
	public String addUserSetting(String userId, String key, String value) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		User1 user = mongoTemplate.findOne(query, User1.class);
		if (user != null) {
			user.getUserSettings().put(key, value);
			mongoTemplate.save(user);
			return "Key added.";
		} else {
			return "User not found.";
		}
	}
}
