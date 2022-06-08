package com.example.demo.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private JWTFilter filter;
    @Autowired private MyUserDetailsService uds;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic().disable()
                .cors()
                .and()
                .authorizeHttpRequests()
                .antMatchers("/mail").hasAnyRole("USER","ADMIN","EMPLOYEE")
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/validarToken").hasAnyRole("USER","ADMIN","EMPLOYEE")
                .antMatchers("/pedido").hasAnyRole("USER","ADMIN","EMPLOYEE")
                .antMatchers("/pedido/**").hasAnyRole("USER","ADMIN","EMPLOYEE")
                .antMatchers("/pedido/**/lineaPedido").hasAnyRole("USER","ADMIN","EMPLOYEE")
                .antMatchers("/pedido").hasAnyRole("USER","ADMIN","EMPLOYEE")
                .antMatchers("/carrito").hasAnyRole("USER","ADMIN","EMPLOYEE")
                .antMatchers("/carrito/**").hasAnyRole("USER","ADMIN","EMPLOYEE")
                .antMatchers("/articulo/**/file").hasAnyRole("USER","ADMIN","EMPLOYEE")
                .antMatchers("/articulo").permitAll()
                .antMatchers("/articulo/**").permitAll()
                .antMatchers("/articulo/**/**").permitAll()
                .antMatchers("/articulo/**/**/**").permitAll()
                .antMatchers("/usuario").hasAnyRole("USER","ADMIN","EMPLOYEE")
                .antMatchers("/usuarios").hasAnyRole("ADMIN","EMPLOYEE")
                .antMatchers("/usuario/{id}/pedido/{idP}").hasAnyRole("ADMIN","EMPLOYEE")
                .antMatchers("/usuario/pedido").hasAnyRole("USER","ADMIN","EMPLOYEE")
                .antMatchers("/usuario/**/pedido").hasAnyRole("USER","ADMIN","EMPLOYEE")
                .antMatchers("/usuario/**/pedido/**").hasAnyRole("USER","ADMIN","EMPLOYEE")
                .antMatchers("/usuario/**").hasAnyRole("USER","ADMIN","EMPLOYEE")
                .antMatchers("/validarRolAdministrador").hasAnyRole("ADMIN","EMPLOYEE")
                .antMatchers("/articulo/{id}").hasRole("ADMIN")
                .and()
                .userDetailsService(uds)
                .exceptionHandling()
                    .authenticationEntryPoint(
                            (request, response, authException) ->
                                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
                    )
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //                .antMatchers(HttpMethod.GET, "/api/v1/initiatives/{idI}").permitAll() 

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}