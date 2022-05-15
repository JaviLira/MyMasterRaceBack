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
	
	public AbsArticulo addCarrito(String email,AbsArticulo articulo) {
		User usuario=repoUsuario.findByEmail(email).orElse(null);
		AbsArticulo articuloBase=repoArticulo.findById(articulo.getId()).orElse(null);
		Long existe=(long) 0;
		
		for (Cesta cestita : usuario.getListaCesta()) {
			if (cestita.getArticulo().getId()==articuloBase.getId()) {
				existe=cestita.getId();
			}
		}
		if (existe!=0) {
			Cesta cestaInterior=repoCesta.findById(existe).orElse(null);
			int cantidad=cestaInterior.getCantidad();
			cantidad+=1;
			cestaInterior.setCantidad(cantidad);
			if (cestaInterior.getCantidad()>articuloBase.getCantidad()) {
				return null;
			}else {
			repoCesta.save(cestaInterior);
			
			return articuloBase;
			}

		}else {
			Cesta cestaNueva=new Cesta();
			cestaNueva.setArticulo(articuloBase);
			cestaNueva.setCantidad(1);
			repoCesta.save(cestaNueva);
			usuario.getListaCesta().add(cestaNueva);
			repoUsuario.save(usuario);
			return articuloBase;
		}
	}
	public List<Cesta> getCarrito(String email){
		User usuario=repoUsuario.findByEmail(email).orElse(null);
		
		if (usuario.getListaCesta().size()==0 || usuario.getListaCesta()==null) {
			return null;
		}else {
			return usuario.getListaCesta();
		}
	}
	
	public Cesta deleteCarrito(String email,Long id) {
		User usuario=repoUsuario.findByEmail(email).orElse(null);
		Cesta cestaBase=repoCesta.findById(id).orElse(null);
		
		boolean existe=false;
		
		for (Cesta cestita : usuario.getListaCesta()) {
			if (cestita.getId()==cestaBase.getId()) {
				existe=true;
			}
		}
		
		if (existe) {
			usuario.getListaCesta().remove(cestaBase);
			repoUsuario.save(usuario);
			repoCesta.deleteById(id);
			return cestaBase;
		}else {
			return null;
		}	
	}
	
	public Cesta putCesta(String email,Long id, Cesta cesta) {
		User usuario=repoUsuario.findByEmail(email).orElse(null);
		Cesta cestaBase=repoCesta.findById(id).orElse(null);
		boolean existe=false;
		
		for (Cesta cestitas : usuario.getListaCesta()) {
			if (cestitas.getId()==cestaBase.getId()) {
				existe=true;
			}
		}
		
		if (existe) {
			cestaBase.setCantidad(cesta.getCantidad());
			repoCesta.save(cestaBase);
			return cestaBase;
		}else {
			return null;
		}
	}
	
	public void vaciarCestaUsuario(String email) {
		User usuario=repoUsuario.findByEmail(email).orElse(null);
		List<Cesta> listaCesta=usuario.getListaCesta();
		if (listaCesta.size()==1) {
			deleteCarrito(email, listaCesta.get(0).getId());
		}else {
			for (int i = 0; i < listaCesta.size()+2; i++) {
				deleteCarrito(email, listaCesta.get(0).getId());
			}
		}
	}
	
	
}
