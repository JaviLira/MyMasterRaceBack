package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CantidadExeption extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8939307636517772891L;

	public CantidadExeption() {
		super("No quedan mas unidades de este producto");
	}
}
