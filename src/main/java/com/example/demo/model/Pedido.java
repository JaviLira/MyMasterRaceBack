package com.example.demo.model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private boolean entregado;
	private boolean enCamino;
	@ManyToOne
	@JsonBackReference
	private User usuario;
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

	public Pedido(String direccion, String telefono, String tipopado, String codigotarjeta,
			String tarjeta, String dueniotarjeta) {
		super();
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipopago = tipopado;
		this.codigotarjeta = codigotarjeta;
		this.tarjeta = tarjeta;
		this.dueniotarjeta = dueniotarjeta;
		this.enCamino=false;
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

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
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
				+ direccion + ", telefono=" + telefono + ", tipopago="
				+ tipopago + ", codigotarjeta=" + codigotarjeta + ", tarjeta=" + tarjeta + ", dueniotarjeta="
				+ dueniotarjeta + ", entregado=" + entregado + ", enCamino=" + enCamino + ", usuario=" + usuario
				+ ", id=" + id + ", listaLineaPedido=" + listaLineaPedido + "]";
	}
	
	
	

	
	
    
    
}
