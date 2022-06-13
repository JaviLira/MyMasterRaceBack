package com.example.demo.service;


import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrdenadorVendido;
import com.example.demo.repository.OrdenadorVendidoRepo;

@Service("ordenadorVendidoService")
public class OrdenadorVendidoService {
	
	@Autowired
	private OrdenadorVendidoRepo repoOrdenadorVendido;
	
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
	
	/**
	 * saca el ordenadorVendido que quieres
	 * @param id
	 * @return
	 */
	
	public OrdenadorVendido buscarOrdenadorVendido(Long id) {
		return repoOrdenadorVendido.findById(id).orElse(null);
	}
	
	/**
	 * lista todos los ordenadoresVendidos
	 * @return
	 */
	
	public List<OrdenadorVendido> findAll() {
		return repoOrdenadorVendido.findAll();
	}
	
	/**
	 * crea un ordenador vendido
	 * @param ordenadorV
	 * @return
	 */
	
	public OrdenadorVendido addOrdenadorVendido(OrdenadorVendido ordenadorV) {
		OrdenadorVendido confirmar=confirmarExistencia(ordenadorV);
		
		if (confirmar!=null) {
			return confirmar;
		}else {
			OrdenadorVendido ordenadorNuevo=new OrdenadorVendido();
			
			ordenadorNuevo.setRam(serviceRam.buscarRam(ordenadorV.getRam().getId()));
			ordenadorNuevo.setProcesador(serviceProcesador.buscarProcesador(ordenadorV.getProcesador().getId()));
			ordenadorNuevo.setPrecio(ordenadorV.getPrecio());
			ordenadorNuevo.setNombre(ordenadorV.getNombre());
			ordenadorNuevo.setImagenes(ordenadorV.getImagenes());
			ordenadorNuevo.setGrafica(serviceGrafica.buscarGrafica(ordenadorV.getGrafica().getId()));
			ordenadorNuevo.setFuente(serviceFuente.buscarFuente(ordenadorV.getFuente().getId()));
			ordenadorNuevo.setDiscoduro(serviceDisco.buscarDisco(ordenadorV.getDiscoduro().getId()));
			ordenadorNuevo.setDescripcion(ordenadorV.getDescripcion());
			ordenadorNuevo.setCantidad(6);
			
			return repoOrdenadorVendido.save(ordenadorNuevo);
		}
	}
	
	/**
	 * borra un ordenador vendido
	 * @param ordenadorV
	 * @return
	 */
	
	public OrdenadorVendido deleteOrdenadorVendido(Long ordenadorV) {
		OrdenadorVendido ordenador=repoOrdenadorVendido.findById(ordenadorV).orElse(null);
		repoOrdenadorVendido.deleteById(ordenadorV);
		return ordenador;
	}
	
	/**
	 * confirma si el ordenador vendido aun existe
	 * @param ordenador
	 * @return
	 */
	
	public OrdenadorVendido confirmarExistencia(OrdenadorVendido ordenador) {
		List<OrdenadorVendido> listaOrdenadoresCreados=repoOrdenadorVendido.findAll();
		OrdenadorVendido ordenadorExiste=null;
		
		for (OrdenadorVendido laPc : listaOrdenadoresCreados) {
			if(Objects.equals(laPc.getNombre(), ordenador.getNombre()) &&
					laPc.getDiscoduro().getId()==ordenador.getDiscoduro().getId() &&
					laPc.getFuente().getId()==ordenador.getFuente().getId() &&
					laPc.getGrafica().getId()==ordenador.getGrafica().getId() &&
					laPc.getProcesador().getId()==ordenador.getProcesador().getId() &&
					laPc.getRam().getId()==ordenador.getRam().getId()) {
				ordenadorExiste=laPc;
				}
		}
		
		if (ordenadorExiste!=null) {
			return ordenadorExiste;
		}else {
			return null;
		}
		
		
	}

}
