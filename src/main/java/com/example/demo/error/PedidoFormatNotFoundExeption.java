package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PedidoFormatNotFoundExeption extends RuntimeException{

	/**
	 * Error con algun valor del pedido
	 */
	private static final long serialVersionUID = 17771401311324885L;

	public PedidoFormatNotFoundExeption() {
		super("Error en el formato del pedido");
	}
}
