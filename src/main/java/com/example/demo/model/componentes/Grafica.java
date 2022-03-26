package com.example.demo.model.componentes;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.model.AbsArticulo;

@Entity
@Table(name="grafica")
public class Grafica extends AbsArticulo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		Grafica other = (Grafica) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Grafica [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", nombre=" + nombre + ", imagenes="
				+ imagenes + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}

	

	

	
	
	
	
	
}
