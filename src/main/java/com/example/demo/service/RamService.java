package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Ram;
import com.example.demo.repository.RamRepo;

@Service("ramService")
public class RamService {
	
	@Autowired
	private RamRepo repoRam;
	
	public List<Ram> findAll() {
		return repoRam.findAll();
	}
	
	public Ram buscarRam(Long id) {
		return repoRam.findById(id).orElse(null);
	}
	
	public List<Ram> listarRamsCompatibles(Long id){
		Ram referencia=buscarRam(id);
		List<Ram> listaRams=new ArrayList<>();
		for (Ram ram : repoRam.findAll()) {
			if (referencia.getTipo().equals(ram.getTipo()) && referencia.getFormato().equals(ram.getFormato())) {
				listaRams.add(ram);
			}
		}
		return listaRams;
	}

}
