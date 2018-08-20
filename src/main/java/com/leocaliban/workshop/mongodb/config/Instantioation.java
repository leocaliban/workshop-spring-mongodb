package com.leocaliban.workshop.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.leocaliban.workshop.mongodb.domain.Post;
import com.leocaliban.workshop.mongodb.domain.Usuario;
import com.leocaliban.workshop.mongodb.dto.AutorDTO;
import com.leocaliban.workshop.mongodb.repository.PostRepository;
import com.leocaliban.workshop.mongodb.repository.UsuarioRepository;

@Configuration
public class Instantioation implements CommandLineRunner{
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepository.deleteAll();
		postRepository.deleteAll();

		Usuario usuario1 = new Usuario(null, "Rafael Oliveira", "ro@gmail.com");
		Usuario usuario2 = new Usuario(null, "Michelle Rodriguez", "mr@gmail.com");
		Usuario usuario3 = new Usuario(null, "Kelly Young", "ky@gmail.com");
		Usuario usuario4 = new Usuario(null, "Fátima Silva", "fatima@gmail.com");
		Usuario usuario5 = new Usuario(null, "Kim Bauer", "kim@gmail.com");
		Usuario usuario6 = new Usuario(null, "Alana Sandra", "as@gmail.com");
		
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3, usuario4, usuario5, usuario6));
		
		Post post1 = new Post(null, sdf.parse("21/05/2018"), "Nova postagem", "Postagem sem texto.", new AutorDTO(usuario1));
		Post post2 = new Post(null, sdf.parse("28/08/2018"), "Viagem", "Viagem adiada para...", new AutorDTO(usuario2));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		usuario1.getPosts().addAll(Arrays.asList(post1, post2));
		usuarioRepository.save(usuario1);
		
		
	}

}
