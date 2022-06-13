package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RolAdministradorExeption extends RuntimeException{


    /**
     * salta si el rol no es administrador
     */
	private static final long serialVersionUID = -6882418255334351428L;

	public RolAdministradorExeption() {
		super("Te falta calle");
	}
}
