package com.leocaliban.workshop.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.leocaliban.workshop.mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'titulo' : { $regex: ?0, $options: 'i'} }")
	public List<Post> buscarPorTitulo(String texto);
	
	public List<Post> findByTituloContainingIgnoreCase(String texto);

}
