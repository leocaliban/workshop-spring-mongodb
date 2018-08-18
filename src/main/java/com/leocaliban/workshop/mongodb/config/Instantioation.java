package com.leocaliban.workshop.mongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.leocaliban.workshop.mongodb.domain.Usuario;
import com.leocaliban.workshop.mongodb.repository.UsuarioRepository;

@Configuration
public class Instantioation implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();

		Usuario usuario1 = new Usuario(null, "Rafael Oliveira", "ro@gmail.com");
		Usuario usuario2 = new Usuario(null, "Michelle Rodriguez", "mr@gmail.com");
		Usuario usuario3 = new Usuario(null, "Kelly Young", "ky@gmail.com");
		Usuario usuario4 = new Usuario(null, "Fátima Silva", "fatima@gmail.com");
		Usuario usuario5 = new Usuario(null, "Kim Bauer", "kim@gmail.com");
		Usuario usuario6 = new Usuario(null, "Alana Sandra", "as@gmail.com");
		
		repository.saveAll(Arrays.asList(usuario1, usuario2, usuario3, usuario4, usuario5, usuario6));
		
		
		
	}

}
