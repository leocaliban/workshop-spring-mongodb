package com.leocaliban.workshop.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leocaliban.workshop.mongodb.domain.Usuario;
import com.leocaliban.workshop.mongodb.dto.UsuarioDTO;
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
	
	public Usuario salvar(Usuario objeto) {
		return repository.insert(objeto);
	}
	
	public Usuario editar(Usuario objeto) {
		Usuario novo = buscarPorId(objeto.getId());
		atualizarDados(novo, objeto);
		return repository.save(novo);
	}
	
	private void atualizarDados(Usuario novo, Usuario objeto) {
		novo.setNome(objeto.getNome());
		novo.setEmail(objeto.getEmail());
		
	}

	public void deletar(String id) {
		buscarPorId(id);
		repository.deleteById(id);
	}
	
	public Usuario fromDTO(UsuarioDTO objetoDTO) {
		return new Usuario(objetoDTO.getId(), objetoDTO.getNome(), objetoDTO.getEmail());
	}

}
