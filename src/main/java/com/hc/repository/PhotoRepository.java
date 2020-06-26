package com.hc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hc.model.Photo;



public interface PhotoRepository extends MongoRepository<Photo, String> {

}