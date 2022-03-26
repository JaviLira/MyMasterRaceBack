package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="opiniones")
public class Opiniones {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String comentario;
	@JsonIgnore
	@OneToOne
	private AbsArticulo articulo;
	private int valoracion;

	public Opiniones(String comentario, AbsArticulo articulo, int valoracion) {
		super();
		this.comentario = comentario;
		this.articulo = articulo;
		this.valoracion = valoracion;
	}

	public Opiniones() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AbsArticulo getArticulo() {
		return articulo;
	}

	public void setArticulo(AbsArticulo articulo) {
		this.articulo = articulo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
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
		Opiniones other = (Opiniones) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Opiniones [id=" + id + ", comentario=" + comentario + ", articulo=" + articulo + ", valoracion="
				+ valoracion + "]";
	}
}
