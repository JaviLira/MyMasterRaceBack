package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CantidadNegativaExeption extends RuntimeException{

	private static final long serialVersionUID = 3976706892903904812L;

	/**
	 * Caantidad negativa
	 */


	public CantidadNegativaExeption() {
		super("No te puedes deber dinero asi que no nos puedes deber articulos");
	}
}
