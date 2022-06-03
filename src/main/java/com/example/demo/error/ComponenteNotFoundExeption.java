package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ComponenteNotFoundExeption extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1099744240002192914L;

	public ComponenteNotFoundExeption() {
		super("Uno de los componentes no se a encontrado en la base de datos");
	}
}
