package com.example.demo.controller;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.ApiError;
import com.example.demo.error.ContrasenaNotFoundExeption;
import com.example.demo.error.ExisteUsuarioNotFoundExeption;
import com.example.demo.error.RolAdministradorExeption;
import com.example.demo.error.TokenNoValidoExeption;
import com.example.demo.error.UserNotFoundExeption;
import com.example.demo.model.LoginCredentials;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.security.JWTUtil;
import com.example.demo.service.UsuarioService;

@RestController
@CrossOrigin("http://localhost:4200")
public class AuthController {

    @Autowired private UserRepo userRepo;
    @Autowired private JWTUtil jwtUtil;
    @Autowired private AuthenticationManager authManager;
    @Autowired private PasswordEncoder passwordEncoder;
	@Autowired private UsuarioService serviceUsuario;
	
	
	/**
	 * registra al usuario y si el email no deja registrarse
	 * @param user
	 * @return
	 */

    @PostMapping("/auth/register")
    public Map<String, Object> registerHandler(@RequestBody User user){
    	if (userRepo.findByEmail(user.getEmail()).orElse(null)==null) {
            String encodedPass = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPass);
            user = userRepo.save(user);
            String token = jwtUtil.generateToken(user.getEmail(),user.getRol().toString());
            return Collections.singletonMap("access_token", token);
		}else {
			throw new ExisteUsuarioNotFoundExeption();
		}
    }
    
    /**
     * logea al usuario y le genera un token que contiene su email
     * @param body
     * @return
     */

    @PostMapping("/auth/login")
    public Map<String, Object> loginHandler(@RequestBody LoginCredentials body){
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());

            authManager.authenticate(authInputToken);
 
            String token = jwtUtil.generateToken(body.getEmail(),body.getRol().toString());

            return Collections.singletonMap("access_token", token);
        }catch (AuthenticationException authExc){
        		throw new ContrasenaNotFoundExeption();
        }
    }
    
    /**
     * validar que tiene token
     * @return
     */
  @GetMapping("/validarToken")
    public ResponseEntity<User> validarToken() {
    	try {
    		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            
    		return ResponseEntity.ok(serviceUsuario.buscarUsuario(email));
    	}catch (Exception e) {
			throw new TokenNoValidoExeption();
		}
    }
  
  /**
   * validar que tiene token y es administrador
   * @return
   */
  
  @GetMapping("/validarRolAdministrador")
  public ResponseEntity<User> validarRolAdministrador() {
  	try {
  		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  		User result=serviceUsuario.comprobarRolAdministrador(email);
		return ResponseEntity.ok(result);
		
  	}catch (Exception e) {
			throw new TokenNoValidoExeption();
		}
  }
  
  /**
   * debuelve el usuario por el email
   * @return
   */
    
    @GetMapping("/auth/email/{email}")
    public ResponseEntity<User> comprobarEmail(@PathVariable String email) {
    	User respuesta = serviceUsuario.buscarUsuario(email);
    	
    	if (respuesta!=null) {
			return ResponseEntity.ok(respuesta);
		}else {
			throw new UserNotFoundExeption(email);
		}
    	
    }
    
    /**
     * validar que el email y el username no estan en uso
     * @return
     */
    
    @GetMapping("/auth/email")
    public User comprobarEmail(
    		@RequestParam(required = false) String email,
			@RequestParam(required = false) String username) {
    			
		if (username == null) {
			return serviceUsuario.buscarUsuario(email);
		} else {
			return serviceUsuario.buscarUsuarioByName(username);
		}
    	
    }
    
    
    
    
    
    /**
     * salta si el rol no es administrador
     * @param ex
     * @return
     * @throws Exception
     */
    
    @ExceptionHandler(RolAdministradorExeption.class)
    public ResponseEntity<ApiError> RolAdministradorExeption(RolAdministradorExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	} 
    
    /**
     * 
	 * Esta excepcion solo se deberia de ver cuando el usuario que quiere registrarse usa un email que ya esta usando 
	 * otro usuario en la base de datos
	 *
     * @param ex
     * @return
     * @throws Exception
     */
    
    @ExceptionHandler(ExisteUsuarioNotFoundExeption.class)
    public ResponseEntity<ApiError> registrarError(ExisteUsuarioNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	} 
    
	/**
	 * Esta excepcion solo se deberia de ver cuando el usuario que estas buscando no existe
	 */
    
    @ExceptionHandler(UserNotFoundExeption.class)
    public ResponseEntity<ApiError> usuarioNoEncontrado(UserNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	} 
    
	/**
	 * Esta excepcion solo se deberia de ver cuando la contraseña del usuario no es valida
	 */
    
    @ExceptionHandler(ContrasenaNotFoundExeption.class)
    public ResponseEntity<ApiError> contrasenaError(ContrasenaNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	} 
    
	/**
	 * Esta excepcion solo se deberia de ver cuando el token no es valido
	 */
    
    @ExceptionHandler(TokenNoValidoExeption.class)
    public ResponseEntity<ApiError> tokenNoValido(TokenNoValidoExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	} 
    


}
