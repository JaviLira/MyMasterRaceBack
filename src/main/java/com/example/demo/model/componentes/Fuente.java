package com.example.demo.model.componentes;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.model.AbsArticulo;

@Entity
@Table(name="fuente")
public class Fuente extends AbsArticulo{

	private String certificacion;
	private int potencia;
	
	public Fuente() {
		super();
	}

	public Fuente(String nombre, byte[] imagenes, String descripcion, int cantidad, double precio, String certificacion, int potencia) {
		super(nombre, imagenes, descripcion, cantidad, precio);
		this.certificacion = certificacion;
		this.potencia = potencia;
	}

	public String getCertificacion() {
		return certificacion;
	}

	public void setCertificacion(String certificacion) {
		this.certificacion = certificacion;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return "Fuente [id=" + id + ", certificacion=" + certificacion + ", potencia=" + potencia + ", nombre=" + nombre
				+ ", imagenes=" + imagenes + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio="
				+ precio + "]";
	}

	
	

	


	
	
}
