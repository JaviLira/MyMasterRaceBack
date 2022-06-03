package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ComponenteNoActivoNotFoundExeption extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8468207531572450493L;

	public ComponenteNoActivoNotFoundExeption() {
		super("El componente no esta activo intentelo en otro momento");
	}
}
