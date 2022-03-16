package com.example.demo.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.ApiError;
import com.example.demo.error.DiscoNotFoundExeption;
import com.example.demo.error.FuenteNotFoundExeption;
import com.example.demo.error.GraficaNotFoundExeption;
import com.example.demo.error.ListaPedidosNotFoundExeption;
import com.example.demo.error.OrdenadorIncompletoFoundExeption;
import com.example.demo.error.OrdenadorInexistenteNotFoundExeption;
import com.example.demo.error.PedidoNotFoundExeption;
import com.example.demo.error.PedidoReferenceNotFoundExeption;
import com.example.demo.error.PedidoUsuarioNotFoundExeption;
import com.example.demo.error.ProcesadorNotFoundExeption;
import com.example.demo.error.RamNotFoundExeption;
import com.example.demo.error.SocketNotFoundExeption;
import com.example.demo.error.UserNotFoundExeption;
import com.example.demo.model.Ordenador;
import com.example.demo.model.OrdenadorVendido;
import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoDTO;
import com.example.demo.model.User;
import com.example.demo.model.componentes.Disco;
import com.example.demo.model.componentes.Fuente;
import com.example.demo.model.componentes.Grafica;
import com.example.demo.model.componentes.Procesador;
import com.example.demo.model.componentes.Ram;
import com.example.demo.service.DiscoService;
import com.example.demo.service.FuenteService;
import com.example.demo.service.GraficaService;
import com.example.demo.service.OrdenadorService;
import com.example.demo.service.OrdenadorVendidoService;
import com.example.demo.service.PedidoService;
import com.example.demo.service.ProcesadorService;
import com.example.demo.service.RamService;
import com.example.demo.service.UsuarioService;


@RestController
public class UserController {
    
	@Autowired
	private OrdenadorService serviceOrdenador;
	
	@Autowired
	private OrdenadorVendidoService serviceOrdenadorvendido;
    
	@Autowired
	private DiscoService serviceDisco;
	
	@Autowired
	private FuenteService serviceFuente;
	
	@Autowired
	private ProcesadorService serviceProcesador;
	
	@Autowired
	private RamService serviceRam;
	
	@Autowired
	private GraficaService serviceGrafica;
	
	@Autowired
	private UsuarioService serviceUsuario;
	
	@Autowired
	private PedidoService servicePedido;
	
	
    
}