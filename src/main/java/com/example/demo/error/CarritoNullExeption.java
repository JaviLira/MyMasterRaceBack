package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarritoNullExeption extends RuntimeException{

	/**
	 * El carrito no tiene articulos
	 */
	private static final long serialVersionUID = 2215044373849339104L;

	public CarritoNullExeption() {
		super("El carrito esta vacio");
	}
}
