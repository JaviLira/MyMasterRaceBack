package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.error.ArticuloNotFoundExeption;
import com.example.demo.model.AbsArticulo;
import com.example.demo.model.FileMessage;
import com.example.demo.service.ArticuloService;
import com.example.demo.service.FileService;

@RestController
public class FileController {
	
	@Autowired
	FileService servicioFile;
	
	@Autowired
	ArticuloService servicioArticulo;
	
	/**
	 * añade un imagen a un articulo
	 * @param file
	 * @param id
	 * @return
	 */

	@PostMapping("articulo/{id}/file")
	public ResponseEntity<FileMessage> postProcesador(@RequestBody MultipartFile file,@PathVariable Long id) {
		try {
			byte[] imagen=servicioFile.save(file);
			AbsArticulo articulo= servicioArticulo.buscarArticulo(id);
			if (articulo!=null) {
				articulo.setImagenes(imagen);
				servicioArticulo.actualizarArticulo(id, articulo);
				return ResponseEntity.status(HttpStatus.OK).body(new FileMessage("Subido a la perfeccion"));
			}else {
				throw new ArticuloNotFoundExeption("", id);
			}
			
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileMessage("Error al subir imagen"));
		}
    }
}
