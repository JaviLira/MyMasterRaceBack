package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Fuente;
import com.example.demo.repository.FuenteRepo;

@Service("fuenteService")
public class FuenteService {
	
	@Autowired
	private FuenteRepo repoFuente;
	

	public Fuente buscarFuente(Long id) {
		return repoFuente.findById(id).orElse(null);
	}
	
	public List<Fuente> findAll() {
		return repoFuente.findAll();
	}
	
	
}
