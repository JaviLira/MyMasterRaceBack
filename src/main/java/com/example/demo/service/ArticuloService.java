package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.error.ArticuloIdNotFoundExeption;
import com.example.demo.error.EstadoExeption;
import com.example.demo.model.AbsArticulo;
import com.example.demo.repository.ArticuloRepo;

@Service("articuloService")
public class ArticuloService {
	
	@Autowired
	private ArticuloRepo repoArticulo;
	
	/**
	 * saca todos los articulos
	 * @return
	 */
	
	public List<AbsArticulo> findAll() {
		return repoArticulo.findAll();
	}
	
	/**
	 * saca el articulo que le pases
	 * @param id
	 * @return
	 */
	
	public AbsArticulo buscarArticulo(Long id) {
		return repoArticulo.findById(id).orElse(null);
	}
	
	/**
	 * comprueba si la cantidad de un articulo es mayor a 1
	 * @param id
	 * @return
	 */
	
	public boolean comprobarCantidad(Long id) {
		boolean result=false;
		AbsArticulo articulo=repoArticulo.findById(id).orElse(null);
		if (articulo.getCantidad()>=1) {
			result=true;
		}
		return result;
	}
	
	/**
	 * actualiza el articulo que le pases si existe
	 * @param id
	 * @param articulo
	 * @return
	 */
	
	public AbsArticulo actualizarArticulo(Long id, AbsArticulo articulo) {
		
		if (repoArticulo.findById(id).orElse(null)!=null) {
			return repoArticulo.save(articulo);
		}else {
			return null;
		}
	}
	
	/**
	 * desactiva un articulo
	 * @param id
	 * @param estado
	 * @return
	 */
	
	public AbsArticulo descartivarArticulo(Long id,String estado) {
		AbsArticulo articulo = repoArticulo.findById(id).orElse(null);
		if (articulo!=null && ("true".equals(estado) || "false".equals(estado))) {
			if ("true".equals(estado)) {
				articulo.setActivo(true);
			}else if("false".equals(estado)) {
				articulo.setActivo(false);
			}
			repoArticulo.save(articulo);
			return articulo;
		}
		if (articulo==null) {
			throw new ArticuloIdNotFoundExeption(id);
		}
		
		if (!"true".equals(estado) && !"false".equals(estado)) {
			throw new EstadoExeption();
		}
		return null;
	}
}
