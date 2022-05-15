package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ComentarioExeption extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6921872424277956690L;

	public ComentarioExeption() {
		super("Un error ocurrio con el comentario");
	}
}
