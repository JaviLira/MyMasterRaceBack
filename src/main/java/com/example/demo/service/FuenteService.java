package com.example.demo.service;

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
	
	public Fuente crearFuente(Fuente fuente) {
		if (fuente.getCantidad()>=1 && fuente.getPotencia()>=1 
			&& fuente.getPrecio()>=1
			&& !"".equals(fuente.getDescripcion()) && fuente.getDescripcion()!=null
			&& !"".equals(fuente.getNombre()) && fuente.getNombre()!=null) {
			Fuente newFuente = new Fuente();
			newFuente.setCantidad(fuente.getCantidad());
			newFuente.setCertificacion(fuente.getCertificacion());
			newFuente.setDescripcion(fuente.getDescripcion());
			newFuente.setImagenes(fuente.getImagenes());
			newFuente.setNombre(fuente.getNombre());
			newFuente.setPotencia(fuente.getPotencia());
			newFuente.setPrecio(fuente.getPrecio());
			repoFuente.save(newFuente);
			
			return newFuente;
		}else {
			return null;
		}
		
	}
	
	
}
