package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArticuloIdNotFoundExeption extends RuntimeException{


	/**
	 * No se puede encontrar el articulo con una id concreta
	 */
	private static final long serialVersionUID = -5962841244154326365L;

	public ArticuloIdNotFoundExeption(Long id) {
		super("No se puede encontrar el articulo con ID: "+ id);
	}
}
