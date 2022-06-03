package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EstadoExeption extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4885631932773979434L;

	public EstadoExeption() {
		super("El estado solo puede ser true o false");
	}
}
