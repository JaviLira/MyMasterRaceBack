package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.model.componentes.Disco;
import com.example.demo.model.componentes.Fuente;
import com.example.demo.model.componentes.Grafica;
import com.example.demo.model.componentes.Procesador;
import com.example.demo.model.componentes.Ram;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ordenador")
public class Ordenador extends AbsArticulo{

	@ManyToOne
	private Ram ram;
	@ManyToOne
	private Procesador procesador;
	@ManyToOne
	private Disco discoduro;
	@ManyToOne
	private Grafica grafica;
	@ManyToOne
	private Fuente fuente;
	
	public Ordenador() {
		super();
	}

	public Ordenador(String nombre,Ram ram, Procesador procesador, Disco discoduro, Grafica grafica, Fuente fuente, String imagenes, String descripcion, int cantidad, double precio) {
		super(nombre, imagenes, descripcion, cantidad, precio);
		this.ram = ram;
		this.procesador = procesador;
		this.discoduro = discoduro;
		this.grafica = grafica;
		this.fuente = fuente;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public Procesador getProcesador() {
		return procesador;
	}

	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}

	public Disco getDiscoduro() {
		return discoduro;
	}

	public void setDiscoduro(Disco discoduro) {
		this.discoduro = discoduro;
	}

	public Grafica getGrafica() {
		return grafica;
	}

	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}

	public Fuente getFuente() {
		return fuente;
	}

	public void setFuente(Fuente fuente) {
		this.fuente = fuente;
	}

	@Override
	public String toString() {
		return "Ordenador [ram=" + ram + ", procesador=" + procesador + ", discoduro=" + discoduro + ", grafica="
				+ grafica + ", fuente=" + fuente + ", id=" + id + ", nombre=" + nombre + ", imagenes=" + imagenes
				+ ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}	

	
	




}
