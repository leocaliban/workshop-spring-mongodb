package com.leocaliban.workshop.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.leocaliban.workshop.mongodb.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
