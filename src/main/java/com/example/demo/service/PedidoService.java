package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepo;
import com.example.demo.repository.UserRepo;

@Service("pedido")
public class PedidoService {

	@Autowired
	private PedidoRepo repoPedido;
	
	@Autowired
	private UserRepo repoUsuario;
	
	@Autowired
	private OrdenadorVendidoService serviceOrdenadorVendido;
	
	public Pedido buscarPedido(Long id) {
		return repoPedido.findById(id).orElse(null);
	}
	
	public List<Pedido> findAll() {
		return repoPedido.findAll();
	}

	
}
