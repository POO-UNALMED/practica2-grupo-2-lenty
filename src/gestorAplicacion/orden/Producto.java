/* Clase Producto tiene los atributos
 * y metodos necesarios para registrar, almacenar y administrar los productos que son ofrecidos al cliente
 * @Autor: Michael Zapata
 * */

package gestorAplicacion.orden;
import java.util.*;
import gestorAplicacion.gestionHumana.*;
import gestorAplicacion.sede.Sede;
import java.io.*;
public class Producto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String descripcion;
	private long precio;
	private static LinkedList<Producto> productos = new LinkedList<>();
	private int cantVentas;
	Producto(String nom,String des,long pre){
		this.nombre=nom;
		this.descripcion=des;
		this.precio=pre;
		this.adicionarProducto(this);
	}
	
	//Metodo para saber cual es el producto que mas se vende.
	public static Producto productoMayorVentas() {
		int aux = 0;
		Producto p = null;
		for (Producto pr : productos) {
			if (pr.cantVentas>aux) {
				aux = pr.cantVentas;
				p = pr;
			}
		}
		return p;
	}
	
	void setNombre(String i) {
		this.nombre=i;
	}
	public String getNombre() {
		return this.nombre;
	}
	void setDescripcion(String i) {
		this.descripcion=i;
	}
	String getDescripcion() {
		return this.descripcion;
	}
	void setPrecio(long i) {
		this.precio=i;
	}
	public long getPrecio() {
		return this.precio;
	}
	

	public static void agregarProducto(String nom,String des,long pre) {
		Producto p = (new Producto(nom, des, pre));
	}
	public static LinkedList<String> verProductos() {
		LinkedList<String> prod = new LinkedList();
		for (int i = 0; i<productos.size();i++) {
			prod.add(productos.get(i).toString());
		}
		return prod;
	}

	public String toString() {
		if (this.descripcion == "") {
			return "Nombre: "+this.nombre+ ", precio: " + this.precio;
		}
		else {
			return "Nombre: "+this.nombre+", descripcion: " + this.descripcion + ", precio: " + this.precio;
		}
	}
	public static void adicionarProducto(Producto p) {
		productos.add(p);
  }
	
	



	public static LinkedList<Producto> getProductos() {
		return productos;
	}

	static void setProductos(LinkedList<Producto> productos) {

		Producto.productos = productos;
	}



	public void sumarVenta() {
		this.cantVentas++;
	}
	
	
}
