package com.example.demo.model.componentes;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.model.AbsArticulo;

@Entity
@Table(name="fuente")
public class Fuente extends AbsArticulo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String certificacion;
	private String potencia;
	
	public Fuente() {
		super();
	}

	public Fuente(String nombre, String imagenes, String descripcion, int cantidad, double precio,Long id, String certificacion, String potencia) {
		super(nombre, imagenes, descripcion, cantidad, precio);
		this.id = id;
		this.certificacion = certificacion;
		this.potencia = potencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCertificacion() {
		return certificacion;
	}

	public void setCertificacion(String certificacion) {
		this.certificacion = certificacion;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
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
		Fuente other = (Fuente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Fuente [id=" + id + ", certificacion=" + certificacion + ", potencia=" + potencia + ", nombre=" + nombre
				+ ", imagenes=" + imagenes + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio="
				+ precio + "]";
	}

	
	

	


	
	
}
