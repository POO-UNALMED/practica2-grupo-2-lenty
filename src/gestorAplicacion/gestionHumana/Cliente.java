/* Clase Cliente tiene los atributos
 * y metodos necesarios para registrar la informacion de los clientes
 * @Autor: Manuel Escobar
 * */
package gestorAplicacion.gestionHumana;
import java.io.*;

import java.util.LinkedList;

import gestorAplicacion.sede.Sede;

public class Cliente extends Persona implements Serializable {
	// Se implementa el atributo necesario apra la implementacion
	private static final long serialVersionUID = 1L;
	
	private String direccion;
	private String metPago;
	private long tarjeta;
	private int cantVentas;
	private static LinkedList<Cliente> clientes = new LinkedList<Cliente>();
	
	public Cliente(String direccion, String metPago, long tarjeta, long id, String nombre, String genero, String telefono) {
        super(id, nombre, genero, telefono);
        this.direccion = direccion;
        this.metPago = metPago;
        this.tarjeta = tarjeta;
        clientes.add(this);
    }

    public Cliente(String direccion, String metPago, long tarjeta, long id, String nombre, String telefono) {
        super(id, nombre, telefono);
        this.direccion = direccion;
        this.metPago = metPago;
        this.tarjeta = tarjeta;
    }

    public Cliente(String direccion, String metPago, long tarjeta) {
        this.direccion = direccion;
        this.metPago = metPago;
        this.tarjeta = tarjeta;
    }
	
	public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMetPago() {
        return metPago;
    }

    public void setMetPago(String metPago) {
        this.metPago = metPago;
    }

    public long getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(long tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    // Implementacion de metodo abstracto que permite agregar un nuevo usuario a la lista de clientes
    // Recibe los argumentos necesarios apra crear un nuevo objeto de tipo Cliente
	public static void registrar(String direccion, String metPago, long tarjeta, long id, String nombre, String genero, String telefono) {
		clientes.add(new Cliente(direccion, metPago, tarjeta, id, nombre, genero, telefono));
		System.out.println("Cliente creado con exito.");
	}
	
	//Metodo que permite mostrar por consola la lista de clientes
	public static void verClientes() {
		int i = 0;
    	for(Cliente cliente: clientes) {
	    	System.out.println(i+" - Documento:"+cliente.getId()+"\n Nombre:"+cliente.getNombre()+"\n Telefono:"+cliente.getTelefono()+"\n Metodo Pago: "+cliente.getMetPago()+"\n Direccion:"+cliente.getDireccion() +"\n Ha comprado "+cliente.cantVentas+" veces\n");
	    	i++;
		}
	}
	
	public static LinkedList<Cliente> getClientes() {
		return clientes;
	}
	
	public static void adicionarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	void registrar() {
		
		
	}
	/*Metodo que permite conocer cual es el cliente que mas ha comprado*/
	public static Cliente clienteMayorVentas() {
		int aux = 0;
		Cliente p = null;
		for (Cliente c : clientes) {
			if (c.cantVentas>aux) {
				aux = c.cantVentas;
				p = c;
			}
		}
		return p;
	}
	public void sumarVenta() {
		this.cantVentas++;
	}

	public String toString() {
		return "Documento:"+this.getId()+"\n Nombre:"+this.getNombre()+"\n Telefono:"+this.getTelefono()+"\n Metodo Pago: "+this.getMetPago()+"\n Direccion:"+this.getDireccion() +"\n Ha comprado "+this.cantVentas+" veces\n";
	}

	public int getCantVentas() {
		return cantVentas;
	}

	void setCantVentas(int cantVentas) {
		this.cantVentas = cantVentas;
	}
	
}
