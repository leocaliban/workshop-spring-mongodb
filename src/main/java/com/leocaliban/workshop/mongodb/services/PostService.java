package com.leocaliban.workshop.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leocaliban.workshop.mongodb.domain.Post;
import com.leocaliban.workshop.mongodb.repository.PostRepository;
import com.leocaliban.workshop.mongodb.services.exception.ObjetoNaoEncontradoException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public List<Post> buscarTodos(){
		return repository.findAll();
	}
	
	public Post buscarPorId(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
	}
	
}
