/*La base de datos fue diseñada por Camilo y implementada en cada clase segun su respectivo usario, la funcion de este modulo es leer la información en los archivos txt 
 * y llena las listas de cada clase con los objetos correspondientes
 */
package baseDatos;
import java.io.*;

import gestorAplicacion.gestionHumana.*;
import gestorAplicacion.vehiculo.Vehiculo;
import gestorAplicacion.orden.Orden;
import gestorAplicacion.orden.Producto;
import gestorAplicacion.sede.Sede;

public class Lector {
	static ObjectInputStream objectInputStream;
	static File archivo = new File("");
	/*Este metodo se ejecuta al ejecutar el programa para cargar la base de datos de objetos de cada eespectiva clase*/
	public static void Leer() {
		

		try {
			FileInputStream entrada = new FileInputStream(archivo.getAbsolutePath()+"\\src\\baseDatos\\temp\\vehiculos.txt");
			objectInputStream = new ObjectInputStream(entrada);
			
			int numVehiculos = objectInputStream.readInt();
			Vehiculo vehiculo;
			for (int i =1; i<=numVehiculos; i++ ) {
				vehiculo = (Vehiculo) objectInputStream.readObject();
				Vehiculo.adicionarVehiculo(vehiculo);
				
				
			}
			objectInputStream.close();
		}
		
		catch(Exception excepcion) {
			System.out.println(excepcion.getMessage());
		}
		try {
			FileInputStream entrada = new FileInputStream(archivo.getAbsolutePath()+"\\src\\baseDatos\\temp\\sedes.txt");
			objectInputStream = new ObjectInputStream(entrada);
			
			int numVehiculos = objectInputStream.readInt();
			
			for (int i =1; i<=numVehiculos; i++ ) {
				Sede.adicionarSede(((Sede) objectInputStream.readObject()));
				// Adicionar print en caso de querer mostrarlos por consola
				
			}
			objectInputStream.close();
		}
		
		catch(Exception excepcion) {
			System.out.println(excepcion.getMessage());
		}

		// Repartidores
		try {
			FileInputStream entrada = new FileInputStream(archivo.getAbsolutePath()+"\\src\\baseDatos\\temp\\repartidores.txt");
			objectInputStream = new ObjectInputStream(entrada);
			
			int numRepartidores = objectInputStream.readInt();
			Repartidor repartidor;
			for (int i =1; i <= numRepartidores; i++ ) {
				repartidor = (Repartidor) objectInputStream.readObject();
				Repartidor.adicionarRepartidor(repartidor);
				
				
			}
			objectInputStream.close();
		}
		
		catch(Exception excepcion) {
			System.out.println(excepcion.getMessage());
		}
		// Clientes
		try {
			FileInputStream entrada = new FileInputStream(archivo.getAbsolutePath()+"\\src\\baseDatos\\temp\\clientes.txt");
			objectInputStream = new ObjectInputStream(entrada);
			
			int numClientes = objectInputStream.readInt();
			Cliente cliente;
			for (int i =1; i <= numClientes; i++ ) {
				cliente = (Cliente) objectInputStream.readObject();
				Cliente.adicionarCliente(cliente);
				
				
			}
			objectInputStream.close();
		}
		
		catch(Exception excepcion) {
			System.out.println(excepcion.getMessage());
		}
		try {
			FileInputStream entrada = new FileInputStream(archivo.getAbsolutePath()+"\\src\\baseDatos\\temp\\ordenes.txt");
			objectInputStream = new ObjectInputStream(entrada);
			
			int numOrdenes = objectInputStream.readInt();
			Orden orden;
			for (int i =1; i <= numOrdenes; i++ ) {
				orden = (Orden) objectInputStream.readObject();
				Orden.adicionarOrden(orden);
				
				
			}
			objectInputStream.close();
		}
		
		catch(Exception excepcion) {
			System.out.println(excepcion.getMessage());
		}

		try {
			FileInputStream entrada = new FileInputStream(archivo.getAbsolutePath()+"\\src\\baseDatos\\temp\\productos.txt");
			objectInputStream = new ObjectInputStream(entrada);
			
			int numProductos = objectInputStream.readInt();
			Producto producto;
			for (int i =1; i<=numProductos; i++ ) {
				producto = (Producto) objectInputStream.readObject();
				Producto.adicionarProducto(producto);
				
				
			}
			objectInputStream.close();
		}
		
		catch(Exception excepcion) {
			System.out.println(excepcion.getMessage());
		}
		try {
			FileInputStream entrada = new FileInputStream(archivo.getAbsolutePath()+"\\src\\baseDatos\\temp\\personas.txt");
			objectInputStream = new ObjectInputStream(entrada);
			
			int numPersonas = objectInputStream.readInt();
			Persona persona;
			for (int i =1; i<=numPersonas; i++ ) {
				persona = (Persona) objectInputStream.readObject();
				Persona.adicionarPersona(persona);
				
				
			}
			objectInputStream.close();
		}
		
		catch(Exception excepcion) {
		}

	}
}
