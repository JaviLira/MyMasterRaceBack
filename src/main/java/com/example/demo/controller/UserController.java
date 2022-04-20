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
import com.example.demo.error.ArticuloNotFoundExeption;
import com.example.demo.error.ArticuloNullExeption;
import com.example.demo.error.CarritoNullExeption;
import com.example.demo.error.OrdenadorInexistenteNotFoundExeption;
import com.example.demo.model.AbsArticulo;
import com.example.demo.model.Cesta;
import com.example.demo.model.Ordenador;
import com.example.demo.model.OrdenadorVendido;
import com.example.demo.model.Pedido;
import com.example.demo.model.User;
import com.example.demo.model.componentes.Disco;
import com.example.demo.model.componentes.Fuente;
import com.example.demo.model.componentes.Grafica;
import com.example.demo.model.componentes.Procesador;
import com.example.demo.model.componentes.Ram;
import com.example.demo.service.ArticuloService;
import com.example.demo.service.CestaService;
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
	
	@Autowired
	private CestaService serviceCesta;
	
	@Autowired
	private ArticuloService serviceArticulo;
	
	@GetMapping("articulo")
	public ResponseEntity<List<AbsArticulo>> listaArticulos() {
    	return ResponseEntity.ok(serviceArticulo.findAll());
    }
	
	@GetMapping("articulo/{id}")
	public ResponseEntity<AbsArticulo> articulos(@PathVariable Long id) {
		AbsArticulo result=serviceArticulo.buscarArticulo(id);
		if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	@GetMapping("articulo/ram")
	public ResponseEntity<List<Ram>> listaRam() {
    	return ResponseEntity.ok(serviceRam.findAll());
    }
	
	@GetMapping("articulo/procesador")
	public ResponseEntity<List<Procesador>> listarProcesadores() {
    	return ResponseEntity.ok(serviceProcesador.findAll());
    }
	
	@GetMapping("articulo/fuente")
	public ResponseEntity<List<Fuente>> listarFuentes() {
    	return ResponseEntity.ok(serviceFuente.findAll());
    }
	
	@GetMapping("articulo/grafica")
	public ResponseEntity<List<Grafica>> listarGraficas() {
    	return ResponseEntity.ok(serviceGrafica.findAll());
    }
	
	@GetMapping("articulo/disco")
	public ResponseEntity<List<Disco>> listarDiscos() {
    	return ResponseEntity.ok(serviceDisco.findAll());
    }
	
	@GetMapping("articulo/ordenador")
	public ResponseEntity<List<Ordenador>> listarOrdenadores() {
    	return ResponseEntity.ok(serviceOrdenador.findAll());
    }
	
	@GetMapping("articulo/ordenador/{id}")
	public ResponseEntity<Ordenador> sacarOrdenador(@PathVariable Long id) {
		Ordenador result=serviceOrdenador.buscarOrdenador(id);
		if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(serviceOrdenador.buscarOrdenador(id));
		}
    }
	
	@GetMapping("articulo/ordenador/{id}/RAMsCompatibles")
	public ResponseEntity<List<Ram>> sacarRamsCompatibles(@PathVariable Long id) {
		Ordenador ordenador=serviceOrdenador.buscarOrdenador(id);
		if (ordenador==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
			List<Ram> listaRams=serviceRam.listarRamsCompatibles(ordenador.getRam().getId());
			if(listaRams==null) {
				throw new OrdenadorInexistenteNotFoundExeption(id);
			}else {
		    	return ResponseEntity.ok(listaRams);
			}
		}
    }
	
	@GetMapping("articulo/ordenador/{id}/ProcesadoresCompatibles")
	public ResponseEntity<List<Procesador>> sacarProcesadoresCompatibles(@PathVariable Long id) {
		Ordenador ordenador=serviceOrdenador.buscarOrdenador(id);
		if (ordenador==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
			List<Procesador> listaProcesadors=serviceProcesador.listarProcesadoresCompatibles(ordenador.getProcesador().getId());
			if(listaProcesadors==null) {
				throw new OrdenadorInexistenteNotFoundExeption(id);
			}else {
		    	return ResponseEntity.ok(listaProcesadors);
			}
		}
    }
	
	@GetMapping("articulo/ordenador/{id}/Procesador")
	public ResponseEntity<Procesador> sacarProcesadorOrdenador(@PathVariable Long id) {
		Procesador result=serviceOrdenador.sacarProcesador(id);
		if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	@GetMapping("articulo/ordenador/{id}/Grafica")
	public ResponseEntity<Grafica> sacarGraficaOrdenador(@PathVariable Long id) {
		Grafica result=serviceOrdenador.sacarGrafica(id);
		if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	@GetMapping("articulo/ordenador/{id}/Ram")
	public ResponseEntity<Ram> sacarRamOrdenador(@PathVariable Long id) {
		Ram result=serviceOrdenador.sacarRam(id);
		if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	@GetMapping("articulo/ordenador/{id}/Disco")
	public ResponseEntity<Disco> sacarDiscoOrenador(@PathVariable Long id) {
		Disco result=serviceOrdenador.sacarDisco(id);
		if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	@GetMapping("articulo/ordenador/{id}/Fuente")
	public ResponseEntity<Fuente> sacarFuenteOrdenador(@PathVariable Long id) {
		Fuente result=serviceOrdenador.sacarFuente(id);
		if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	@GetMapping("articulo/ram/{id}")
	public ResponseEntity<Ram> sacarRam(@PathVariable Long id) {
		Ram result=serviceRam.buscarRam(id);
		if (result==null) {
			throw new ArticuloNotFoundExeption("RAM", id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	@GetMapping("articulo/procesador/{id}")
	public ResponseEntity<Procesador> sacarProcesadores(@PathVariable Long id) {
		Procesador result=serviceProcesador.buscarProcesador(id);
		if (result==null) {
			throw new ArticuloNotFoundExeption("RAM", id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	@GetMapping("articulo/fuente/{id}")
	public ResponseEntity<Fuente> sacarFuentes(@PathVariable Long id) {
		Fuente result=serviceFuente.buscarFuente(id);
		if (result==null) {
			throw new ArticuloNotFoundExeption("RAM", id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	@GetMapping("articulo/grafica/{id}")
	public ResponseEntity<Grafica> sacarGraficas(@PathVariable Long id) {
		Grafica result=serviceGrafica.buscarGrafica(id);
		if (result==null) {
			throw new ArticuloNotFoundExeption("RAM", id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	@GetMapping("articulo/disco/{id}")
	public ResponseEntity<Disco> sacarDiscos(@PathVariable Long id) {
		Disco result=serviceDisco.buscarDisco(id);
		if (result==null) {
			throw new ArticuloNotFoundExeption("RAM", id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
    @PostMapping("/carrito")
    public ResponseEntity<AbsArticulo> postCarrito(@RequestBody AbsArticulo p) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        
        
        if(serviceArticulo.buscarArticulo(p.getId())==null) {
        	throw new ArticuloNullExeption();
        }else {
        	return ResponseEntity.ok(serviceCesta.addCarrito(email, p));
        }
    }
    
    //hacer
    @PutMapping("/carrito")
    public ResponseEntity<AbsArticulo> putCarrito(@RequestBody AbsArticulo p) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        
        
        if(serviceArticulo.buscarArticulo(p.getId())==null) {
        	throw new ArticuloNullExeption();
        }else {
        	return ResponseEntity.ok(serviceCesta.addCarrito(email, p));
        }
    }
    
    @DeleteMapping("/carrito/{id}")
    public ResponseEntity<Cesta> deleteCarrito(@PathVariable Long id) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        Cesta result=serviceCesta.deleteCarrito(email, id);
        
        if(result==null) {
        	throw new ArticuloNullExeption();
        }else {
        	return ResponseEntity.ok(result);
        }
    }
    
    @GetMapping("/carrito")
    public ResponseEntity <List<Cesta>> getCarrito() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        List<Cesta> result=serviceCesta.getCarrito(email);
        
        if(result==null) {
        	throw new CarritoNullExeption();
        }else {
        	return ResponseEntity.ok(result);
        }
    }
    
    @PostMapping("/articulo/ordenadorVendido")
    public ResponseEntity<OrdenadorVendido> postOrdenadorVendido(@RequestBody OrdenadorVendido p) {
        OrdenadorVendido ordenadorV=serviceOrdenadorvendido.addOrdenadorVendido(p);
        if(ordenadorV==null) {
        	throw new ArticuloNullExeption();
        }else {
        	return ResponseEntity.ok(ordenadorV);
        }
    }
    
    @DeleteMapping("/articulo/ordenadorVendido/{id}")
    public ResponseEntity<OrdenadorVendido> deleteOrdenadorVendido(@PathVariable Long id) {
        OrdenadorVendido ordenadorV=serviceOrdenadorvendido.deleteOrdenadorVendido(id);
        if(ordenadorV==null) {
        	throw new ArticuloNullExeption();
        }else {
        	return ResponseEntity.ok(ordenadorV);
        }
    }
	
    @PostMapping("/pedido")
    public ResponseEntity<Pedido> realizarPedido(@RequestBody Pedido p) {
    	Pedido pedido=new Pedido();
        if(pedido==null) {
        	throw new ArticuloNullExeption();
        }else {
        	return ResponseEntity.ok(pedido);
        }
    }
	
    @GetMapping("/usuario")
    public ResponseEntity <User> getUsuario() {
    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
		return ResponseEntity.ok(serviceUsuario.buscarUsuario(email));
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	
    @ExceptionHandler(CarritoNullExeption.class)
    public ResponseEntity<ApiError> CarritoNullExeption(CarritoNullExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
	
    @ExceptionHandler(ArticuloNullExeption.class)
    public ResponseEntity<ApiError> ArticuloNullExeption(ArticuloNullExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
	
    @ExceptionHandler(OrdenadorInexistenteNotFoundExeption.class)
    public ResponseEntity<ApiError> OrdenadorError(OrdenadorInexistenteNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
    @ExceptionHandler(ArticuloNotFoundExeption.class)
    public ResponseEntity<ApiError> articuloError(ArticuloNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
}