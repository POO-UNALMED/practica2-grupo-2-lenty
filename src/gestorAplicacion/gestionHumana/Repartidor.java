/* Clase Repartidor tiene los atributos
 * y metodos necesarios para registrar la informacion de los repartidores
 * @Autor: Manuel Escobar
 * */
package gestorAplicacion.gestionHumana;
import java.util.Iterator;
import java.io.*;
import java.util.LinkedList;

import gestorAplicacion.sede.Sede;
import gestorAplicacion.vehiculo.*;


public class Repartidor extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	private String entSalud;
	Vehiculo vehiculo;
    private int salario;
    public boolean disponibilidad;
    public static LinkedList <Repartidor> repartidores = new LinkedList<Repartidor>();
    private int cantPedidos;
    private int aumento = 0;
    
    public Repartidor(String entSalud, int salario, boolean disponibilidad, long id, String nombre, String genero, String telefono) {
        super(id, nombre, genero, telefono);
        this.entSalud = entSalud;
        this.salario = salario;
        this.disponibilidad = disponibilidad;
        repartidores.add(this);
    }

    public Repartidor(String entSalud, int salario, boolean disponibilidad, long id, String nombre, String telefono) {
        super(id, nombre, telefono);
        this.entSalud = entSalud;
        this.salario = salario;
        this.disponibilidad = disponibilidad;
        
    }

    public Repartidor(String entSalud, int salario, boolean disponibilidad) {
        this.entSalud = entSalud;
        this.salario = salario;
        this.disponibilidad = disponibilidad;
    }
    
    public void aceptarPedido() {
    	disponibilidad = false;
    }
    public void terminarPedido() {
    	disponibilidad = true;
    }
    
    public void asignarVehiculo() {
        Iterator <Vehiculo> iterador = (Vehiculo.getVehiculos()).listIterator(); 
        while(iterador.hasNext()) {
        	vehiculo = iterador.next();
        	if (vehiculo.getDocumentosAlDia() == true && vehiculo.getRepartidor() == null ) {
        		vehiculo.setRepartidor(this);
        	}
        }
    }
    
    public void desasignarVehiculo() {
    	vehiculo.setRepartidor(null);
        vehiculo = null;    	
    }

    public String getEntSalud() {
        return entSalud;
    }

    public void setEntSalud(String entSalud) {
        this.entSalud = entSalud;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
     
    // Implementacion de metodo abstracto que permite agregar un nuevo repartidor a la lista de repartidores
    // Recibe los argumentos necesarios apra crear un nuevo objeto de tipo Repartidor
    public static void registrar(String entSalud, int salario, boolean disponibilidad, long id, String nombre, String genero, String telefono) {
		repartidores.add(new Repartidor(entSalud, salario, disponibilidad, id, nombre, genero, telefono));
		System.out.println("Repartidor creado con exito.");
	}
	
    //Metodo que permite mostrar por consola la lista de repartidores
	public static void verRepartidores() {
		int i = 0;
    	for(Repartidor repartidor: repartidores) {
	    	System.out.println(i+"- Documento:"+repartidor.getId()+"\n Nombre:"+repartidor.getNombre()+"\n Telefono:"+repartidor.getTelefono()+"\n ¿Disponible?"+repartidor.isDisponibilidad()+"\n Salario:"+repartidor.getSalario()+"\n Ha realizado "+repartidor.cantPedidos+" pedidos\n");
	    	i++;
		}
	}
	
	public static LinkedList<Repartidor> getRepartidores() {
		return repartidores;
	}
	
	public static void adicionarRepartidor(Repartidor repartidor) {
		repartidores.add(repartidor);
	}

	public static Repartidor repartidorMasPedidos() {
		int aux = 0;
		Repartidor p = null;
		for (Repartidor r : repartidores) {
			if (r.cantPedidos>aux) {
				aux = r.cantPedidos;
				p = r;
			}
		}
		return p;
	}
	//Este metodo se encarga de aumentar cada que un repartidor 
	//hace un pedido y en caso de que haya realizado mas de 5 pedidos, le aumenta 2000 a su sueldo
	public void sumarPedido() {
		this.cantPedidos++;
		if(this.cantPedidos >= 5) {
			this.aumento+=2000;
			System.out.println("Es el pedido numero " + this.cantPedidos +" de "+ this.getNombre() + ", ha generado un aumento de " + this.aumento);
			this.salario+=2000;
		}
	}
	
	
	public String toString() {
		return "Documento:"+this.getId()+"\n Nombre:"+this.getNombre()+"\n Telefono:"+this.getTelefono()+"\n ¿Disponible?"+this.isDisponibilidad()+"\n Ha realizado "+this.cantPedidos+" pedidos\n";
	}
	void registrar(){
		
	}

	public int getCantVentas() {
		// TODO Auto-generated method stub
		return this.cantPedidos;
	}

    
}
