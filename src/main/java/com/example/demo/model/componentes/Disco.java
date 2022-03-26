package com.example.demo.model.componentes;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.model.AbsArticulo;

@Entity
@Table(name="disco")
public class Disco extends AbsArticulo{
	
    private String tipo;
    private double capacidad;
    private String conexion; //sata3 , m.2 usb 3.0, usb c
    
	public Disco() {
		super();
	}
	
	public Disco(String nombre, String imagenes, String descripcion, int cantidad, double precio, String tipo, double capacidad, String conexion) {
		super(nombre, imagenes, descripcion, cantidad, precio);
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.conexion=conexion;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	public String getConexion() {
		return conexion;
	}

	public void setConexion(String conexion) {
		this.conexion = conexion;
	}

	@Override
	public String toString() {
		return "Disco [tipo=" + tipo + ", capacidad=" + capacidad + ", conexion=" + conexion + ", id=" + id
				+ ", nombre=" + nombre + ", imagenes=" + imagenes + ", descripcion=" + descripcion + ", cantidad="
				+ cantidad + ", precio=" + precio + "]";
	}
}
