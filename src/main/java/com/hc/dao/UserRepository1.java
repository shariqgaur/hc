package com.hc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hc.model.User1;

@Repository
public interface UserRepository1 extends MongoRepository<User1, String> {
}
