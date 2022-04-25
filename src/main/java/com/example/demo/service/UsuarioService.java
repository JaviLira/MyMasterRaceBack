package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AbsArticulo;
import com.example.demo.model.Cesta;
import com.example.demo.model.Pedido;
import com.example.demo.model.User;
import com.example.demo.repository.ArticuloRepo;
import com.example.demo.repository.UserRepo;

@Service("usuario")
public class UsuarioService {

	@Autowired
	private UserRepo repoUsuario;
	
	@Autowired
	private ArticuloRepo repoArticulo;
	
	@Autowired
	private PedidoService servicePedido;
	
	public User buscarUsuario(String email) {
		return repoUsuario.findByEmail(email).orElse(null);
	}
	
	public List<User> findAll() {
		return repoUsuario.findAll();
	}
	
//	public AbsArticulo addCarrito(String email,AbsArticulo articulo) {
//		User usuario=buscarUsuario(email);
//		AbsArticulo articuloBase=repoArticulo.findById(articulo.getId()).orElse(null);
//		boolean existe=false;
//		
//		for (AbsArticulo articuloX : usuario.getCestaDeCompra()) {
//			if (articuloX.getId()==articuloBase.getId()) {
//				existe=true;
//			}
//		}
//		if (existe) {
//			return null;
//		}else {
//			usuario.getCestaDeCompra().add(articuloBase);
//			repoUsuario.save(usuario);
//			return articuloBase;
//		}
//	}
//	public List<Cesta> getCarrito(String email){
//		User usuario=buscarUsuario(email);
//		
//		if (usuario.getCestaUsuario().size()>=0) {
//			return null;
//		}else {
//			return usuario.getCestaUsuario();
//		}
//	}
//	
//	public AbsArticulo deleteCarrito(String email,AbsArticulo articulo) {
//		User usuario=buscarUsuario(email);
//		AbsArticulo articuloBase=repoArticulo.findById(articulo.getId()).orElse(null);
//		
//		boolean existe=false;
//		
//		for (AbsArticulo articuloX : usuario.getCestaDeCompra()) {
//			if (articuloX.getId()==articuloBase.getId()) {
//				existe=true;
//			}
//		}
//		
//		if (existe) {
//			usuario.getCestaDeCompra().remove(articuloBase);
//			repoUsuario.save(usuario);
//			return articuloBase;
//		}else {
//			return null;
//		}
//		
//		
//	}
	
	/**
	 * Comprueba si el usuario tiene ese pedido en concreto para no darle un pedido de otro usuario
	 * @param email
	 * @param id
	 * @return
	 */
	
	public boolean usuarioTienePedido(String email,Long id) {
		User usuario= buscarUsuario(email);
		boolean respuesta = false;
		for (Pedido pedido : usuario.getListapedidos()) {
			if (pedido.getId()==id) {
				respuesta=true;
			}
		}
		return respuesta;
	}
	
	/**
	 * comprueba que el usuario tiene productos en el carrito para poder realizar la compra
	 * @param email
	 * @param id
	 * @return
	 */
	
	public boolean usuarioTieneArticulosEnCarrito(String email) {
		User usuario= buscarUsuario(email);
		boolean respuesta = false;
		if (usuario.getListaCesta().size()>=1) {
			respuesta=true;
		}
		return respuesta;
	}
	
	
}
