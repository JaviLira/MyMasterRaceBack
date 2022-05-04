package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AbsArticulo;
import com.example.demo.model.Opiniones;
import com.example.demo.model.User;
import com.example.demo.repository.ArticuloRepo;
import com.example.demo.repository.OpinionesRepo;
import com.example.demo.repository.UserRepo;

@Service("opinionesService")
public class OpinionesService {
	
	@Autowired
	private OpinionesRepo repoOpiniones;
	
	@Autowired
	private UserRepo repoUsuario;
	
	@Autowired
	private ArticuloRepo repoArticulo;
	
	public Opiniones buscarOpiniones(Long id) {
		return repoOpiniones.findById(id).orElse(null);
	}
	
	public List<Opiniones> findAll() {
		return repoOpiniones.findAll();
	}
	
	public Opiniones crearOpinion(Opiniones opinion, Long idArticulo,String email) {
		User usuario=repoUsuario.findByEmail(email).orElse(null);
		AbsArticulo articuloBase=repoArticulo.findById(idArticulo).orElse(null);
		if (usuario!=null && articuloBase!=null) {
			
		}
		
		Opiniones nuevaOpinion=new Opiniones();
		nuevaOpinion.setArticulo(articuloBase);
		nuevaOpinion.setComentario(opinion.getComentario());
		nuevaOpinion.setValoracion(opinion.getValoracion());
		
		repoOpiniones.save(nuevaOpinion);
		if (usuario.getListaOpiniones().size()<=0) {
			List<Opiniones> listaOp=new ArrayList<Opiniones>();
			listaOp.add(nuevaOpinion);
			usuario.setListaOpiniones(listaOp);
			repoUsuario.save(usuario);
		}else {
			usuario.getListaOpiniones().add(nuevaOpinion);
			repoUsuario.save(usuario);
		}
		
		return nuevaOpinion;
	}

	
	
}
