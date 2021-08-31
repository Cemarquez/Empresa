package com.uniquindio.lenguaje.mundo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

import com.uniquindio.lenguaje.controllers.PrincipalController.Tipo;
import com.uniquindio.lenguaje.exceptions.MaxVocalException;
import com.uniquindio.lenguaje.exceptions.MinYearException;
import com.uniquindio.lenguaje.exceptions.PersonRepitException;


public class Empresa {

	private ArrayList<Persona> listadoPersonas;
	public Empresa ()
	{
		listadoPersonas = new ArrayList<Persona>();
		crearEmpleadosClientes();
		crearPersonas();
	}
	
	public void agregarPersona (String nombre, int cedula, int edad, String incog , Tipo tipo) throws MinYearException
	{
		if(tipo == Tipo.CLIENTE)
		{
			Persona per = new Cliente(nombre, cedula, edad);
			((Cliente) per).setEmail(incog);
			agregarPersona(per);
		}else if(tipo == Tipo.EMPLEADO)
		{
			if(edad<18)
			{
				throw new MinYearException("No puede añadir menores de edad como empleados.");
			}else {
				Persona per = new Empleado(nombre, cedula, edad, Integer.parseInt(incog));
				agregarPersona(per);
			}
		}
	}
	
	
	public void agregarPersona(Persona per) throws MaxVocalException, PersonRepitException
	{
		if(isRepetida(per))
		{
			throw new PersonRepitException("Esta persona ya está en el listado.");
		}else {
		   if(maxVocales(per.getNombre()))
		   {
			   throw new MaxVocalException("No puede añadir personas con más de 4 vocales en su nombre.");
		   }else {

				listadoPersonas.add(per);
		   }
		}
	}
	
	public boolean maxVocales(String name)
	{
		boolean is=false;
		int con =0;
		char[] arreglo = name.toCharArray();
		
		for(int i=0;i<arreglo.length;i++)
		{
			if(isVocal(arreglo[i]))
			{
				con++;
			}
		}
		if(con>4)
		{
			is=true;
		}
		
		return is;
	}
	
	public boolean isVocal(char a)
	{
	boolean loEs = false;
	String b =a +"";
	b.toLowerCase();
	if( b.equals("a") || b.equals("e") ||b.equals("i") ||b.equals("o") ||b.equals("u") )
	{
		loEs = true;
	}
	
	return loEs;
	}
	public boolean isRepetida(Persona p)
	{
		boolean loEs=false;
		for(int i=0;i<listadoPersonas.size();i++)
		{
			if(listadoPersonas.get(i).getCedula() == p.getCedula())
			{
				loEs = true;
			}
		}
		
		return loEs;
	}
	public Persona devolverPersona (int posicion )
	{
		return listadoPersonas.get(posicion);
	}
	
	
	public void borrarPersona(int cedula, Persona per) {
		for(int i=0;i<listadoPersonas.size();i++)
		{
			if(listadoPersonas.get(i).getCedula() == cedula) {
			  listadoPersonas.remove(per);
			  
			}
		}
	}
	
	
	public void modificarPersona (int cedulaAnti, int cedula, String nombre, Tipo tipo, String incog, int edad )
	{
		for(int i=0;i<listadoPersonas.size();i++)
		{
			if(listadoPersonas.get(i).getCedula()==cedulaAnti) {
				if(tipo == Tipo.CLIENTE) {
					if(listadoPersonas.get(i) instanceof Cliente) {
						((Cliente) listadoPersonas.get(i)).setEmail(incog);
						((Cliente) listadoPersonas.get(i)).setCedula(cedula);
						((Cliente) listadoPersonas.get(i)).setEdad(edad);
						((Cliente) listadoPersonas.get(i)).setNombre(nombre);
					}
					
				}else if(tipo == Tipo.EMPLEADO) {
					
					((Empleado) listadoPersonas.get(i)).setNombre(nombre);
					((Empleado) listadoPersonas.get(i)).setSueldo(Double.parseDouble(incog));
					((Empleado) listadoPersonas.get(i)).setEdad(edad);
					((Empleado) listadoPersonas.get(i)).setCedula(cedula);
				}
			}
			
		}
	}
	
	public void crearEmpleadosClientes()
	{
		for(int i = 0; i < 10; i++)
		{
			int cedula;
			int edad;
			double sueldo;
			String email;
			String nombre;
			
			cedula = (int) (Math.random()* 1000000);
			edad = (int) (Math.random()*80);
			sueldo = (int) (Math.random()*10000);
			nombre = "Pepe" + "" + i;
			email = nombre + (int)(Math.random()*100) + "@gmail.com";
			
			if(i%2==0)
			{
				Empleado empleado = new Empleado(nombre, cedula, edad, sueldo);
				agregarPersona(empleado);
			}
			else
			{
				Cliente cliente = new Cliente(nombre, cedula, edad);
				cliente.setEmail(email);
				agregarPersona(cliente);
			}
		}
	}
	
	public void crearPersonas()
	{
		for(int i = 10; i < 15; i++)
		{
			int cedula;
			int edad;
			String nombre;
			
			cedula = (int) (Math.random()* 1000000);
			edad = (int) (Math.random()*80);
			nombre = "Pepe" + "" + i;
			
			
				Persona pero = new Persona(nombre,cedula,edad);
				agregarPersona(pero);
				
		}
	}
	
	public ArrayList<Cliente> getClientes(){
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		for(int i=0;i<listadoPersonas.size();i++) {
			if(listadoPersonas.get(i) instanceof Cliente) {
				clientes.add((Cliente) listadoPersonas.get(i));
			}
		}
		
		return clientes;
	}
	
	public ArrayList<Persona> getPersonas(){
		ArrayList<Persona> personas = new ArrayList<Persona>();
		for(int i=0;i<listadoPersonas.size();i++) {
			if(listadoPersonas.get(i) instanceof Persona) {
				personas.add(listadoPersonas.get(i));
			}
		}
		
		return personas;
	}
	
	public ArrayList<Empleado> getEmpleados(){
		ArrayList<Empleado> clientes = new ArrayList<Empleado>();
		for(int i=0;i<listadoPersonas.size();i++) {
			if(listadoPersonas.get(i) instanceof Empleado) {
				clientes.add((Empleado) listadoPersonas.get(i));
			}
		}
		
		return clientes;
	}
	public ArrayList<Persona> getMisPersonas() {
		return listadoPersonas;
	}

	public void setMisPersonas(ArrayList<Persona> misPersonas) {
		this.listadoPersonas = misPersonas;
	}

	public ArrayList<Persona> cloneList(){
		
		ArrayList<Persona> list = new ArrayList<>();
		for(Persona p : listadoPersonas) {
			list.add(p);
		}
		
		return list;
	}
	public Object clone ()
	{
		Empresa emp = new Empresa();
		System.arraycopy(listadoPersonas, 0, emp, 0, listadoPersonas.size());
		
		return emp;
	}
}
