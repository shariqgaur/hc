package com.hc.dao;

import java.util.List;

import com.hc.model.User1;

public interface UserDAL {

	List<User1> getAllUsers();

	User1 getUserById(String userId);

	User1 addNewUser(User1 user);

	Object getAllUserSettings(String userId);

	String getUserSetting(String userId, String key);

	String addUserSetting(String userId, String key, String value);
}