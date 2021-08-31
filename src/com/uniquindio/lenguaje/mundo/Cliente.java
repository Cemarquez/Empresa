package com.uniquindio.lenguaje.mundo;

public class Cliente extends Persona {

	
	public Cliente(String nombre, int cedula, int edad) {
		super(nombre, cedula, edad);
		// TODO Auto-generated constructor stub
	}

	private String email;
	


	public String getEmail() {
		return email;
	}

	public Cliente clone() {
	
		Cliente cliente = new Cliente(this.nombre, this.cedula, this.edad);
		cliente.setEmail(this.email);
		
		return cliente;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
