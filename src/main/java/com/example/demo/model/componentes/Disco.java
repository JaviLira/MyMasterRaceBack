package com.example.demo.model.componentes;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.model.AbsArticulo;

@Entity
@Table(name="disco")
public class Disco extends AbsArticulo{
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
    private String tipo;
    private String capacidad;
    
	public Disco() {
		super();
	}
	
	public Disco(String nombre, String imagenes, String descripcion, double precio, String tipo, String capacidad) {
		super(nombre, imagenes, descripcion, precio);
		this.tipo = tipo;
		this.capacidad = capacidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disco other = (Disco) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Disco [id=" + id + ", tipo=" + tipo + ", capacidad=" + capacidad + ", nombre=" + nombre + ", imagenes="
				+ imagenes + ", descripcion=" + descripcion + ", precio=" + precio + ", listapedidos=" + listapedidos
				+ "]";
	}



	
	
	
    
    

}
