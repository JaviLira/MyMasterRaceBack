package com.example.demo.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@CreationTimestamp
	private Date fechaPackInicio;
	private Date fechaPackEntrega;
	private String direccion;
	private String telefono;
	private String tipopago;
	private String codigotarjeta;
	private String tarjeta;
	private String dueniotarjeta;
	private String caducidadTarjeta;
	private String estado="En almacen";
	private boolean entregado;
	private boolean enCamino;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @JsonBackReference
	@OneToMany
    private List<LineaPedido> listaLineaPedido;
    
	public Pedido(Long id) {
		super();
		this.id = id;
	}

	public Pedido(String direccion, String telefono, String tipopago, String codigotarjeta, String tarjeta,
			String dueniotarjeta, String caducidadTarjeta) {
		super();
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipopago = tipopago;
		this.codigotarjeta = codigotarjeta;
		this.tarjeta = tarjeta;
		this.dueniotarjeta = dueniotarjeta;
		this.caducidadTarjeta = caducidadTarjeta;
	}

	public Pedido() {
		super();
	}

	public Date getFechaPackInicio() {
		return fechaPackInicio;
	}

	public void setFechaPackInicio(Date fechaPackInicio) {
		this.fechaPackInicio = fechaPackInicio;
	}

	public Date getFechaPackEntrega() {
		return fechaPackEntrega;
	}

	public void setFechaPackEntrega(Date fechaPackEntrega) {
		this.fechaPackEntrega = fechaPackEntrega;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipopago() {
		return tipopago;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}

	public String getCodigotarjeta() {
		return codigotarjeta;
	}

	public void setCodigotarjeta(String codigotarjeta) {
		this.codigotarjeta = codigotarjeta;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getDueniotarjeta() {
		return dueniotarjeta;
	}

	public void setDueniotarjeta(String dueniotarjeta) {
		this.dueniotarjeta = dueniotarjeta;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	public boolean isEnCamino() {
		return enCamino;
	}

	public void setEnCamino(boolean enCamino) {
		this.enCamino = enCamino;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<LineaPedido> getListaLineaPedido() {
		return listaLineaPedido;
	}

	public void setListaLineaPedido(List<LineaPedido> listaLineaPedido) {
		this.listaLineaPedido = listaLineaPedido;
	}

	public String getCaducidadTarjeta() {
		return caducidadTarjeta;
	}

	public void setCaducidadTarjeta(String caducidadTarjeta) {
		this.caducidadTarjeta = caducidadTarjeta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pedido [fechaPackInicio=" + fechaPackInicio + ", fechaPackEntrega=" + fechaPackEntrega + ", direccion="
				+ direccion + ", telefono=" + telefono + ", tipopago=" + tipopago + ", codigotarjeta=" + codigotarjeta
				+ ", tarjeta=" + tarjeta + ", dueniotarjeta=" + dueniotarjeta + ", caducidadTarjeta=" + caducidadTarjeta
				+ ", entregado=" + entregado + ", enCamino=" + enCamino + ", id=" + id + ", listaLineaPedido="
				+ listaLineaPedido + "]";
	}


	
	
	

	
	
    
    
}
