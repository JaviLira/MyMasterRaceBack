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
				String url="https://macabros554.github.io";
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
				
				registry.addMapping("/validarToken").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/{id}").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/fuente").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/procesador").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/grafica").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/disco").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/ram").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/ordenador").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/ordenador/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/ordenador/{id}/RAMsCompatibles").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/ordenador/{id}/ProcesadoresCompatibles").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/ordenador/{id}/Procesador").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/ordenador/{id}/Grafica").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/ordenador/{id}/Ram").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/ordenador/{id}/Disco").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/ordenador/{id}/Fuente").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/fuente/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/procesador/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/grafica/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/disco/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/ram/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/{id}/comentario").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/carrito").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/carrito/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/ordenadorVendido").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/ordenadorVendido/{id}").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/usuario").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/usuarios").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/pedido").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/pedido/{id}").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/pedido/{id}/lineaPedido").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/usuario/{id}").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/usuario/pedido").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/usuario/{id}/pedido").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/usuario/{id}/pedido/{idP}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/{id}/file").allowedOrigins(url)
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/mail").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
				
				registry.addMapping("/articulo/{id}").allowedOrigins(url)
				.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
		        .allowedHeaders("GET", "POST", "OPTIONS", "PUT", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		                "Access-Control-Request-Headers","Authorization")
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
			}
		};
	}
}
