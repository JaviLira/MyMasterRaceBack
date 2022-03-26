package com.example.demo.model.componentes;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.model.AbsArticulo;

@Entity
@Table(name="procesador")
public class Procesador extends AbsArticulo{
	
    private String marca;
    private String modelo;
    private String socket;
    
	public Procesador() {
		super();
	}

	public Procesador(String nombre, String imagenes, String descripcion, int cantidad, double precio ,String marca, String modelo, String socket) {
		super(nombre, imagenes, descripcion, cantidad, precio);
		this.marca = marca;
		this.modelo = modelo;
		this.socket = socket;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	@Override
	public String toString() {
		return "Procesador [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", socket=" + socket + ", nombre="
				+ nombre + ", imagenes=" + imagenes + ", descripcion=" + descripcion + ", cantidad=" + cantidad
				+ ", precio=" + precio + "]";
	}
	
	

	

}
