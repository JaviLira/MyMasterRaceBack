package com.example.demo.model;

/**
 * Clase para devolver un mensaje al subir un archivo
 * @author macab
 *
 */

public class FileMessage {

	private String message;

	public FileMessage(String message) {
		super();
		this.message = message;
	}

	public FileMessage() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
