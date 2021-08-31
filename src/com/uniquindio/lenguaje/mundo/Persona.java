package com.uniquindio.lenguaje.mundo;

public class Persona {

	protected String nombre;
	protected int cedula;
	protected int edad;
	
	
	
	public Persona(String nombre, int cedula, int edad) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public boolean equals(Persona emp) {
		boolean is=false;
		if(emp.getCedula()==cedula) {
			is=true;
		}
		return is;
	}
	
	
	public Persona clone() {
		Persona per = new Persona(this.nombre, this.cedula, this.edad);
		
		return per;
	}
	
}
