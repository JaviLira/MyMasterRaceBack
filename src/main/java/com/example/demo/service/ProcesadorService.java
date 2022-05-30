package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Procesador;
import com.example.demo.repository.ProcesadorRepo;

@Service("procesadorService")
public class ProcesadorService {
	
	@Autowired
	private ProcesadorRepo repoProcesador;
	
	public Procesador buscarProcesador(Long id) {
		return repoProcesador.findById(id).orElse(null);
	}
	
	public List<Procesador> findAll(){
		return repoProcesador.findAll();
	}
	
	public List<Procesador> listarProcesadoresCompatibles(Long id){
		Procesador referencia=buscarProcesador(id);
		List<Procesador> listaProcesadores=new ArrayList<>();
		for (Procesador procesador : repoProcesador.findAll()) {
			if (referencia.getSocket().equals(procesador.getSocket())) {
				listaProcesadores.add(procesador);
			}
		}
		return listaProcesadores;
	}
	
	/**
	 * Crea un procesador
	 * @param procesador
	 * @return
	 */
	
	public Procesador crearProcesador(Procesador procesador) {
		
		if (procesador.getCantidad()>=1 
				&& !"".equals(procesador.getDescripcion()) && procesador.getDescripcion()!=null
				&& !"".equals(procesador.getMarca()) && procesador.getMarca()!=null
				&& !"".equals(procesador.getModelo()) && procesador.getModelo()!=null
				&& !"".equals(procesador.getNombre()) && procesador.getNombre()!=null
				&& !"".equals(procesador.getSocket()) && procesador.getSocket()!=null
				&& procesador.getPrecio()>=1) {
			Procesador newProcesador=new Procesador();
			
			newProcesador.setCantidad(procesador.getCantidad());
			newProcesador.setDescripcion(procesador.getDescripcion());
			newProcesador.setImagenes(procesador.getImagenes());
			newProcesador.setMarca(procesador.getMarca());
			newProcesador.setModelo(procesador.getModelo());
			newProcesador.setNombre(procesador.getNombre());
			newProcesador.setPrecio(procesador.getPrecio());	
			newProcesador.setSocket(procesador.getSocket());	
			repoProcesador.save(newProcesador);
			
			return newProcesador;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Edita una procesador, si algun dato esta vacio no lo cambia
	 * @param id
	 * @param disco
	 * @return
	 */
	
	public Procesador editProcesador(Long id,Procesador procesador) {
		Procesador procesadorEdit=repoProcesador.findById(id).orElse(null);
		if (procesadorEdit!=null) {
			if (!"".equals(procesador.getMarca()) && procesador.getMarca()!=null) {
				procesadorEdit.setMarca(procesador.getMarca());
			}
			if (!"".equals(procesador.getSocket()) && procesador.getSocket()!=null) {
				procesadorEdit.setSocket(procesador.getSocket());
			}
			if (!"".equals(procesador.getModelo()) && procesador.getModelo()!=null) {
				procesadorEdit.setModelo(procesador.getModelo());
			}
			if (procesador.getCantidad()>=1) {
				procesadorEdit.setCantidad(procesador.getCantidad());
			}
			if (procesador.getDescripcion()!=null && !"".equals(procesador.getDescripcion())) {
				procesadorEdit.setDescripcion(procesador.getDescripcion());
			}
			if (procesador.getNombre()!=null && !"".equals(procesador.getNombre())) {
				procesadorEdit.setNombre(procesador.getNombre());
			}
			if (procesador.getPrecio()>=1) {
				procesadorEdit.setPrecio(procesador.getPrecio());
			}
			repoProcesador.save(procesadorEdit);
			
			return procesadorEdit;
		}else {
			return null;
		}
	}
	
	
}
