/*Esta clase fue elabarada por Camilo, su finalidad es registrar todas las sedes de ventas*/
package gestorAplicacion.sede;
import java.util.*;

import gestorAplicacion.vehiculo.Vehiculo;

import java.io.*;
public class Sede implements Serializable {
	/*El objetivo de esta clase es guardar la información de las diferentes sedes que pueden despachar una orden*/
	private static final long serialVersionUID = 1L;
	private static LinkedList<Sede> sedes= new LinkedList<Sede>();
	private String direccion;
	private long telefono;
	private long cantVentas; 
	
	public Sede(String direccion, long telefono) {
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	
	public void enviar() {
		
	}
	
	static public void consultarSedes() {
    	int i = 0;
    	for(Sede sede: sedes) {

    	System.out.println(i+"- Direccion: "+ sede.direccion+" \nTelefono: "+sede.telefono+" \nVentas: "+sede.cantVentas + "\n\n");

    	i++;
		}
    }
	
	//Devuelve cual de todas las sedes ha tenido el mayor numero de ventas
	public static Sede sedeMayorVentas() {
		long aux = 0;
		Sede p = null;
		for (Sede sede : sedes) {
			if (sede.cantVentas>aux) {
				aux = sede.cantVentas;
				p = sede;
			}
		}
		return p;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public static LinkedList<Sede> getSede() {
		return sedes;
	}

	public static void adicionarSede(Sede sede) {
		sedes.add(sede);
	}
	
	public void sumarVenta() {
		this.cantVentas++;
	}
	
	public String toString() {
		return ("Direccion: "+ this.direccion+" \nTelefono: "+this.telefono+" \nVentas: "+ this.cantVentas + "\n");
	}
	
}
