package com.example.demo.model;

public class UserODT {
	
	
	private String name;
	private String calle;
	private String telefono;
	private String tarjeta;
	private String tipopago;
	private String dueniotarjeta;
	private String caducidadTarjeta;
	private String codigoseguridad;
	
	public UserODT(String name, String calle, String telefono, String tarjeta, String tipopago, String dueniotarjeta,
			String caducidadTarjeta, String codigoseguridad) {
		super();
		this.name = name;
		this.calle = calle;
		this.telefono = telefono;
		this.tarjeta = tarjeta;
		this.tipopago = tipopago;
		this.dueniotarjeta = dueniotarjeta;
		this.caducidadTarjeta = caducidadTarjeta;
		this.codigoseguridad = codigoseguridad;
	}

	public UserODT() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getTipopago() {
		return tipopago;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}

	public String getDueniotarjeta() {
		return dueniotarjeta;
	}

	public void setDueniotarjeta(String dueniotarjeta) {
		this.dueniotarjeta = dueniotarjeta;
	}

	public String getCaducidadTarjeta() {
		return caducidadTarjeta;
	}

	public void setCaducidadTarjeta(String caducidadTarjeta) {
		this.caducidadTarjeta = caducidadTarjeta;
	}

	public String getCodigoseguridad() {
		return codigoseguridad;
	}

	public void setCodigoseguridad(String codigoseguridad) {
		this.codigoseguridad = codigoseguridad;
	}

	@Override
	public String toString() {
		return "UserODT [name=" + name + ", calle=" + calle + ", telefono=" + telefono + ", tarjeta=" + tarjeta
				+ ", tipopago=" + tipopago + ", dueniotarjeta=" + dueniotarjeta + ", caducidadTarjeta="
				+ caducidadTarjeta + ", codigoseguridad=" + codigoseguridad + "]";
	}
	
	
	
	
	
}
