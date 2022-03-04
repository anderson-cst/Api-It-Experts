package com.exercicio_s7.exerc_api_s7.services.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exercicio_s7.exerc_api_s7.models.ErroPadrao;


@RestControllerAdvice
public class ExceptionsGerais {

	@ExceptionHandler(EntradaInvalidaException.class)
	public ResponseEntity<ErroPadrao> entradaInvalida(EntradaInvalidaException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.CONFLICT;
		ErroPadrao erro = new ErroPadrao();
		erro.setTimeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Favor rever os valores de entrada");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);		
	}
	
	@ExceptionHandler(NaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> naoEncontrado(NaoEncontradoException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erro = new ErroPadrao();
		erro.setTimeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Não encontrado, inserir valores válidos para pesquisa!");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);		
	}
	
	@ExceptionHandler(MissingPathVariableException.class)
	public ResponseEntity<ErroPadrao> missingPath(MissingPathVariableException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erro = new ErroPadrao();
		erro.setTimeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Inserção para registro inexistente!");
		erro.setMessage("É necessário inserir o Cliente primeiramente!");
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);		
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErroPadrao> notReadable(HttpMessageNotReadableException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erro = new ErroPadrao();
		erro.setTimeStamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError("Favor rever os valores de entrada!");
		erro.setMessage("Campos com conflito!");
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);		
	}
	
	
}
