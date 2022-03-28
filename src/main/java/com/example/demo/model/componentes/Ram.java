package com.example.demo.model.componentes;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.model.AbsArticulo;

@Entity
@Table(name="ram")
public class Ram extends AbsArticulo{
	
    private String tipo; // DDR4 DDR3 ...
    private String formato; //DIMM o SO-DIMM
    private int capacidad;
    private String kit;
    
	public Ram() {
		super();
	}

	public Ram(String nombre, String imagenes, String descripcion, int cantidad, double precio, String tipo, String formato, int capacidad, String kit) {
		super(nombre, imagenes, descripcion, cantidad, precio);
		this.tipo = tipo;
		this.formato = formato;
		this.capacidad = capacidad;
		this.kit = kit;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getKit() {
		return kit;
	}

	public void setKit(String kit) {
		this.kit = kit;
	}

	@Override
	public String toString() {
		return "Ram [id=" + id + ", tipo=" + tipo + ", formato=" + formato + ", capacidad=" + capacidad + ", kit=" + kit
				+ ", nombre=" + nombre + ", imagenes=" + imagenes + ", descripcion=" + descripcion + ", cantidad="
				+ cantidad + ", precio=" + precio + "]";
	}

}
