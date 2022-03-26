package com.example.demo.model.componentes;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.model.AbsArticulo;

@Entity
@Table(name="ram")
public class Ram extends AbsArticulo{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String tipo; // DDR4 DDR3 ...
    private String formato; //DIMM o SO-DIMM
    private String capacidad;
    private String kit;
    
	public Ram() {
		super();
	}

	public Ram(String nombre, String imagenes, String descripcion, int cantidad, double precio, String tipo, String formato, String capacidad, String kit) {
		super(nombre, imagenes, descripcion, cantidad, precio);
		this.tipo = tipo;
		this.formato = formato;
		this.capacidad = capacidad;
		this.kit = kit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getKit() {
		return kit;
	}

	public void setKit(String kit) {
		this.kit = kit;
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
		Ram other = (Ram) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Ram [id=" + id + ", tipo=" + tipo + ", formato=" + formato + ", capacidad=" + capacidad + ", kit=" + kit
				+ ", nombre=" + nombre + ", imagenes=" + imagenes + ", descripcion=" + descripcion + ", cantidad="
				+ cantidad + ", precio=" + precio + "]";
	}

}
