/*Esta clase fue realiza por Camilo; su objetivo es describir cada vehiculo que puede tener los repartidores*/
package gestorAplicacion.vehiculo;
import java.io.*;
import java.util.*;
import gestorAplicacion.gestionHumana.*;

public class Vehiculo implements Serializable {
	/*En esta clase se guardan los vehiculos con sus atributos y en base a los atributos se determina si los objetos estan al dia, todos los objetos son guardados en una lista
	 * y asi por ser consultados posteriormente*/
	private static final long serialVersionUID = 1L;
	private String placa;
	private String modelo;
	private int matricula;
	private boolean asegurado; 
	private Boolean documentosAlDia;
	private Repartidor repartidor;
	private static LinkedList<Vehiculo> vehiculos = new LinkedList<Vehiculo>();

	
	public Vehiculo(String placa, String modelo, int matricula, boolean asegurado) {
		this(placa, modelo, matricula, asegurado, null);
	}

	
	public Vehiculo(String placa, String modelo , int matricula, boolean asegurado , Repartidor repartidor) {
		this.placa = placa;
		this.modelo = modelo;
		this.matricula = matricula;
		this.asegurado = asegurado;
		this.repartidor = repartidor;
		this.estadoDocumentos();
	}
	//Devuelve la informacion de todos los vehiculos en la base de datos
    static public void consultarVehiculo() {
    	int i = 0;
    	for(Vehiculo vehiculo: vehiculos) {
    	System.out.println(i+"- Modelo:"+vehiculo.getModelo()+"\nPlaca:"+vehiculo.getPlaca()+"\n NumeroMatricula:"+vehiculo.getMatricula()+"\n ¿Asegurado?"+vehiculo.isAsegurado()+"\n Repartidor:"+vehiculo.getRepartidor());
    	i++;
		}
    }

     //Este metodo evalua si los documentos estal al dia
	public Boolean estadoDocumentos() {
		if  (placa.equals(null) || matricula == 0 ||  asegurado == false )  {

			return documentosAlDia = false;
		}
		else {
			return documentosAlDia = true;
		}

	}
	
	public static LinkedList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public static void adicionarVehiculo(Vehiculo vehiculo) {
		vehiculos.add(vehiculo);
	}


	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public Boolean getDocumentosAldia() {
		return documentosAlDia;
	}
	public void setDocumentosAldia(Boolean documentosAldia) {
		this.documentosAlDia = documentosAldia;
	}
	public Repartidor getRepartidor() {
		return repartidor;
	}
	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public boolean isAsegurado() {
		return asegurado;
	}
	public void setAsegurado(boolean asegurado) {
		this.asegurado = asegurado;
	}
	public Boolean getDocumentosAlDia() {
		return documentosAlDia;
	}
	public void setDocumentosAlDia(Boolean documentosAlDia) {
		this.documentosAlDia = documentosAlDia;
	}
	public static void setVehiculos(LinkedList<Vehiculo> vehiculos) {
		Vehiculo.vehiculos = vehiculos;
	}

	



}
