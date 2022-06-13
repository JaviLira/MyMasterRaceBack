package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioNoHaCompradoEseArticuloExeption extends RuntimeException{

	/**
	 * No puede comentar porque no ha comprado el articulo
	 */
	private static final long serialVersionUID = -3575073917132086760L;

	public UsuarioNoHaCompradoEseArticuloExeption() {
		super("No has comprado el articulo");
	}
}
