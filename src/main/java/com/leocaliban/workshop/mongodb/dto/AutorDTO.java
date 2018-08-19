package com.leocaliban.workshop.mongodb.dto;

import java.io.Serializable;

import com.leocaliban.workshop.mongodb.domain.Usuario;

public class AutorDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	
	public AutorDTO() {
		
	}
	
	public AutorDTO(Usuario objeto) {
		this.id = objeto.getId();
		this.nome = objeto.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
