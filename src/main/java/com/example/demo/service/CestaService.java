package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AbsArticulo;
import com.example.demo.model.Cesta;
import com.example.demo.model.User;
import com.example.demo.repository.ArticuloRepo;
import com.example.demo.repository.CestaRepo;
import com.example.demo.repository.UserRepo;

@Service("cesta")
public class CestaService {

	@Autowired
	private UserRepo repoUsuario;
	
	@Autowired
	private ArticuloRepo repoArticulo;
	
	@Autowired
	private CestaRepo repoCesta;
	
	public Cesta buscarCesta(Long id) {
		return repoCesta.findById(id).orElse(null);
	}
	
	public List<Cesta> findAll() {
		return repoCesta.findAll();
	}
	
//	public AbsArticulo addCarrito(String email,AbsArticulo articulo) {
//		User usuario=buscarUsuario(email);
//		AbsArticulo articuloBase=repoArticulo.findById(articulo.getId()).orElse(null);
//		boolean existe=false;
//		
//		for (AbsArticulo articuloX : usuario.getCestaDeCompra()) {
//			if (articuloX.getId()==articuloBase.getId()) {
//				existe=true;
//			}
//		}
//		if (existe) {
//			return null;
//		}else {
//			usuario.getCestaDeCompra().add(articuloBase);
//			repoUsuario.save(usuario);
//			return articuloBase;
//		}
//	}
//	public List<AbsArticulo> getCarrito(String email){
//		User usuario=buscarUsuario(email);
//		
//		if (usuario.getCestaDeCompra().size()>=0) {
//			return null;
//		}else {
//			return usuario.getCestaDeCompra();
//		}
//	}
//	
//	public AbsArticulo deleteCarrito(String email,AbsArticulo articulo) {
//		User usuario=buscarUsuario(email);
//		AbsArticulo articuloBase=repoArticulo.findById(articulo.getId()).orElse(null);
//		
//		boolean existe=false;
//		
//		for (AbsArticulo articuloX : usuario.getCestaDeCompra()) {
//			if (articuloX.getId()==articuloBase.getId()) {
//				existe=true;
//			}
//		}
//		
//		if (existe) {
//			usuario.getCestaDeCompra().remove(articuloBase);
//			repoUsuario.save(usuario);
//			return articuloBase;
//		}else {
//			return null;
//		}
//		
//		
//	}
	
	
}
