package com.exercicio_s7.exerc_api_s7.services.exceptions;

public class NaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NaoEncontradoException(String msg) {
		super(msg);
	}

}
