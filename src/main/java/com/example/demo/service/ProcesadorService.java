package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.componentes.Procesador;
import com.example.demo.repository.ProcesadorRepo;

@Service("procesadorService")
public class ProcesadorService {
	
	@Autowired
	private ProcesadorRepo repoProcesador;
	
	public Procesador buscarProcesador(Long id) {
		return repoProcesador.findById(id).orElse(null);
	}
	
	public List<Procesador> findAll(){
		return repoProcesador.findAll();
	}
	
	public List<Procesador> listarProcesadoresCompatibles(Long id){
		Procesador referencia=buscarProcesador(id);
		List<Procesador> listaProcesadores=new ArrayList<>();
		for (Procesador procesador : repoProcesador.findAll()) {
			if (referencia.getSocket().equals(procesador.getSocket())) {
				listaProcesadores.add(procesador);
			}
		}
		return listaProcesadores;
	}
	
	
}
