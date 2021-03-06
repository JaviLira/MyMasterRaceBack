package com.example.demo.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.error.PedidoNotFoundExeption2;
import com.example.demo.error.UserNotFoundExeption;
import com.example.demo.model.Pedido;
import com.example.demo.model.User;
import com.example.demo.repository.PedidoRepo;
import com.example.demo.repository.UserRepo;

@Service("pedido")
public class PedidoService {

	@Autowired
	private PedidoRepo repoPedido;
	
	@Autowired
	private UserRepo repoUsuario;
	
	/**
	 * busca el pedido que quieras
	 * @param id
	 * @return
	 */
	
	public Pedido buscarPedido(Long id) {
		return repoPedido.findById(id).orElse(null);
	}
	
	/**
	 * saca todos los pedidos
	 * @return
	 */
	
	public List<Pedido> findAll() {
		return repoPedido.findAll();
	}
	
	/**
	 * lista todos los pedidos de un usuario
	 * @param email
	 * @return
	 */
	
	public List<Pedido> listaPedidosUsuario(String email) {
		User usuario= repoUsuario.findByEmail(email).orElse(null);
		if (usuario!=null) {
			return usuario.getListapedidos();
		}else {
			return null;
		}
	}
	
	/**
	 * lista pedidos del usuario por el nombre del usuario
	 * @param name
	 * @return
	 */
	
	public List<Pedido> listaPedidosUsuarioByName(String name) {
		User usuario= repoUsuario.findByName(name);
		if (usuario!=null) {
			return usuario.getListapedidos();
		}else {
			return null;
		}
	}
	
	/**
	 * Crea un pedido en el usuario
	 * @param email
	 * @param pedido
	 * @return
	 */
	
	public Pedido crearPedido(String email,Pedido pedido) {
		if(comprobarPedido(pedido)) {
			User usuario=repoUsuario.findByEmail(email).orElse(null);
			if(usuario!=null) {
				Pedido pedidoNuevo= new Pedido();
				repoPedido.save(pedidoNuevo);
				
				pedidoNuevo.setCaducidadTarjeta(pedido.getCaducidadTarjeta());
				pedidoNuevo.setDireccion(pedido.getDireccion());
				pedidoNuevo.setCodigotarjeta(pedido.getCodigotarjeta());
				pedidoNuevo.setTarjeta(pedido.getTarjeta());
				pedidoNuevo.setDueniotarjeta(pedido.getDueniotarjeta());
				pedidoNuevo.setTelefono(pedido.getTelefono());
				pedidoNuevo.setTipopago(pedido.getTipopago());
				
				usuario.getListapedidos().add(pedidoNuevo);
				repoPedido.save(pedidoNuevo);
				repoUsuario.save(usuario);
				
				
				return pedidoNuevo;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	/**
	 * Comprueba que todos los valores del pedido tiene datos
	 * @param p1
	 * @return
	 */

	public boolean comprobarPedido(Pedido p1) {
		if(		p1.getDireccion()==null || 
				p1.getTelefono()==null || 
				p1.getCodigotarjeta()==null || 
				p1.getTarjeta()==null || 
				p1.getDueniotarjeta()==null || 
				p1.getTipopago() ==null || 
				p1.getCaducidadTarjeta() ==null || 
				p1.getDireccion().equals("") || p1.getCaducidadTarjeta().equals("") ||
				p1.getCodigotarjeta().equals("") || p1.getTarjeta().equals("") || 
				p1.getTelefono().equals("") || p1.getTipopago().equals("")
				|| p1.getDueniotarjeta().equals("")
				)	{
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * Modifica el pedido del usuario
	 * @param pedido
	 * @param name
	 * @param idPedido
	 * @return
	 */
	
	public Pedido modificarPedido(Pedido pedido, String name,Long idPedido) {
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
	    LocalDate localDate = LocalDate.now();
	    Date date=Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		
		User usuario=repoUsuario.findByName(name);
		Pedido pedidoEdit=repoPedido.findById(idPedido).orElse(null);
		if (pedidoEdit==null) {
			throw new PedidoNotFoundExeption2(idPedido);
		}
		if (usuario.getListapedidos().contains(pedidoEdit)) {
			pedidoEdit.setEstado(pedido.getEstado());
			
			if ("Entregado".equals(pedido.getEstado())) {
				pedidoEdit.setFechaPackEntrega(date);
			}
			
			repoPedido.save(pedidoEdit);
			return pedidoEdit;
		}else {
			throw new UserNotFoundExeption(name);
		}
		
		
		
		
	}
	
}
