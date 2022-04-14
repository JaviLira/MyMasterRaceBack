package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArticuloNullExeption extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 356667847841866930L;

	public ArticuloNullExeption() {
		super("El articulo esta vacio");
	}
}
