package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lineapedido")
public class LineaPedido {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private int cantidad;
    @ManyToOne
    private AbsArticulo articulo;

    
	public LineaPedido() {
		super();
	}
	
	public LineaPedido(int cantidad, AbsArticulo articulo) {
		super();
		this.cantidad = cantidad;
		this.articulo = articulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public AbsArticulo getArticulo() {
		return articulo;
	}

	public void setArticulo(AbsArticulo articulo) {
		this.articulo = articulo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaPedido other = (LineaPedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "LineaPedido [id=" + id + ", cantidad=" + cantidad + ", articulo=" + articulo + "]";
	}
	
}
