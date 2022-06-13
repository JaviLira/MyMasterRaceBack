package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AbsArticulo;
import com.example.demo.model.Cesta;
import com.example.demo.model.LineaPedido;
import com.example.demo.model.Pedido;
import com.example.demo.model.User;
import com.example.demo.repository.ArticuloRepo;
import com.example.demo.repository.LineaPedidoRepo;
import com.example.demo.repository.PedidoRepo;
import com.example.demo.repository.UserRepo;

@Service("lineaPedido")
public class LineaPedidoService {

	@Autowired
	private PedidoRepo repoPedido;
	
	@Autowired
	private UserRepo repoUsuario;
	
	@Autowired
	private LineaPedidoRepo repoLienaPedido;
	
	@Autowired
	private ArticuloRepo repoArticulo;
	
	/**
	 * saca la linaPedido que le pidas
	 * @param id
	 * @return
	 */
	
	public LineaPedido buscarLineaPedido(Long id) {
		return repoLienaPedido.findById(id).orElse(null);
	}
	
	/**
	 * saca todas las lineasdePedido
	 * @return
	 */
	
	public List<LineaPedido> findAll() {
		return repoLienaPedido.findAll();
	}
	
	/**
	 * añade una linea de pedido a un pedido
	 * @param email
	 * @param idPedido
	 * @return
	 */
	
	public Pedido asignarLineasDePedidoA_Pedido(String email,Long idPedido){
		User usuario=repoUsuario.findByEmail(email).orElse(null);
		Pedido pedido=repoPedido.findById(idPedido).orElse(null);
		List<LineaPedido> listaLIneaPedido=new ArrayList<>();
		
		for (Cesta cesta : usuario.getListaCesta()) {
			LineaPedido linea =new LineaPedido();
			repoLienaPedido.save(linea);
			linea.setArticulo(cesta.getArticulo());
			linea.setCantidad(cesta.getCantidad());
			repoLienaPedido.save(linea);
			listaLIneaPedido.add(linea);
			
			AbsArticulo articulo=cesta.getArticulo();
			articulo.setCantidad(articulo.getCantidad()-cesta.getCantidad());
			repoArticulo.save(articulo);
		}
		pedido.setListaLineaPedido(listaLIneaPedido);
		repoPedido.save(pedido);
		
		return pedido;
	}
	
	/**
	 * saca las lineas de pedido de un pedido
	 * @param idPedido
	 * @return
	 */
	
	public List<LineaPedido> lineasPedidoDelPedido(Long idPedido){
		Pedido pedido=repoPedido.findById(idPedido).orElse(null);
		if (pedido==null) {
			return null;
		}else {
			return pedido.getListaLineaPedido();
		}
		
		
	}


	
}
