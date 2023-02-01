package com.myprojects.PostsManager.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myprojects.PostsManager.domain.Post;

//@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	//User findOne(String id);

}
