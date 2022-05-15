package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
			Opiniones nuevaOpinion=new Opiniones();
			nuevaOpinion.setArticulo(articuloBase);
			nuevaOpinion.setComentario(opinion.getComentario());
			nuevaOpinion.setValoracion(opinion.getValoracion());
			nuevaOpinion.setUsuario(usuario);
		
			repoOpiniones.save(nuevaOpinion);
			
			return nuevaOpinion;
		
		}else {
			return null;
		}
		

	}

	public List<Opiniones> listaDeComentariosDeUnArticulo(Long id){
		List<Opiniones> listaOpiniones=repoOpiniones.findAll();
		List<Opiniones> listaOpinionesDelArticulo=new ArrayList<Opiniones>();
		if (listaOpiniones.size()>=1) {
			for (Opiniones opinion : listaOpiniones) {
				if (opinion.getArticulo().getId()==id) {
					listaOpinionesDelArticulo.add(opinion);
				}
			}
			return listaOpinionesDelArticulo;
		}else {
			
			return null;
		}
		
	}
	
	public boolean usuarioYaComentadoArticulo(Long idArticulo,String email) {
		List<Opiniones> listaOpiniones=repoOpiniones.findAll();
		User usuario=repoUsuario.findByEmail(email).orElse(null);
		boolean respuesta=false;
		
		for (Opiniones opiniones : listaOpiniones) {
			if (Objects.equals(opiniones.getArticulo().getId(), idArticulo) && Objects.equals(opiniones.getUsuario().getEmail(), usuario.getEmail())) {
				respuesta= true;
			}
		}
		
		
		
		return respuesta;
	}
	
	
	
	
	
	
}
