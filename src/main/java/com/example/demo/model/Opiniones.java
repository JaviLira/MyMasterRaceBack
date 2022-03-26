package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="opiniones")
public class Opiniones {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private User usuario;
	private String comentario;
	private int valoracion;

	public Opiniones(User usuario, String comentario, int valoracion) {
		super();
		this.usuario = usuario;
		this.comentario = comentario;
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

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
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
		return "Opiniones [id=" + id + ", usuario=" + usuario + ", comentario=" + comentario + ", valoracion="
				+ valoracion + "]";
	}


	
	
	
	
	

}
