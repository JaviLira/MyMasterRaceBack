package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="articulo")
public abstract class AbsArticulo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String nombre;
	protected String imagenes;
	protected String descripcion;
	protected double precio;
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)
	protected List<Opiniones> listapedidos=new ArrayList<>();
	
	public AbsArticulo() {
		super();
	}
	
	public AbsArticulo(Long id){
		super();}

	public AbsArticulo(String nombre, String imagenes, String descripcion, double precio) {
		super();
		this.nombre = nombre;
		this.imagenes = imagenes;
		this.descripcion = descripcion;
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

	public String getImagenes() {
		return imagenes;
	}

	public void setImagenes(String imagenes) {
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

	public List<Opiniones> getListapedidos() {
		return listapedidos;
	}

	public void setListapedidos(List<Opiniones> listapedidos) {
		this.listapedidos = listapedidos;
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
				+ descripcion + ", precio=" + precio + ", listapedidos=" + listapedidos + "]";
	}
	
	
	
	
	
	

}
