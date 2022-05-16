package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AbsArticulo;
import com.example.demo.repository.ArticuloRepo;

@Service("articuloService")
public class ArticuloService {
	
	@Autowired
	private ArticuloRepo repoArticulo;
	
	public List<AbsArticulo> findAll() {
		return repoArticulo.findAll();
	}
	
	public AbsArticulo buscarArticulo(Long id) {
		return repoArticulo.findById(id).orElse(null);
	}
	
	public boolean comprobarCantidad(Long id) {
		boolean result=false;
		AbsArticulo articulo=repoArticulo.findById(id).orElse(null);
		if (articulo.getCantidad()>=1) {
			result=true;
		}
		return result;
	}
	
	public AbsArticulo actualizarArticulo(Long id, AbsArticulo articulo) {
		
		if (repoArticulo.findById(id).orElse(null)!=null) {
			return repoArticulo.save(articulo);
		}else {
			return null;
		}
	}
}
