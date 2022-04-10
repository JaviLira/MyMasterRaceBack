package com.example.demo.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.FileInfo;
import com.example.demo.repository.FileRepo;

@Service
public class FilesStorageService {

	@Autowired private FileRepo repoFile;
	
	/**
	 * MÉTODO que recibe MultipartFile objeto, lo transformar en FileDBobjeto y lo guarda en la base de datos 
	 * @param file
	 * @return objeto File
	 * @throws IOException
	 */
	public FileInfo store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    FileInfo FileDB = new FileInfo(fileName, file.getContentType(), file.getBytes());
	    return this.repoFile.save(FileDB);
	}
	
	/**
	 * MÉTODO para recuperar un objeto FileDB a través de su id
	 * @param id
	 * @return objeto FileDB
	 */
	public FileInfo getFile(String id) {
	  return this.repoFile.findById(id).get();
	}
	
	/**
	 * MÉTODO que devuelve todos los archivos almacenados en la bbdd
	 * @return lista de archivos
	 */
	public Stream<FileInfo> getAllFiles() {
	  return this.repoFile.findAll().stream();
	}
	
	/**
	 * Devuelve la imagen por el nombre que le indiques
	 * @param name
	 * @return
	 */
	public FileInfo findFileByName(String name) {
		return this.repoFile.findFileByName(name);
		
	}
	
	
	
	
	
}
