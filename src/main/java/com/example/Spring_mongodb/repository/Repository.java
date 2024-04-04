package com.example.Spring_mongodb.repository;

import com.example.Spring_mongodb.model.Userdetails;
import org.springframework.data.mongodb.repository.MongoRepository;

@org.springframework.stereotype.Repository
public interface Repository extends MongoRepository <Userdetails,String>{

}
