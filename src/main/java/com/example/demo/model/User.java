package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class User {

	
	private String name;
	@Id
	private String email;
	private String calle;
	private String telefono;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private Roles rol=Roles.ROLE_USER;
	private String tipopago;
	private String codigotarjeta;
	private String tarjeta;
	private String dueniotarjeta;
	private String caducidadTarjeta;
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)
	private List<Pedido> listapedidos=new ArrayList<>();
	@OneToMany 
	private List <Cesta> listaCesta= new ArrayList<>();

	
	public User() {
		super();
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public User(String name, String email, String calle, String telefono, String password) {
		super();
		this.name = name;
		this.email = email;
		this.calle = calle;
		this.telefono = telefono;
		this.password = password;
	}
	
	public User(String name, String email, String calle, String telefono, String password, String tipopado,
			String codigotarjeta, String tarjeta, String dueniotarjeta, String caducidadTarjeta) {
		super();
		this.name = name;
		this.email = email;
		this.calle = calle;
		this.telefono = telefono;
		this.password = password;
		this.tipopago = tipopado;
		this.codigotarjeta = codigotarjeta;
		this.tarjeta = tarjeta;
		this.dueniotarjeta = dueniotarjeta;
		this.caducidadTarjeta = caducidadTarjeta;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipopago() {
		return tipopago;
	}

	public void setTipopago(String tipopado) {
		this.tipopago = tipopado;
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

	public List<Pedido> getListapedidos() {
		return listapedidos;
	}

	public void setListapedidos(List<Pedido> listapedidos) {
		this.listapedidos = listapedidos;
	}

	public String getCaducidadTarjeta() {
		return caducidadTarjeta;
	}

	public void setCaducidadTarjeta(String caducidadTarjeta) {
		this.caducidadTarjeta = caducidadTarjeta;
	}

	public List<Cesta> getListaCesta() {
		return listaCesta;
	}

	public void setListaCesta(List<Cesta> listaCesta) {
		this.listaCesta = listaCesta;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", calle=" + calle + ", telefono=" + telefono + ", password="
				+ password + ", tipopago=" + tipopago + ", codigotarjeta=" + codigotarjeta + ", tarjeta=" + tarjeta
				+ ", dueniotarjeta=" + dueniotarjeta + ", caducidadTarjeta=" + caducidadTarjeta + ", listapedidos=" + listapedidos + "]";
	}


}
