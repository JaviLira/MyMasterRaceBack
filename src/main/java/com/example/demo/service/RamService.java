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
	

}
