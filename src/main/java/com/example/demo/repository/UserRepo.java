package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepo extends JpaRepository<User, String> {
   
	/**
	 * Método para obtener un usuario por su email
	 * @param email
	 * @return
	 */
	public Optional<User> findByEmail(String email);
	@Query(value="select email from usuario where email = ?1", nativeQuery = true) 
	public Object getEmail(String email);
	/**
	 * busca al usuario por nombre
	 * @param name
	 * @return
	 */
	@Query(value="select * from usuario where name = ?1", nativeQuery = true) 
	public User findByName(String name);
}
