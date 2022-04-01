package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ordenador;
import com.example.demo.model.componentes.Grafica;
import com.example.demo.repository.OrdenadoresRepo;

@Service("ordenadorService")
public class OrdenadorService {
	
	@Autowired
	private OrdenadoresRepo repoOrdenador;
	
	@Autowired
	private DiscoService serviceDisco;
	
	@Autowired
	private FuenteService serviceFuente;
	
	@Autowired
	private ProcesadorService serviceProcesador;
	
	@Autowired
	private RamService serviceRam;
	
	@Autowired
	private GraficaService serviceGrafica;
	
	public Ordenador buscarOrdenador(Long id) {
		return repoOrdenador.findById(id).orElse(null);
	}
	
	public List<Ordenador> findAll() {
		return repoOrdenador.findAll();
	}

}
