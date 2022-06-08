package com.example.demo.model;

import java.util.Objects;

public class LoginCredentials {

    private String email;
    private String password;
	private Roles rol=Roles.ROLE_USER;
    
	public LoginCredentials(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginCredentials other = (LoginCredentials) obj;
		return Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "LoginCredentials [email=" + email + ", password=" + password + "]";
	}


    
    
}