package ar.ap.javaintermedio.incidentes.clases;



import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public abstract class Persona {
    
	
	
	private int id;
	private String nombre;
	private String apellido;
	private String fn;
	
	public Persona(int id, String nombre, String apellido, String fn) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fn = fn;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fn=" + fn + "]";
	}
	
   
	
}
