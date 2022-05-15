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
	
	
}
