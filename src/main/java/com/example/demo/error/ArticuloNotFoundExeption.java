package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArticuloNotFoundExeption extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3253593958328409278L;

	public ArticuloNotFoundExeption(String articulo,Long id) {
		super("No se puede encontrar el articulo "+articulo+ " con ID: "+ id);
	}
}
