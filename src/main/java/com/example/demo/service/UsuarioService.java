package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LineaPedido;
import com.example.demo.model.Pedido;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service("usuario")
public class UsuarioService {

	@Autowired
	private UserRepo repoUsuario;
	
	/**
	 * busca un usuario por id
	 * @param email
	 * @return
	 */
	
	public User buscarUsuario(String email) {
		return repoUsuario.findByEmail(email).orElse(null);
	}
	
	/**
	 * busca al usuario por nombre
	 * @param name
	 * @return
	 */
	
	public User buscarUsuarioByName(String name) {
		return repoUsuario.findByName(name);
	}
	
	/**
	 * comprueba que el rol del usuario es administrador
	 * @param email
	 * @return
	 */
	
	public User comprobarRolAdministrador(String email) {
		User result = repoUsuario.findByEmail(email).orElse(null);
		if ("ADMIN".equals(result.getRol())) {
			return result;
		} else {
			return null;
		}
	}
	
	/**
	 * listar todos los usuarios
	 * @return
	 */
	
	public List<User> findAll() {
		return repoUsuario.findAll();
	}
	
	/**
	 * modifica el usuario
	 * @param email
	 * @param usuario
	 * @return
	 */
	
	public User modificarUsuario(String email, User usuario) {
		User modificado=repoUsuario.findById(email).orElse(null);
		if (Objects.equals(modificado.getEmail(), email)) {
			
			if (!"".equals(usuario.getCalle()) && usuario.getCalle()!=null) {
				modificado.setCalle(usuario.getCalle());
			}
			if (!"".equals(usuario.getCaducidadTarjeta()) && usuario.getCaducidadTarjeta()!=null) {
				modificado.setCaducidadTarjeta(usuario.getCaducidadTarjeta());
			}
			if (!"".equals(usuario.getCodigotarjeta()) && usuario.getCodigotarjeta()!=null) {
				modificado.setCodigotarjeta(usuario.getCodigotarjeta());
			}
			if (!"".equals(usuario.getDueniotarjeta()) && usuario.getDueniotarjeta()!=null) {
				modificado.setDueniotarjeta(usuario.getDueniotarjeta());
			}
			if (!"".equals(usuario.getName()) && usuario.getName()!=null) {
				modificado.setName(usuario.getName());
			}
			if (!"".equals(usuario.getTarjeta()) && usuario.getTarjeta()!=null) {
				modificado.setTarjeta(usuario.getTarjeta());
			}
			if (!"".equals(usuario.getTelefono()) && usuario.getTelefono()!=null) {
				modificado.setTelefono(usuario.getTelefono());
			}
			if (!"".equals(usuario.getTipopago()) && usuario.getTipopago()!=null) {
				modificado.setTipopago(usuario.getTipopago());
			}
			repoUsuario.save(modificado);
			return modificado;

		}else {
			return null;
		}
		
		
		
		
	}
	
	
	
	
	

	
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
	
	/**
	 * comfirma si el usuario a comprado un articulo
	 * @param email
	 * @param idArticulo
	 * @return
	 */
	
	public boolean usuarioTieneArticuloComprado(String email,Long idArticulo) {
		boolean respuesta = false;
		User usuario=repoUsuario.findByEmail(email).orElse(null);
		for (Pedido pedido : usuario.getListapedidos()) {
			for (LineaPedido linea : pedido.getListaLineaPedido()) {
				if (Objects.equals(linea.getArticulo().getId(), idArticulo)) {
					respuesta=true;
				}
			}
			
		}
		
		return respuesta;
	}
	
	
}
