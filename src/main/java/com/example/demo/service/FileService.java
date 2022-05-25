package com.example.demo.service;




import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;



@Service("fileService")
public class FileService {
	
	private final Path root = Paths.get("carpetafotos");
	private String upload_folder=".//src//main//resources//files//";
	
	public void init() {
		try {
			Files.createDirectory(root);
		}catch (IOException e) {
			throw new RuntimeException("No se puede crear la carpeta");
		}
	}
	
	public byte[] save(MultipartFile file) throws IOException{
		byte[] nombreArchivo=null;
		if (!file.isEmpty()) {
			nombreArchivo = file.getBytes();
		}
		
		
		return nombreArchivo;
	}
	
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(root.toFile());
	}
	
	public Stream<Path> loadAll(){
		try {
			return Files.walk(root, 1).filter(path -> !path.equals(this.root))
					.map(this.root::relativize);
		}catch (RuntimeException | IOException e) {
			throw new RuntimeException("Error al cargar");
		}
		
	}
	
	public String deleteFile(String file) {
		try {
			Boolean delete = Files.deleteIfExists(root.resolve(file));
			return "Borrado";
		}catch (IOException e) {
			throw new RuntimeException("Error borrado");
		}

	}
	
	public Resource load(String file) {
		try {
			Path archivo = root.resolve(file);
			Resource resourse = new UrlResource(archivo.toUri());
			if (resourse.exists() || resourse.isReadable()) {
				return resourse;
			}else {
				throw new RuntimeException("Error de lectura");
			}
		}catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}
	
	
	
	
}
