/* Clase Persona marca los atributos de los cuales se heredara a las demas clases
 *  del paquete gestionHumana
 *  @Autor: Manuel Escobar
 * */

package gestorAplicacion.gestionHumana;
import java.io.Serializable;
import java.util.LinkedList;

public abstract class Persona implements Serializable{
	// Se implementa el atributo necesario apra la implementacion
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nombre;
	private String genero;
	private String telefono;
	private static LinkedList<Persona> personas = new LinkedList<>();
	
	//Metodo abstracto que debe implementarse en Cliente y Repartidor
	abstract void registrar();
	
	public Persona(long id, String nombre, String genero, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.telefono = telefono;
    }

    public Persona(long id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public Persona() {
    }
	
	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

	public static void adicionarPersona(Persona persona) {
		Persona.personas.add(persona);
		
	}
	
}
