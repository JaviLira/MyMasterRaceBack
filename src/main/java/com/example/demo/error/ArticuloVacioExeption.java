package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ArticuloVacioExeption extends RuntimeException{
	

	/**
	 * Esta excepcion solo se deberia de ver cuando se le introduce campos vacios al ordenador
	 */
	private static final long serialVersionUID = -3865325573197962604L;

	public ArticuloVacioExeption() {
		super("No se puede crear un objeto con los datos obligatorios nulos");
	}
}
