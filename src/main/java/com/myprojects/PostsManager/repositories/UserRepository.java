package com.myprojects.PostsManager.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myprojects.PostsManager.domain.User;

//@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
