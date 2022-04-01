package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.componentes.Ram;
import com.example.demo.repository.UserRepo;

@Service("usuario")
public class UsuarioService {

	@Autowired
	private UserRepo repoUsuario;
	
	@Autowired
	private PedidoService servicePedido;
	
	public User buscarUsuario(String email) {
		return repoUsuario.findByEmail(email).orElse(null);
	}
	
	public List<User> findAll() {
		return repoUsuario.findAll();
	}
	
	
}
