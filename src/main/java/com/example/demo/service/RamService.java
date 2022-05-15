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
	
	public List<Ram> findAll() {
		return repoRam.findAll();
	}
	
	public Ram buscarRam(Long id) {
		return repoRam.findById(id).orElse(null);
	}
	
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
			repoRam.save(newRam);
			
			return newRam;
		} else {
			return null;
		}
	}

}
