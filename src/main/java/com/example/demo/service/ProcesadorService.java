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
	
	
}
