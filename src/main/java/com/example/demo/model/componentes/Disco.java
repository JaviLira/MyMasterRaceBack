package com.example.demo.model.componentes;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.model.AbsArticulo;

@Entity
@Table(name="disco")
public class Disco extends AbsArticulo{
	
    private String tipo;
    private String capacidad;
    
	public Disco() {
		super();
	}
	
	public Disco(Long id) {
		super();
	}
	
	public Disco(String nombre, String imagenes, String descripcion, int cantidad, double precio, String tipo, String capacidad) {
		super(nombre, imagenes, descripcion, cantidad, precio);
		this.tipo = tipo;
		this.capacidad = capacidad;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Disco [id=" + id + ", tipo=" + tipo + ", capacidad=" + capacidad + ", nombre=" + nombre + ", imagenes="
				+ imagenes + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}





	
	
	
    
    

}
