package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.model.componentes.Disco;
import com.example.demo.model.componentes.Fuente;
import com.example.demo.model.componentes.Grafica;
import com.example.demo.model.componentes.Procesador;
import com.example.demo.model.componentes.Ram;

@Entity
@Table(name="lineapedido")
public class LineaPedido {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private int cantidad;
    @ManyToOne
    private OrdenadorVendido ordenador;
    @ManyToOne
    private Procesador procesador;
    @ManyToOne
    private Grafica grafica;
    @ManyToOne
    private Disco dicoDuro;
    @ManyToOne
    private Fuente fuente;
    @ManyToOne
    private Ram ram;
    
	public LineaPedido() {
		super();
	}
	
	public LineaPedido(int cantidad, OrdenadorVendido ordenador, Procesador procesador, Grafica grafica, Disco dicoDuro,
			Fuente fuente, Ram ram) {
		super();
		this.cantidad = cantidad;
		this.ordenador = ordenador;
		this.procesador = procesador;
		this.grafica = grafica;
		this.dicoDuro = dicoDuro;
		this.fuente = fuente;
		this.ram = ram;
	}
	
	public LineaPedido(Long id) {
		super();
		this.id = id;
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

	public OrdenadorVendido getOrdenador() {
		return ordenador;
	}

	public void setOrdenador(OrdenadorVendido ordenador) {
		this.ordenador = ordenador;
	}

	public Procesador getProcesador() {
		return procesador;
	}

	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}

	public Grafica getGrafica() {
		return grafica;
	}

	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}

	public Disco getDicoDuro() {
		return dicoDuro;
	}

	public void setDicoDuro(Disco dicoDuro) {
		this.dicoDuro = dicoDuro;
	}

	public Fuente getFuente() {
		return fuente;
	}

	public void setFuente(Fuente fuente) {
		this.fuente = fuente;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
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
		LineaPedido other = (LineaPedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "LineaPedido [id=" + id + ", cantidad=" + cantidad + ", ordenador=" + ordenador + ", procesador="
				+ procesador + ", grafica=" + grafica + ", dicoDuro=" + dicoDuro + ", fuente=" + fuente + ", ram=" + ram
				+ "]";
	}
    
	
    
	
	
}
