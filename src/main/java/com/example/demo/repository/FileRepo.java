package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FileInfo;

@Repository
public interface FileRepo extends JpaRepository<FileInfo, String>{

	/**
	 * Encontrar fichero por nombre
	 * @param name
	 * @return fichero con nombre buscado
	 */
	@Query(value="select * from files where name = ?1", nativeQuery = true) 
	public FileInfo findFileByName(String name);
	
}
