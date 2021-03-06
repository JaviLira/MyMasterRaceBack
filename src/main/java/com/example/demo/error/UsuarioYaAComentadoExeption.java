package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioYaAComentadoExeption extends RuntimeException{

	/**
	 * No puede comentar porque ya ha comentado ese articulo
	 */
	private static final long serialVersionUID = -4991965656114287661L;

	public UsuarioYaAComentadoExeption() {
		super("Ya has comentado este articulo");
	}
}
