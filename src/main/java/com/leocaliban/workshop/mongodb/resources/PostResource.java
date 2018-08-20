package com.leocaliban.workshop.mongodb.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leocaliban.workshop.mongodb.domain.Post;
import com.leocaliban.workshop.mongodb.resources.util.URL;
import com.leocaliban.workshop.mongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Post>> buscarTodos(){
		List<Post> lista = service.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> buscarPorId(@PathVariable String id){
		Post objeto = service.buscarPorId(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	@RequestMapping(value = "/buscartitulo", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> buscarPorTitulo(@RequestParam(value = "texto", defaultValue = "") String texto){
		
		texto = URL.decodeParam(texto);
		List<Post> lista = service.buscarPorTitulo(texto);
		
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value = "/buscacompleta", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> buscaCompleta(
			@RequestParam(value = "texto", defaultValue = "") String texto,
			@RequestParam(value = "dataMinima", defaultValue = "") String dataMinima,
			@RequestParam(value = "dataMaxima", defaultValue = "") String dataMaxima){
		
		texto = URL.decodeParam(texto);
		
		Date min = URL.converterData(dataMinima, new Date(0L));
		Date max = URL.converterData(dataMaxima, new Date());
		
		List<Post> lista = service.buscaCompleta(texto, min, max);
		
		return ResponseEntity.ok().body(lista);
	}
	
	

}
