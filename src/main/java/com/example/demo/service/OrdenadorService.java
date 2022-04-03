package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ordenador;
import com.example.demo.model.componentes.Disco;
import com.example.demo.model.componentes.Fuente;
import com.example.demo.model.componentes.Grafica;
import com.example.demo.model.componentes.Procesador;
import com.example.demo.model.componentes.Ram;
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

	public Procesador sacarProcesador(Long id) {
		Ordenador ordenador=repoOrdenador.findById(id).orElse(null);
		return ordenador.getProcesador();
	}
	
	public Ram sacarRam(Long id) {
		Ordenador ordenador=repoOrdenador.findById(id).orElse(null);
		return ordenador.getRam();
	}
	
	public Disco sacarDisco(Long id) {
		Ordenador ordenador=repoOrdenador.findById(id).orElse(null);
		return ordenador.getDiscoduro();
	}
	
	public Grafica sacarGrafica(Long id) {
		Ordenador ordenador=repoOrdenador.findById(id).orElse(null);
		return ordenador.getGrafica();
	}
	
	public Fuente sacarFuente(Long id) {
		Ordenador ordenador=repoOrdenador.findById(id).orElse(null);
		return ordenador.getFuente();
	}
	
}
