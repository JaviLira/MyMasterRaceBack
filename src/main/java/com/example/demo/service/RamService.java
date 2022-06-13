package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Ram;
import com.example.demo.repository.RamRepo;

@Service("ramService")
public class RamService {
	
	@Autowired
	private RamRepo repoRam;
	
	/**
	 * lista todas las rams
	 */
	
	public List<Ram> findAll() {
		return repoRam.findAll();
	}
	
	/**
	 * saca una ram concreta
	 * @param id
	 * @return
	 */
	
	public Ram buscarRam(Long id) {
		return repoRam.findById(id).orElse(null);
	}
	
	/**
	 * lista las rams compatibles
	 * @param id
	 * @return
	 */
	
	public List<Ram> listarRamsCompatibles(Long id){
		Ram referencia=buscarRam(id);
		List<Ram> listaRams=new ArrayList<>();
		for (Ram ram : repoRam.findAll()) {
			if (referencia.getTipo().equals(ram.getTipo()) && referencia.getFormato().equals(ram.getFormato())) {
				listaRams.add(ram);
			}
		}
		return listaRams;
	}
	
	/**
	 * Crea una ram
	 * @param ram
	 * @return
	 */
	
	public Ram crearRam(Ram ram) {
		if (ram.getCantidad()>=1 
				&& !"".equals(ram.getDescripcion()) && ram.getDescripcion()!=null
				&& ram.getCapacidad()>=1
				&& !"".equals(ram.getFormato()) && ram.getFormato()!=null
				&& !"".equals(ram.getNombre()) && ram.getNombre()!=null
				&& !"".equals(ram.getKit()) && ram.getKit()!=null
				&& !"".equals(ram.getTipo()) && ram.getTipo()!=null
				&& ram.getPrecio()>=1) {
			Ram newRam=new Ram();
			
			newRam.setCantidad(ram.getCantidad());
			newRam.setDescripcion(ram.getDescripcion());
			newRam.setImagenes(ram.getImagenes());
			newRam.setCapacidad(ram.getCantidad());
			newRam.setFormato(ram.getFormato());
			newRam.setNombre(ram.getNombre());
			newRam.setPrecio(ram.getPrecio());	
			newRam.setTipo(ram.getTipo());	
			newRam.setKit(ram.getKit());	
			repoRam.save(newRam);
			
			return newRam;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Edita una ram, si algun dato esta vacio no lo cambia
	 * @param id
	 * @param disco
	 * @return
	 */
	
	public Ram editRam(Long id,Ram ram) {
		Ram ramEdit=repoRam.findById(id).orElse(null);
		if (ramEdit!=null) {
			if (!"".equals(ram.getFormato()) && ram.getFormato()!=null) {
				ramEdit.setFormato(ram.getFormato());
			}
			if (!"".equals(ram.getTipo()) && ram.getTipo()!=null) {
				ramEdit.setTipo(ram.getTipo());
			}
			if (ram.getCapacidad()>=1) {
				ramEdit.setCapacidad(ram.getCapacidad());
			}
			if (!"".equals(ram.getKit()) && ram.getKit()!=null) {
				ramEdit.setKit(ram.getKit());
			}
			if (ram.getCantidad()>=1) {
				ramEdit.setCantidad(ram.getCantidad());
			}
			if (ram.getDescripcion()!=null && !"".equals(ram.getDescripcion())) {
				ramEdit.setDescripcion(ram.getDescripcion());
			}
			if (ram.getNombre()!=null && !"".equals(ram.getNombre())) {
				ramEdit.setNombre(ram.getNombre());
			}
			if (ram.getPrecio()>=1) {
				ramEdit.setPrecio(ram.getPrecio());
			}
			repoRam.save(ramEdit);
			
			return ramEdit;
		}else {
			return null;
		}
	}
	
	/**
	 * borra una ram
	 * @param id
	 * @return
	 */
	
	public Ram deleteRam(Long id) {
		return repoRam.findById(id).orElse(null);
	}

}
