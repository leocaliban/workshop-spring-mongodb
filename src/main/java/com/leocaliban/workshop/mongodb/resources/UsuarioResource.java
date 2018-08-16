package com.leocaliban.workshop.mongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leocaliban.workshop.mongodb.domain.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> buscarTodos(){
		Usuario usuario01 = new Usuario("1", "Jack Bauer", "jackuct@gmail.com");
		Usuario usuario02 = new Usuario("2", "Kim Bauer", "kim@gmail.com");
		List<Usuario> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(usuario01, usuario02));
		return ResponseEntity.ok().body(lista);
	}

}
