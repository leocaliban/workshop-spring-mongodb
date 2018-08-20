package com.leocaliban.workshop.mongodb.repository;

import java.util.Date;
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
	
	@Query("{ $and: [ { data: {$gte: ?1} }, { data: {$lte: ?2} } , { $or: [ { 'titulo' : { $regex: ?0, $options: 'i'} }, { 'texto' : { $regex: ?0, $options: 'i'} }, { 'comentarios.texto' : { $regex: ?0, $options: 'i'} } ] } ] }")
	public List<Post> buscaCompleta(String texto, Date dataMinima, Date dataMaxima);

}
