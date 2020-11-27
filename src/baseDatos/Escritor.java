/*La base de datos fue diseñada por Camilo y implementada en cada clase segun su respectivo usario, la funcion de este modulo es escribir la información en los archivos txt 
 * de las listas de objetos de cada clase
 */
package baseDatos;
import java.io.*;


import gestorAplicacion.gestionHumana.*;
import gestorAplicacion.orden.Orden;
import gestorAplicacion.orden.Producto;

import gestorAplicacion.sede.Sede;
import gestorAplicacion.vehiculo.*;

public class Escritor {

	static File archivo = new File("");
	private static ObjectOutputStream objectOutputStream;
	/*Este metodo se ejecuta al cerrar el programa para guardar la base de datos de objetos de cada respectiva clase*/
	public static void Escribir() {
		try {
			FileOutputStream salida = new FileOutputStream(archivo.getAbsolutePath()+"\\src\\baseDatos\\temp\\vehiculos.txt");
			objectOutputStream = new ObjectOutputStream(salida);
			
			objectOutputStream.writeInt(new Integer((Vehiculo.getVehiculos()).size()));
			for (Vehiculo vehiculo : Vehiculo.getVehiculos())
				objectOutputStream.writeObject(vehiculo);
			
			
			objectOutputStream.close();
		}
		catch(Exception excepcion) {
			System.out.println(excepcion.getMessage());
		}
		try {
			FileOutputStream salida = new FileOutputStream(archivo.getAbsolutePath()+"\\src\\baseDatos\\temp\\sedes.txt");
			objectOutputStream = new ObjectOutputStream(salida);
			
			objectOutputStream.writeInt(new Integer((Sede.getSede()).size()));
			for (Sede sede : Sede.getSede())
				objectOutputStream.writeObject(sede);
			
			
			objectOutputStream.close();
		}
		catch(Exception excepcion) {
			System.out.println(excepcion.getMessage());
		}
		try {
			FileOutputStream salida = new FileOutputStream(archivo.getAbsolutePath()+"\\src\\baseDatos\\temp\\clientes.txt");
			objectOutputStream = new ObjectOutputStream(salida);
			
			objectOutputStream.writeInt(new Integer((Cliente.getClientes()).size()));
			for (Cliente cliente : Cliente.getClientes())
				objectOutputStream.writeObject(cliente);
			
			
			objectOutputStream.close();
		}
		catch(Exception excepcion) {
			System.out.println(excepcion.getMessage());
		}
		try {
			FileOutputStream salida = new FileOutputStream(archivo.getAbsolutePath()+"\\src\\baseDatos\\temp\\repartidores.txt");
			objectOutputStream = new ObjectOutputStream(salida);
			
			objectOutputStream.writeInt(new Integer((Repartidor.getRepartidores()).size()));
			for (Repartidor repartidor : Repartidor.getRepartidores())
				objectOutputStream.writeObject(repartidor);
			
			
			objectOutputStream.close();
		}
		catch(Exception excepcion) {
			System.out.println(excepcion.getMessage());
		}
		try {
			FileOutputStream salida = new FileOutputStream(archivo.getAbsolutePath()+"\\src\\baseDatos\\temp\\ordenes.txt");
			objectOutputStream = new ObjectOutputStream(salida);
			
			objectOutputStream.writeInt(new Integer(Orden.getOrdenes().size()));
			for (Orden orden : Orden.getOrdenes())
				objectOutputStream.writeObject(orden);
			
			
			objectOutputStream.close();
		}
		catch(Exception excepcion) {
			System.out.println(excepcion.getMessage());
		}
		try {
			FileOutputStream salida = new FileOutputStream(archivo.getAbsolutePath()+"\\src\\baseDatos\\temp\\productos.txt");
			objectOutputStream = new ObjectOutputStream(salida);
			
			objectOutputStream.writeInt(new Integer((Producto.getProductos()).size()));
			for (Producto producto : Producto.getProductos())
				objectOutputStream.writeObject(producto);
			
			
			objectOutputStream.close();
		}
		catch(Exception excepcion) {
			System.out.println(excepcion.getMessage());
		}
		

	}
}	    
	

