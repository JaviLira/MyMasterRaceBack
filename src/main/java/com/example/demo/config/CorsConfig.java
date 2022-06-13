package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				String url="https://javilira.github.io";
				//login
				registry.addMapping("/auth/login").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//comprobarEmail
				registry.addMapping("/auth/email/{email}").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//comprobar email y name
				registry.addMapping("/auth/email").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//register
				registry.addMapping("/auth/register").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//llamada para verificar que eres un administrador
				registry.addMapping("/validarRolAdministrador").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//llamada de prueba para verificar que tienes token
				registry.addMapping("/validarToken").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//llamada para mostrar todos los articulos
				registry.addMapping("/articulo").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				// llamada para mostrar un articulo
				registry.addMapping("/articulo/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar todas las fuentes
				registry.addMapping("/articulo/fuente").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar todos los procesadores
				registry.addMapping("/articulo/procesador").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar todas las graficas
				registry.addMapping("/articulo/grafica").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar todos los discos
				registry.addMapping("/articulo/disco").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar todas las rams
				registry.addMapping("/articulo/ram").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar todos los ordenadores
				registry.addMapping("/articulo/ordenador").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar, modificar y crear un ordenador
				registry.addMapping("/articulo/ordenador/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar las rams compatibles de un ordenador
				registry.addMapping("/articulo/ordenador/{id}/RAMsCompatibles").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar los procesadores compatibles de un ordenador
				registry.addMapping("/articulo/ordenador/{id}/ProcesadoresCompatibles").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar el procesador de un ordenador
				registry.addMapping("/articulo/ordenador/{id}/Procesador").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar la grafica de un ordenador
				registry.addMapping("/articulo/ordenador/{id}/Grafica").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar la ram de un ordenador
				registry.addMapping("/articulo/ordenador/{id}/Ram").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar el discode un ordenador
				registry.addMapping("/articulo/ordenador/{id}/Disco").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar la fuente de un ordenador
				registry.addMapping("/articulo/ordenador/{id}/Fuente").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar, modificar y crear una fuente
				registry.addMapping("/articulo/fuente/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar, modificar y crear un proceador
				registry.addMapping("/articulo/procesador/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar, modificar y crear una grafica
				registry.addMapping("/articulo/grafica/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar, modificar y crear un disco
				registry.addMapping("/articulo/disco/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar, modificar y crear una ram
				registry.addMapping("/articulo/ram/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar y crear un comentario
				registry.addMapping("/articulo/{id}/comentario").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar, modificar y crear un articulo en el carrito
				registry.addMapping("/carrito").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mostrar, modificar, borrar y crear articulo en el carrito
				registry.addMapping("/carrito/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//crear un ordenador vendido
				registry.addMapping("/articulo/ordenadorVendido").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//mostrar un ordenadorVendido
				registry.addMapping("/articulo/ordenadorVendido/{id}").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//mostrar, modificar, crear usuario
				registry.addMapping("/usuario").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//muestra todos los usuarios de la base de datos
				registry.addMapping("/usuarios").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Mustra todos los pedidos del usuario y crea pedidos
				registry.addMapping("/pedido").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//muestra un pedido concreto
				registry.addMapping("/pedido/{id}").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				// muestra y crea una linea de pedido del pedido
				registry.addMapping("/pedido/{id}/lineaPedido").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//mustra el usuario que le pases 
				registry.addMapping("/usuario/{id}").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				// crea o muestra todos los pedidos de un usuario
				registry.addMapping("/usuario/pedido").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				// crea o muestra todos los pedidos de un usuario
				registry.addMapping("/usuario/{id}/pedido").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//muesta el pedido que le pases del usuario que le pases
				registry.addMapping("/usuario/{id}/pedido/{idP}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//Añade una foto a un articulo
				registry.addMapping("/articulo/{id}/file").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				//envia un email
				registry.addMapping("/mail").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
			}
		};
	}
}
