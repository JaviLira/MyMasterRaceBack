package com.example.demo.service;

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
	
	public Pedido buscarPedido(Long id) {
		return repoPedido.findById(id).orElse(null);
	}
	
	public List<Pedido> findAll() {
		return repoPedido.findAll();
	}
	
	public List<Pedido> listaPedidosUsuario(String email) {
		User usuario= repoUsuario.findByEmail(email).orElse(null);
		if (usuario!=null) {
			return usuario.getListapedidos();
		}else {
			return null;
		}
	}
	
	public List<Pedido> listaPedidosUsuarioByName(String name) {
		User usuario= repoUsuario.findByName(name);
		if (usuario!=null) {
			return usuario.getListapedidos();
		}else {
			return null;
		}
	}
	
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
	
	public Pedido modificarPedido(Pedido pedido, String name,Long idPedido) {
		User usuario=repoUsuario.findByName(name);
		Pedido pedidoEdit=repoPedido.findById(idPedido).orElse(null);
		if (pedidoEdit==null) {
			throw new PedidoNotFoundExeption2(idPedido);
		}
		if (usuario.getListapedidos().contains(pedidoEdit)) {
			pedidoEdit.setEstado(pedido.getEstado());
			repoPedido.save(pedidoEdit);
			return pedidoEdit;
		}else {
			throw new UserNotFoundExeption(name);
		}
		
		
		
		
	}
	
}
