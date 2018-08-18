package com.leocaliban.workshop.mongodb.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.leocaliban.workshop.mongodb.services.exception.ObjetoNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoException exception, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(), status.value(), 
							"Recurso não encontrado.", exception.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
	
}
