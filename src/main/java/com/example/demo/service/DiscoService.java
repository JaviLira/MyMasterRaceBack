package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Disco;
import com.example.demo.repository.DiscoRepo;

@Service("discoService")
public class DiscoService {
	
	@Autowired
	private DiscoRepo repoDisco;
	
	public Disco buscarDisco(Long id) {
		return repoDisco.findById(id).orElse(null);
	}
	
	public List<Disco> findAll() {
		return repoDisco.findAll();
	}
	
	public Disco crearDisco(Disco disco) {
		if (disco.getCapacidad()>=1 && disco.getConexion()!=null && !"".equals(disco.getConexion())
				&& disco.getDescripcion()!=null && !"".equals(disco.getDescripcion())
				&& disco.getNombre()!=null && !"".equals(disco.getNombre())
				&& disco.getPrecio()>=1 && disco.getCantidad()>=1
				&& disco.getTipo()!=null && !"".equals(disco.getTipo())) {
			Disco newDisco=new Disco();
			newDisco.setCantidad(disco.getCantidad());
			newDisco.setCapacidad(disco.getCapacidad());
			newDisco.setConexion(disco.getConexion());
			newDisco.setDescripcion(disco.getDescripcion());
			newDisco.setImagenes(disco.getImagenes());
			newDisco.setNombre(disco.getNombre());
			newDisco.setPrecio(disco.getPrecio());
			newDisco.setTipo(disco.getTipo());
			repoDisco.save(newDisco);
			
			return newDisco;
		}else {
			return null;
		}
	}
	
	public Disco editDisco(Long id,Disco disco) {
		Disco discoEdit=repoDisco.findById(id).orElse(null);
		if (discoEdit!=null) {
			if (disco.getCapacidad()>=1 ) {
				discoEdit.setCapacidad(disco.getCapacidad());
			}
			if (disco.getConexion()!=null && !"".equals(disco.getConexion())) {
				discoEdit.setConexion(disco.getConexion());
			}
			if (disco.getCantidad()>=1) {
				discoEdit.setCantidad(disco.getCantidad());
			}
			if (disco.getDescripcion()!=null && !"".equals(disco.getDescripcion())) {
				discoEdit.setDescripcion(disco.getDescripcion());
			}
			if (disco.getNombre()!=null && !"".equals(disco.getNombre())) {
				discoEdit.setNombre(disco.getNombre());
			}
			if (disco.getPrecio()>=1) {
				discoEdit.setTipo(disco.getTipo());
			}
			if (disco.getTipo()!=null && !"".equals(disco.getTipo())) {
				discoEdit.setTipo(disco.getTipo());
			}
//			if(disco.getImagenes()!=null) {
//				discoEdit.setImagenes(disco.getImagenes());
//			}
			repoDisco.save(discoEdit);
			
			return discoEdit;
		}else {
			return null;
		}
		
		
	}
	
	

}
