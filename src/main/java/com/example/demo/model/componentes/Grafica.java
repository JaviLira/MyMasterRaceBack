package com.example.demo.model.componentes;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.model.AbsArticulo;

@Entity
@Table(name="grafica")
public class Grafica extends AbsArticulo{

    private String marca;
    private String modelo;
    
	public Grafica() {
		super();
	}

	public Grafica(String nombre, String imagenes, String descripcion, int cantidad, double precio,String marca, String modelo) {
		super(nombre, imagenes, descripcion, cantidad, precio);
		this.marca = marca;
		this.modelo = modelo;
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

	@Override
	public String toString() {
		return "Grafica [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", nombre=" + nombre + ", imagenes="
				+ imagenes + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}
	
}
