package com.leocaliban.workshop.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leocaliban.workshop.mongodb.domain.Usuario;
import com.leocaliban.workshop.mongodb.repository.UsuarioRepository;
import com.leocaliban.workshop.mongodb.services.exception.ObjetoNaoEncontradoException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> buscarTodos(){
		return repository.findAll();
	}
	
	public Usuario buscarPorId(String id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
	}

}
