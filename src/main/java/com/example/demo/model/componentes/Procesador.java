package com.example.demo.model.componentes;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.model.AbsArticulo;

@Entity
@Table(name="procesador")
public class Procesador extends AbsArticulo{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
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
		Procesador other = (Procesador) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Procesador [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", socket=" + socket + ", nombre="
				+ nombre + ", imagenes=" + imagenes + ", descripcion=" + descripcion + ", cantidad=" + cantidad
				+ ", precio=" + precio + "]";
	}
	
	

	

}
