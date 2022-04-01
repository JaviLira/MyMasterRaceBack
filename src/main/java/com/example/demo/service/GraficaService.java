package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Grafica;
import com.example.demo.repository.GraficaRepo;

@Service("graficaService")
public class GraficaService {
	
	@Autowired
	private GraficaRepo repoGrafica;
	
	public Grafica buscarGrafica(Long id) {
		return repoGrafica.findById(id).orElse(null);
	}
	
	public List<Grafica> findAll() {
		return repoGrafica.findAll();
	}
	
	
}
