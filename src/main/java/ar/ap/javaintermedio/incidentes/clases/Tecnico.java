package ar.ap.javaintermedio.incidentes.clases;


import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tecnico extends Persona {
      
	private List<EspecialidadEnum> Especialidades;
    private MedioComEnum medioCOm;
    EstadoTec estado;
	
	public Tecnico(int id, String nombre, String apellido, String fn, MedioComEnum medio) {
		super(id, nombre, apellido, fn);
		this.Especialidades = new ArrayList<>();
		this.medioCOm = medio;
		this.estado = new EstadoTecLibre();
	}
    
	public void cargarEsp(EspecialidadEnum esp) {
		
		this.Especialidades.add(esp);
		
	}
	public void verEsp() {
		
		System.out.println(this.Especialidades);
	}

	@Override
	public String toString() {
		return "Tecnico [Especialidades=" + Especialidades + ", medioCOm=" + medioCOm + ", estado=" + estado.verEstado() + "]";
	}
    
	
	
	
	
}
