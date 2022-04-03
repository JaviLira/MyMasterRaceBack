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
}
