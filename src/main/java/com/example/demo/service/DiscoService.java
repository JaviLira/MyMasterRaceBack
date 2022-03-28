package com.example.demo.service;

import java.util.ArrayList;
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

}
