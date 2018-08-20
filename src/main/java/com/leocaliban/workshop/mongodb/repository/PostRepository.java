package com.leocaliban.workshop.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.leocaliban.workshop.mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	public List<Post> findByTituloContainingIgnoreCase(String texto);

}
