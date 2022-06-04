package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.error.ComponenteNoActivoNotFoundExeption;
import com.example.demo.error.ComponenteNotFoundExeption;
import com.example.demo.model.Ordenador;
import com.example.demo.model.componentes.Disco;
import com.example.demo.model.componentes.Fuente;
import com.example.demo.model.componentes.Grafica;
import com.example.demo.model.componentes.Procesador;
import com.example.demo.model.componentes.Ram;
import com.example.demo.repository.DiscoRepo;
import com.example.demo.repository.FuenteRepo;
import com.example.demo.repository.GraficaRepo;
import com.example.demo.repository.OrdenadoresRepo;
import com.example.demo.repository.ProcesadorRepo;
import com.example.demo.repository.RamRepo;

@Service("ordenadorService")
public class OrdenadorService {
	
	@Autowired
	private OrdenadoresRepo repoOrdenador;
	@Autowired
	private RamRepo repoRam;
	@Autowired
	private ProcesadorRepo repoProcesador;
	@Autowired
	private GraficaRepo repoGrafica;
	@Autowired
	private FuenteRepo repoFuente;
	@Autowired
	private DiscoRepo repoDisco;
	
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
	
	public Ordenador crearOrdenador(Ordenador ordenador) {
		if (ordenador.getCantidad()>=1 
				&& !"".equals(ordenador.getDescripcion()) && ordenador.getDescripcion()!=null
				&& !"".equals(ordenador.getNombre()) && ordenador.getNombre()!=null
				&& ordenador.getPrecio()>=1) {
			Ordenador newOrdenador=new Ordenador();
			
			Ram ram = repoRam.findById(ordenador.getRam().getId()).orElse(null);
			Procesador procesador = repoProcesador.findById(ordenador.getProcesador().getId()).orElse(null);
			Disco disco = repoDisco.findById(ordenador.getDiscoduro().getId()).orElse(null);
			Fuente fuente = repoFuente.findById(ordenador.getFuente().getId()).orElse(null);
			Grafica grafica = repoGrafica.findById(ordenador.getGrafica().getId()).orElse(null);
			

			if (ram != null && procesador!= null && disco!= null && fuente!= null && grafica!= null) {
				if (!ram.isActivo() || !procesador.isActivo() || !disco.isActivo() || !fuente.isActivo() || !grafica.isActivo()) {
					throw new ComponenteNoActivoNotFoundExeption();
				}else {
					newOrdenador.setRam(ram);
					newOrdenador.setProcesador(procesador);
					newOrdenador.setGrafica(grafica);
					newOrdenador.setDiscoduro(disco);
					newOrdenador.setFuente(fuente);
					newOrdenador.setCantidad(ordenador.getCantidad());
					newOrdenador.setDescripcion(ordenador.getDescripcion());
					newOrdenador.setNombre(ordenador.getNombre());
					newOrdenador.setPrecio(ordenador.getPrecio());	
					repoOrdenador.save(newOrdenador);
					
					return newOrdenador;
				}

			}else {
				throw new ComponenteNotFoundExeption();
			} 
		}
		
		
		return null;
	}
	
}
