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
	
	/**
	 * muestra la fuente que le pases por la id si existe
	 * @param id
	 * @return
	 */

	public Fuente buscarFuente(Long id) {
		return repoFuente.findById(id).orElse(null);
	}
	
	/**
	 * Muestra todas las furntes de la base de datos
	 * @return
	 */
	
	public List<Fuente> findAll() {
		return repoFuente.findAll();
	}
	
	/**
	 * crea una fuente
	 * @param fuente
	 * @return
	 */
	
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
	
	/**
	 * Edita una ram, si algun dato esta vacio no lo cambia
	 * @param id
	 * @param disco
	 * @return
	 */
	
	public Fuente editFuente(Long id,Fuente fuente) {
		Fuente fuenteEdit=repoFuente.findById(id).orElse(null);
		if (fuenteEdit!=null) {
			if (!"".equals(fuente.getCertificacion()) && fuente.getCertificacion()!=null) {
				fuenteEdit.setCertificacion(fuente.getCertificacion());
			}
			if (fuente.getPotencia()>=1) {
				fuenteEdit.setPotencia(fuente.getPotencia());
			}
			if (fuente.getCantidad()>=1) {
				fuenteEdit.setCantidad(fuente.getCantidad());
			}
			if (fuente.getDescripcion()!=null && !"".equals(fuente.getDescripcion())) {
				fuenteEdit.setDescripcion(fuente.getDescripcion());
			}
			if (fuente.getNombre()!=null && !"".equals(fuente.getNombre())) {
				fuenteEdit.setNombre(fuente.getNombre());
			}
			if (fuente.getPrecio()>=1) {
				fuenteEdit.setPrecio(fuente.getPrecio());
			}
			repoFuente.save(fuenteEdit);
			
			return fuenteEdit;
		}else {
			return null;
		}
	}
	
	
}
