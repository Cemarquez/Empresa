package com.uniquindio.lenguaje.mundo;

public class Empleado extends Persona{
	
	private double sueldo;
	
	public Empleado ( String nombre, int cedula, int edad, double salario )
	{
		super(nombre, cedula, edad);
		this.sueldo = salario;
		
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	
	public Empleado clone() {
		
		Empleado emp = new Empleado(this.nombre, this.cedula, this.edad, (int) this.sueldo);
		
		return emp;
	}
	
	
}
