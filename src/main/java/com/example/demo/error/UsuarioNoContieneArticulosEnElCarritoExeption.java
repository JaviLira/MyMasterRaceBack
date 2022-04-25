package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.LOCKED)
public class UsuarioNoContieneArticulosEnElCarritoExeption extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4639053746464395995L;

	public UsuarioNoContieneArticulosEnElCarritoExeption(String usuario) {
		super(usuario+" no tiene articulos en el carrito");
	}
}
