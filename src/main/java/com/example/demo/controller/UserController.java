package com.example.demo.controller;


import java.time.LocalDateTime;
import java.util.List;

import javax.mail.MessagingException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.ApiError;
import com.example.demo.error.ArticuloNotFoundExeption;
import com.example.demo.error.ArticuloNullExeption;
import com.example.demo.error.ArticuloVacioExeption;
import com.example.demo.error.CantidadExeption;
import com.example.demo.error.CarritoNullExeption;
import com.example.demo.error.ComentarioExeption;
import com.example.demo.error.OrdenadorInexistenteNotFoundExeption;
import com.example.demo.error.PedidoFormatNotFoundExeption;
import com.example.demo.error.PedidoNotFoundExeption2;
import com.example.demo.error.PedidoNotFoundExeption;
import com.example.demo.error.UserNotFoundExeption;
import com.example.demo.error.UsuarioNoContieneArticulosEnElCarritoExeption;
import com.example.demo.error.UsuarioNoHaCompradoEseArticuloExeption;
import com.example.demo.error.UsuarioTieneEsePedidoExeption;
import com.example.demo.error.UsuarioYaAComentadoExeption;
import com.example.demo.model.AbsArticulo;
import com.example.demo.model.Cesta;
import com.example.demo.model.LineaPedido;
import com.example.demo.model.Mensaje;
import com.example.demo.model.Opiniones;
import com.example.demo.model.Ordenador;
import com.example.demo.model.OrdenadorVendido;
import com.example.demo.model.Pedido;
import com.example.demo.model.Roles;
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
import com.example.demo.service.LineaPedidoService;
import com.example.demo.service.OpinionesService;
import com.example.demo.service.OrdenadorService;
import com.example.demo.service.OrdenadorVendidoService;
import com.example.demo.service.PedidoService;
import com.example.demo.service.ProcesadorService;
import com.example.demo.service.RamService;
import com.example.demo.service.SmtpMailSender;
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
	private LineaPedidoService serviceLineaPedido;
	
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
	
	@Autowired
	private OpinionesService serviceOpinion;
	
	@Autowired
	private SmtpMailSender smtpMailSender;
	
	
	/**
	 * mostrar la lista de articulos completa
	 * @return
	 */
	@GetMapping("articulo")
	public ResponseEntity<List<AbsArticulo>> listaArticulos() {
    	return ResponseEntity.ok(serviceArticulo.findAll());
    }
	
	/**
	 * mostrar un articulo concreto
	 * @param id
	 * @return
	 */
	
	@GetMapping("articulo/{id}")
	public ResponseEntity<AbsArticulo> articulos(@PathVariable Long id) {
		AbsArticulo result=serviceArticulo.buscarArticulo(id);
		if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * mostrar la lista de rams completa
	 * @return
	 */
	
	@GetMapping("articulo/ram")
	public ResponseEntity<List<Ram>> listaRam() {
    	return ResponseEntity.ok(serviceRam.findAll());
    }
	
	/**
	 * crear una ram
	 * @param ram
	 * @return
	 */
	
	@PostMapping("articulo/ram")
	public ResponseEntity<Ram> postRam(@RequestBody Ram ram) {
		Ram result= serviceRam.crearRam(ram);
		if (result==null) {
			throw new ArticuloVacioExeption();
		}else {
			return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * modificar una ram
	 * @param id
	 * @param ram
	 * @return
	 */
	
	@PutMapping("articulo/ram/{id}")
	public ResponseEntity<Ram> putFuente(@PathVariable Long id,@RequestBody Ram ram) {
		Ram result= serviceRam.editRam(id,ram);
		if (result==null) {
			throw new ArticuloVacioExeption();
		}else {
			return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * lista de procesadores completa
	 * @return
	 */
	
	@GetMapping("articulo/procesador")
	public ResponseEntity<List<Procesador>> listarProcesadores() {
    	return ResponseEntity.ok(serviceProcesador.findAll());
    }
	
	/**
	 * crear un procesador
	 * @param procesador
	 * @return
	 */
	
	@PostMapping("articulo/procesador")
	public ResponseEntity<Procesador> postProcesador(@RequestBody Procesador procesador) {
		Procesador result= serviceProcesador.crearProcesador(procesador);
		if (result==null) {
			throw new ArticuloVacioExeption();
		}else {
			return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * modificar un procesador
	 * @param id
	 * @param procesador
	 * @return
	 */
	
	@PutMapping("articulo/procesador/{id}")
	public ResponseEntity<Procesador> putFuente(@PathVariable Long id,@RequestBody Procesador procesador) {
		Procesador result= serviceProcesador.editProcesador(id,procesador);
		if (result==null) {
			throw new ArticuloVacioExeption();
		}else {
			return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * lista de fuentes completa
	 * @return
	 */
	
	@GetMapping("articulo/fuente")
	public ResponseEntity<List<Fuente>> listarFuentes() {
    	return ResponseEntity.ok(serviceFuente.findAll());
    }
	
	/**
	 * crear fuente
	 * @param fuente
	 * @return
	 */
	
	@PostMapping("articulo/fuente")
	public ResponseEntity<Fuente> postFuentes(@RequestBody Fuente fuente) {
		Fuente result= serviceFuente.crearFuente(fuente);
		if (result==null) {
			throw new ArticuloVacioExeption();
		}else {
			return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * modificar una fuente
	 * @param id
	 * @param fuente
	 * @return
	 */
	
	@PutMapping("articulo/fuente/{id}")
	public ResponseEntity<Fuente> putFuente(@PathVariable Long id,@RequestBody Fuente fuente) {
		Fuente result= serviceFuente.editFuente(id,fuente);
		if (result==null) {
			throw new ArticuloVacioExeption();
		}else {
			return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * lista de graficas completa
	 * @return
	 */
	
	@GetMapping("articulo/grafica")
	public ResponseEntity<List<Grafica>> listarGraficas() {
    	return ResponseEntity.ok(serviceGrafica.findAll());
    }
	
	/**
	 * crear una grafica
	 * @param grafica
	 * @return
	 */
	
	@PostMapping("articulo/grafica")
	public ResponseEntity<Grafica> postGrafica(@RequestBody Grafica grafica) {
		Grafica result= serviceGrafica.crearGrafica(grafica);
		if (result==null) {
			throw new ArticuloVacioExeption();
		}else {
			return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * modificar una grafica
	 * @param id
	 * @param grafica
	 * @return
	 */
	
	@PutMapping("articulo/grafica/{id}")
	public ResponseEntity<Grafica> putGrafica(@PathVariable Long id,@RequestBody Grafica grafica) {
		Grafica result= serviceGrafica.editGrafica(id,grafica);
		if (result==null) {
			throw new ArticuloVacioExeption();
		}else {
			return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * lista de discos completa
	 * @return
	 */
	
	@GetMapping("articulo/disco")
	public ResponseEntity<List<Disco>> listarDiscos() {
    	return ResponseEntity.ok(serviceDisco.findAll());
    }
	
	/**
	 * crear un disco
	 * @param disco
	 * @return
	 */
	
	@PostMapping("articulo/disco")
	public ResponseEntity<Disco> postDisco(@RequestBody Disco disco) {
		Disco result= serviceDisco.crearDisco(disco);
		if (result==null) {
			throw new ArticuloVacioExeption();
		}else {
			return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * modificar un disco
	 * @param id
	 * @param disco
	 * @return
	 */
	
	@PutMapping("articulo/disco/{id}")
	public ResponseEntity<Disco> putDisco(@PathVariable Long id,@RequestBody Disco disco) {
		Disco result= serviceDisco.editDisco(id,disco);
		if (result==null) {
			throw new ArticuloVacioExeption();
		}else {
			return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * lista de ordenadores completa
	 * @return
	 */
	
	@GetMapping("articulo/ordenador")
	public ResponseEntity<List<Ordenador>> listarOrdenadores() {
    	return ResponseEntity.ok(serviceOrdenador.findAll());
    }
	
	/**
	 * crea un ordenador
	 * @param ordenador
	 * @return
	 */
	
	@PostMapping("articulo/ordenador")
	public ResponseEntity<Ordenador> crearOrdenador(@RequestBody Ordenador ordenador) {
		Ordenador result= serviceOrdenador.crearOrdenador(ordenador);
		if (result==null) {
			throw new ArticuloVacioExeption();
		}else {
			return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * modifica un ordenador
	 * @param id
	 * @param ordenador
	 * @return
	 */
	
	@PutMapping("articulo/ordenador/{id}")
	public ResponseEntity<Ordenador> putOrdenador(@PathVariable Long id,@RequestBody Ordenador ordenador) {
		Ordenador result= serviceOrdenador.editOrdenador(id,ordenador);
		if (result==null) {
			throw new ArticuloVacioExeption();
		}else {
			return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * saca un ordenador
	 * @param id
	 * @return
	 */
	
	@GetMapping("articulo/ordenador/{id}")
	public ResponseEntity<Ordenador> sacarOrdenador(@PathVariable Long id) {
		Ordenador result=serviceOrdenador.buscarOrdenador(id);
		if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(serviceOrdenador.buscarOrdenador(id));
		}
    }
	
	/**
	 * lista de rams compatibles
	 * @param id
	 * @return
	 */
	
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
	
	/**
	 * lista de procesadores compatibles
	 * @param id
	 * @return
	 */
	
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
	
	/**
	 * muestra el procesdor del ordenador
	 * @param id
	 * @return
	 */
	
	@GetMapping("articulo/ordenador/{id}/Procesador")
	public ResponseEntity<Procesador> sacarProcesadorOrdenador(@PathVariable Long id) {
		Procesador result=serviceOrdenador.sacarProcesador(id);
		if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * muestra la grafica del ordenador
	 * @param id
	 * @return
	 */
	
	@GetMapping("articulo/ordenador/{id}/Grafica")
	public ResponseEntity<Grafica> sacarGraficaOrdenador(@PathVariable Long id) {
		Grafica result=serviceOrdenador.sacarGrafica(id);
		if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * muestra la ram del ordenador
	 * @param id
	 * @return
	 */
	
	@GetMapping("articulo/ordenador/{id}/Ram")
	public ResponseEntity<Ram> sacarRamOrdenador(@PathVariable Long id) {
		Ram result=serviceOrdenador.sacarRam(id);
		if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * muestra el disco del ordenador
	 * @param id
	 * @return
	 */
	
	@GetMapping("articulo/ordenador/{id}/Disco")
	public ResponseEntity<Disco> sacarDiscoOrenador(@PathVariable Long id) {
		Disco result=serviceOrdenador.sacarDisco(id);
		if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * muestra la fuente del ordenador
	 * @param id
	 * @return
	 */
	
	@GetMapping("articulo/ordenador/{id}/Fuente")
	public ResponseEntity<Fuente> sacarFuenteOrdenador(@PathVariable Long id) {
		Fuente result=serviceOrdenador.sacarFuente(id);
		if (result==null) {
			throw new OrdenadorInexistenteNotFoundExeption(id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * muestra la ram que le pases
	 * @param id
	 * @return
	 */
	
	@GetMapping("articulo/ram/{id}")
	public ResponseEntity<Ram> sacarRam(@PathVariable Long id) {
		Ram result=serviceRam.buscarRam(id);
		if (result==null) {
			throw new ArticuloNotFoundExeption("RAM", id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * muestra el procesador que le pases
	 * @param id
	 * @return
	 */
	
	@GetMapping("articulo/procesador/{id}")
	public ResponseEntity<Procesador> sacarProcesadores(@PathVariable Long id) {
		Procesador result=serviceProcesador.buscarProcesador(id);
		if (result==null) {
			throw new ArticuloNotFoundExeption("RAM", id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * muestra la fuente que le pases
	 * @param id
	 * @return
	 */
	
	@GetMapping("articulo/fuente/{id}")
	public ResponseEntity<Fuente> sacarFuentes(@PathVariable Long id) {
		Fuente result=serviceFuente.buscarFuente(id);
		if (result==null) {
			throw new ArticuloNotFoundExeption("RAM", id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * muestra la grafica que le pases
	 * @param id
	 * @return
	 */
	
	@GetMapping("articulo/grafica/{id}")
	public ResponseEntity<Grafica> sacarGraficas(@PathVariable Long id) {
		Grafica result=serviceGrafica.buscarGrafica(id);
		if (result==null) {
			throw new ArticuloNotFoundExeption("RAM", id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * muestra el disco que le pases
	 * @param id
	 * @return
	 */
	
	@GetMapping("articulo/disco/{id}")
	public ResponseEntity<Disco> sacarDiscos(@PathVariable Long id) {
		Disco result=serviceDisco.buscarDisco(id);
		if (result==null) {
			throw new ArticuloNotFoundExeption("RAM", id);
		}else {
	    	return ResponseEntity.ok(result);
		}
    }
	
	/**
	 * añade un articulo al carrito al usuario que haga la peticion
	 * @param p
	 * @return
	 */
	
    @PostMapping("/carrito")
    public ResponseEntity<AbsArticulo> postCarrito(@RequestBody AbsArticulo p) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        
        
        if(serviceArticulo.buscarArticulo(p.getId())==null) {
        	throw new ArticuloNullExeption();
        }else {
        	if (serviceArticulo.comprobarCantidad(p.getId())) {
        		AbsArticulo result=serviceCesta.addCarrito(email, p);
        		if(result==null) {
        			throw new CantidadExeption();
        		}else {
        			return ResponseEntity.ok(result);
        		}
			}else {
				throw new CantidadExeption();
			}
        	
        }
    }
    /*
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
    */
    
    /**
     * cambia la cantidada de ese articulo en la cesta
     * @param id
     * @param cesta
     * @return
     */
    @PutMapping("/carrito/{id}")
    public ResponseEntity<Cesta> putCarritoConId(@PathVariable Long id,@RequestBody Cesta cesta) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        Cesta result=serviceCesta.putCesta(email,id,cesta);
        
        if(result==null) {
        	throw new ArticuloNullExeption();
        }else {
        	return ResponseEntity.ok(result);
        }
    }
    
    /**
     * borra el articulo de la cesta
     * @param id
     * @return
     */
    
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
    
    /**
     * saca la lista de articulos de la cesta del usuario
     * @return
     */
    
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
    
    /**
     * Crea un ordenador vendido siempre que no exista uno igual
     * @param p
     * @return
     */
    
    @PostMapping("/articulo/ordenadorVendido")
    public ResponseEntity<OrdenadorVendido> postOrdenadorVendido(@RequestBody OrdenadorVendido p) {
        OrdenadorVendido ordenadorV=serviceOrdenadorvendido.addOrdenadorVendido(p);
        if(ordenadorV==null) {
        	throw new ArticuloNullExeption();
        }else {
        	return ResponseEntity.ok(ordenadorV);
        }
    }
    
    /**
     * borra el ordenador vendido con la id que pase
     * @param id
     * @return
     */
    
    @DeleteMapping("/articulo/ordenadorVendido/{id}")
    public ResponseEntity<OrdenadorVendido> deleteOrdenadorVendido(@PathVariable Long id) {
        OrdenadorVendido ordenadorV=serviceOrdenadorvendido.deleteOrdenadorVendido(id);
        if(ordenadorV==null) {
        	throw new ArticuloNullExeption();
        }else {
        	return ResponseEntity.ok(ordenadorV);
        }
    }
    
    /**
     * crea un pedido
     * @param p
     * @return
     */
	
    @PostMapping("/pedido")
    public ResponseEntity<Pedido> postPedido(@RequestBody Pedido p) {
    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Pedido result=servicePedido.crearPedido(email,p);
    	if (serviceUsuario.usuarioTieneArticulosEnCarrito(email)) {
            if(result==null) {
            	throw new PedidoFormatNotFoundExeption();
            }else {
            	result=serviceLineaPedido.asignarLineasDePedidoA_Pedido(email, result.getId());
            	serviceCesta.vaciarCestaUsuario(email);
            	return ResponseEntity.ok(result);
            }
		}else {
			throw new UsuarioNoContieneArticulosEnElCarritoExeption(email);
		}

    }
    
    /**
     * lista los pedidos del usuario
     * @return
     */
    
    @GetMapping("/pedido")
    public ResponseEntity<List<Pedido>> getPedido() {
    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	List<Pedido> result=servicePedido.listaPedidosUsuario(email);

        if(result==null) {
        	throw new PedidoNotFoundExeption();
        }else {
        	return ResponseEntity.ok(result);
        }

    }
    
    /**
     * saca un pedido concreto
     * @param id
     * @return
     */
    
    @GetMapping("/pedido/{id}")
    public ResponseEntity<Pedido> getPedido(@PathVariable Long id) {
    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Pedido result=servicePedido.buscarPedido(id);
    	if (serviceUsuario.usuarioTienePedido(email, id)) {
			if(result==null) {
				throw new PedidoNotFoundExeption2(id);
	        }else {
	        	return ResponseEntity.ok(result);
	        }
		}else {
			throw new UsuarioTieneEsePedidoExeption(email,id);
		}
        
    }
    
    /**
     * lista las lienas de pedido de un pedido
     * @param id
     * @return
     */
    
    @GetMapping("/pedido/{id}/lineaPedido")
    public ResponseEntity <List<LineaPedido>> getLineaPedido(@PathVariable Long id) {
    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User usuario=serviceUsuario.buscarUsuario(email);
    	List<LineaPedido> result=serviceLineaPedido.lineasPedidoDelPedido(id);
    	if(result==null) {
			throw new PedidoNotFoundExeption2(id);
        }
    	
    	if (usuario.getRol()==Roles.ROLE_ADMIN) {
	        	return ResponseEntity.ok(result);
		}else {
			if (serviceUsuario.usuarioTienePedido(email, id)) {
		        	return ResponseEntity.ok(result);
			}else {
				throw new UsuarioTieneEsePedidoExeption(email,id);
			}
		}   
    }
    
    /**
     * lista los pedidos de un usuario por la id del usuario
     * @param id
     * @return
     */
    
    @GetMapping("/usuario/{id}/pedido")
    public ResponseEntity <List<Pedido>> getPedidosUsuarioId(@PathVariable String id) {
    	List<Pedido> result=servicePedido.listaPedidosUsuarioByName(id);
    	if (result==null) {
    		throw new UserNotFoundExeption(id);
		}else {
			return ResponseEntity.ok(result);
		}
    }
    
    /**
     * modifica el pedido del usuario que le pases
     * @param id
     * @param idP
     * @param pedido
     * @return
     */
    
    @PutMapping("/usuario/{id}/pedido/{idP}")
    public ResponseEntity <Pedido> putPedidosUsuarioId(@PathVariable String id,@PathVariable Long idP,@RequestBody Pedido pedido) {
    	Pedido result=servicePedido.modificarPedido(pedido,id,idP);
		return ResponseEntity.ok(result);
    }
    
    /**
     * lista los pedidos de un usuario por el token
     * @return
     */
    
    @GetMapping("/usuario/pedido")
    public ResponseEntity <List<Pedido>> getPedidosUsuario() {
    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	List<Pedido> result=serviceUsuario.buscarUsuario(email).getListapedidos();
    	if (result==null) {
    		throw new UserNotFoundExeption(email);
		}else {
			return ResponseEntity.ok(result);
		}
    }
    
    /**
     * saca al usuario por su id
     * @param id
     * @return
     */
    
    @GetMapping("/usuario/{id}")
    public ResponseEntity <User> getUsuarioId(@PathVariable String id) {
    	User result=serviceUsuario.buscarUsuario(id);
    	if (result==null) {
    		throw new UserNotFoundExeption(id);
		}else {
			return ResponseEntity.ok(serviceUsuario.buscarUsuario(id));
		}
    }
    
    /**
     * modifica el rol del usuario
     * @param id
     * @param usuario
     * @param rol
     * @return
     */
    
    @PutMapping("/usuario/{id}")
    public ResponseEntity <User> putUsuarioId(@PathVariable String id,@RequestBody User usuario,@RequestParam(required=false) String rol) {
    	User result=serviceUsuario.cambiarRol(id,rol);
    	if (result==null) {
    		throw new UserNotFoundExeption(id);
		}else {
			return ResponseEntity.ok(result);
		}
    }
    
    /**
     * saca al usuario por su token
     * @return
     */
	
	
    @GetMapping("/usuario")
    public ResponseEntity <User> getUsuario() {
    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
		return ResponseEntity.ok(serviceUsuario.buscarUsuario(email));
    }
    
    /**
     * modifica al usuario por su token
     * @param usuario
     * @return
     */
	
    @PutMapping("/usuario")
    public ResponseEntity <User> putUsuario(@RequestBody User usuario) {
    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User result=serviceUsuario.modificarUsuario(email, usuario);
    	
    	if (result==null) {
    		throw new UserNotFoundExeption(email);
		}else {
			return ResponseEntity.ok(serviceUsuario.buscarUsuario(email));
		}
    }
    
    /**
     * añade un comentario al articulo
     * @param id
     * @param opinion
     * @return
     */
	
    @PostMapping("/articulo/{id}/comentario")
    public ResponseEntity <Opiniones> postComentario(@PathVariable Long id,@RequestBody Opiniones opinion) {
    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
    	if (serviceUsuario.usuarioTieneArticuloComprado(email, id)) {
			if (!serviceOpinion.usuarioYaComentadoArticulo(id, email)) {
				Opiniones result=serviceOpinion.crearOpinion(opinion,id,email);
	    	
		    	if (result==null) {
		    		throw new ComentarioExeption();
				}else {
					return ResponseEntity.ok(result);
				}
			}else {
				throw new UsuarioYaAComentadoExeption();
			}
		}else {
			throw new UsuarioNoHaCompradoEseArticuloExeption();
		}
    }
    
    /**
     * saca los comentarios del articulo
     * @param id
     * @return
     */
    
    @GetMapping("/articulo/{id}/comentario")
    public ResponseEntity <List<Opiniones>> GetComentariosDeUnArticulo(@PathVariable Long id) {
    	List<Opiniones> result=serviceOpinion.listaDeComentariosDeUnArticulo(id);
    	
    	if (result==null) {
    		throw new ComentarioExeption();
		}else {
			return ResponseEntity.ok(result);
		}
    }
    
    /**
     * envia un email al administrador
     * @param datos
     * @throws MessagingException
     */
	
	@PostMapping("/mail")
	public void sendEmail(@RequestBody Mensaje datos) throws MessagingException {
		datos.setToUser("hermanosliratest@gmail.com");

		smtpMailSender.send(datos.getToUser(), datos.getSubject(), datos.getText(), datos.getFromUser());
	}
	
	/**
	 * Muestra todos los usuarios en la base de datos
	 * @param id
	 * @return
	 */
	
    @GetMapping("/usuarios")
    public ResponseEntity <List<User>> getUsuarios() {
    	List<User> result=serviceUsuario.findAll();
		return ResponseEntity.ok(result);
		
    }
    
    /**
     * cambia el estado de un articulo
     * @param id
     * @param estado
     * @param articulo
     * @return
     */
    
    @PutMapping("/articulo/{id}")
    public ResponseEntity<AbsArticulo> putArticulo(@PathVariable Long id,@RequestParam(required=false) String estado,@RequestBody AbsArticulo articulo) {
    	return ResponseEntity.ok(serviceArticulo.descartivarArticulo(id, estado));
    } 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
    
    
    
	/**
	 * Esta excepcion solo se deberia de ver cuando se le introduce campos vacios al ordenador
     * @param ex
     * @return
     * @throws Exception
	 */
    
    
    @ExceptionHandler(ArticuloVacioExeption.class)
    public ResponseEntity<ApiError> ArticuloVacioExeption(ArticuloVacioExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	}
    
	/**
	 * No quedan mas unidades de este producto
     * @param ex
     * @return
     * @throws Exception
	 */
   
    @ExceptionHandler(CantidadExeption.class)
    public ResponseEntity<ApiError> CantidadExeption(CantidadExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	}
    
	/**
	 * No puede comentar porque no ha comprado el articulo
     * @param ex
     * @return
     * @throws Exception
	 */
    
    @ExceptionHandler(UsuarioNoHaCompradoEseArticuloExeption.class)
    public ResponseEntity<ApiError> UsuarioNoHaCompradoEseArticuloExeption(UsuarioNoHaCompradoEseArticuloExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	}
    
	/**
	 * No puede comentar porque ya ha comentado ese articulo
     * @param ex
     * @return
     * @throws Exception
	 */
    
    @ExceptionHandler(UsuarioYaAComentadoExeption.class)
    public ResponseEntity<ApiError> UsuarioYaAComentadoExeption(UsuarioYaAComentadoExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	}
    
    /**
     * error con el comentario
     * @param ex
     * @return
     * @throws Exception
     */
    
    @ExceptionHandler(ComentarioExeption.class)
    public ResponseEntity<ApiError> ComentarioExeption(ComentarioExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
	/**
	 * Esta excepcion solo se deberia de ver cuando intentas sacar los pedidos del usuario pero aun no tiene
     * @param ex
     * @return
     * @throws Exception
	 */
    
    @ExceptionHandler(PedidoNotFoundExeption.class)
    public ResponseEntity<ApiError> PedidoNotFoundExeption(PedidoNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
	/**
	 * Esta excepcion solo se deberia de ver cuando el usuario que estas buscando no existe
     * @param ex
     * @return
     * @throws Exception
	 */
    
    @ExceptionHandler(UserNotFoundExeption.class)
    public ResponseEntity<ApiError> UserNotFoundExeption(UserNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
	/**
	 * el carrito del usuario esta vacio
     * @param ex
     * @return
     * @throws Exception
	 */
    
    @ExceptionHandler(UsuarioNoContieneArticulosEnElCarritoExeption.class)
    public ResponseEntity<ApiError> UsuarioNoContieneArticulosEnElCarritoExeption(UsuarioNoContieneArticulosEnElCarritoExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.LOCKED);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.LOCKED).body(e);
	}
    
	/**
	 * El usuario no tiene un peido con esa id
     * @param ex
     * @return
     * @throws Exception
	 */
    
    @ExceptionHandler(UsuarioTieneEsePedidoExeption.class)
    public ResponseEntity<ApiError> UsuarioNoContieneEsePedido(UsuarioTieneEsePedidoExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	}
    
	/**
	 * Esta excepcion solo se deberia de ver cuando intentas sacar un pedido que no existe
     * @param ex
     * @return
     * @throws Exception
	 */
	
    @ExceptionHandler(PedidoNotFoundExeption2.class)
    public ResponseEntity<ApiError> PedidoNotFoundExeption(PedidoNotFoundExeption2 ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	}
    
	/**
	 * Error con algun valor del pedido
     * @param ex
     * @return
     * @throws Exception
	 */
	
    @ExceptionHandler(PedidoFormatNotFoundExeption.class)
    public ResponseEntity<ApiError> PedidoFormatExeption(PedidoFormatNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	}
    
	/**
	 * El carrito no tiene articulos
     * @param ex
     * @return
     * @throws Exception
	 */
	
    @ExceptionHandler(CarritoNullExeption.class)
    public ResponseEntity<ApiError> CarritoNullExeption(CarritoNullExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
	/**
	 * El articulo es nulo o no esta completo
     * @param ex
     * @return
     * @throws Exception
	 */
	
    @ExceptionHandler(ArticuloNullExeption.class)
    public ResponseEntity<ApiError> ArticuloNullExeption(ArticuloNullExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
	/**
	 * Esta excepcion solo se deberia de ver cuando intentas buscar un ordenador que no existe
     * @param ex
     * @return
     * @throws Exception
	 */
	
    @ExceptionHandler(OrdenadorInexistenteNotFoundExeption.class)
    public ResponseEntity<ApiError> OrdenadorError(OrdenadorInexistenteNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
    
	/**
	 * No se puede encontrar el articulo con esa id
     * @param ex
     * @return
     * @throws Exception
	 */
    
    @ExceptionHandler(ArticuloNotFoundExeption.class)
    public ResponseEntity<ApiError> articuloError(ArticuloNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
}