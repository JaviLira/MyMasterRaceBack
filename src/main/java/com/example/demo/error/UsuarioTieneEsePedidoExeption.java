package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioTieneEsePedidoExeption extends RuntimeException{


	/**
	 * El usuario no tiene un peido con esa id
	 */
	private static final long serialVersionUID = -4956545383942638523L;

	public UsuarioTieneEsePedidoExeption(String usuario, Long id) {
		super(usuario+" no tiene un pedido con la id: "+ id);
	}
}
