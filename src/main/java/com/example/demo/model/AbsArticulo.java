package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="articulo")
public class AbsArticulo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String nombre;
	@Lob
	protected byte[] imagenes;
	protected String descripcion;
	protected Integer cantidad;
	protected double precio;
	protected boolean activo=true;
	
	public AbsArticulo() {
		super();
	}
	
	public AbsArticulo(Long id){
		super();}



	public AbsArticulo(String nombre, byte[] imagenes, String descripcion, Integer cantidad, double precio) {
		super();
		this.nombre = nombre;
		this.imagenes = imagenes;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte[] getImagenes() {
		return imagenes;
	}

	public void setImagenes(byte[] imagenes) {
		this.imagenes = imagenes;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbsArticulo other = (AbsArticulo) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "AbsArticulo [id=" + id + ", nombre=" + nombre + ", imagenes=" + imagenes + ", descripcion="
				+ descripcion + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}

}
