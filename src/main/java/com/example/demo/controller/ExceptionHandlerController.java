package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.error.ApiError;
import com.example.demo.error.EstadoExeption;
import com.example.demo.error.ArticuloIdNotFoundExeption;
import com.example.demo.error.ComponenteNoActivoNotFoundExeption;
import com.example.demo.error.ComponenteNotFoundExeption;

@ControllerAdvice
public class ExceptionHandlerController {

	
    @ExceptionHandler(EstadoExeption.class)
    public ResponseEntity<ApiError> EstadoExeption(EstadoExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	}
    
    @ExceptionHandler(ArticuloIdNotFoundExeption.class)
    public ResponseEntity<ApiError> ArticuloIdNotFoundExeption(ArticuloIdNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	}
    
    @ExceptionHandler(ComponenteNotFoundExeption.class)
    public ResponseEntity<ApiError> ComponenteNotFoundExeption(ComponenteNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	}
    
    @ExceptionHandler(ComponenteNoActivoNotFoundExeption.class)
    public ResponseEntity<ApiError> ComponenteNoActivoNotFoundExeption(ComponenteNoActivoNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	}
}
