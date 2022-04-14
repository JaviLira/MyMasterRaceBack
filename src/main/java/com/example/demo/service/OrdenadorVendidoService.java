package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ordenador;
import com.example.demo.model.OrdenadorVendido;
import com.example.demo.repository.OrdenadorVendidoRepo;
import com.example.demo.repository.OrdenadoresRepo;
import com.example.demo.repository.PedidoRepo;

@Service("ordenadorVendidoService")
public class OrdenadorVendidoService {
	
	@Autowired
	private PedidoRepo repoPedido;
	
	@Autowired
	private OrdenadorVendidoRepo repoOrdenadorVendido;
	
	@Autowired
	private OrdenadoresRepo repoOrdenadores;
	
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
	
	public OrdenadorVendido buscarOrdenadorVendido(Long id) {
		return repoOrdenadorVendido.findById(id).orElse(null);
	}
	
	public List<OrdenadorVendido> findAll() {
		return repoOrdenadorVendido.findAll();
	}
	
	public OrdenadorVendido addOrdenadorVendido(OrdenadorVendido ordenadorV) {
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
		
		
		return ordenadorNuevo;
		
	}
	
	public OrdenadorVendido deleteOrdenadorVendido(Long ordenadorV) {
		OrdenadorVendido ordenador=repoOrdenadorVendido.findById(ordenadorV).orElse(null);
		repoOrdenadorVendido.deleteById(ordenadorV);
		return ordenador;
	}

}
