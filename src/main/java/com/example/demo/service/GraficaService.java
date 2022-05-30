package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Grafica;
import com.example.demo.repository.GraficaRepo;

@Service("graficaService")
public class GraficaService {
	
	@Autowired
	private GraficaRepo repoGrafica;
	
	public Grafica buscarGrafica(Long id) {
		return repoGrafica.findById(id).orElse(null);
	}
	
	public List<Grafica> findAll() {
		return repoGrafica.findAll();
	}
	
	/**
	 * crea una grafica
	 * @param grafica
	 * @return
	 */
	
	public Grafica crearGrafica(Grafica grafica) {
		if (grafica.getCantidad()>=1 
				&& !"".equals(grafica.getDescripcion()) && grafica.getDescripcion()!=null
				&& !"".equals(grafica.getMarca()) && grafica.getMarca()!=null
				&& !"".equals(grafica.getModelo()) && grafica.getModelo()!=null
				&& !"".equals(grafica.getNombre()) && grafica.getNombre()!=null
				&& grafica.getPrecio()>=1) {
			Grafica newGrafica=new Grafica();
			newGrafica.setCantidad(grafica.getCantidad());
			newGrafica.setDescripcion(grafica.getDescripcion());
			newGrafica.setImagenes(grafica.getImagenes());
			newGrafica.setMarca(grafica.getMarca());
			newGrafica.setModelo(grafica.getModelo());
			newGrafica.setNombre(grafica.getNombre());
			newGrafica.setPrecio(grafica.getPrecio());		
			repoGrafica.save(newGrafica);
			return newGrafica;
		}else {
			return null;
		}
	}
	
	/**
	 * Edita una grafica, si algun dato esta vacio no lo cambia
	 * @param id
	 * @param disco
	 * @return
	 */
	
	public Grafica editGrafica(Long id,Grafica grafica) {
		Grafica graficaEdit=repoGrafica.findById(id).orElse(null);
		if (graficaEdit!=null) {
			if (!"".equals(grafica.getMarca()) && grafica.getMarca()!=null) {
				graficaEdit.setMarca(grafica.getMarca());
			}
			if (!"".equals(grafica.getModelo()) && grafica.getModelo()!=null) {
				graficaEdit.setModelo(grafica.getModelo());
			}
			if (grafica.getCantidad()>=1) {
				graficaEdit.setCantidad(grafica.getCantidad());
			}
			if (grafica.getDescripcion()!=null && !"".equals(grafica.getDescripcion())) {
				graficaEdit.setDescripcion(grafica.getDescripcion());
			}
			if (grafica.getNombre()!=null && !"".equals(grafica.getNombre())) {
				graficaEdit.setNombre(grafica.getNombre());
			}
			if (grafica.getPrecio()>=1) {
				graficaEdit.setPrecio(grafica.getPrecio());
			}
			repoGrafica.save(graficaEdit);
			
			return graficaEdit;
		}else {
			return null;
		}
	}
	
	
	
	
}
