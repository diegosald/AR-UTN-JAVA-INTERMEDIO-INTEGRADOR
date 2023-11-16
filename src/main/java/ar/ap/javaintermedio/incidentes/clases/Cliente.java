package ar.ap.javaintermedio.incidentes.clases;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Cliente {

	 private int id ;
	 private String razonSocial;
	 private String cuit;
	 private List<EspecialidadEnum> servicios;
	
	 
	 public Cliente(int id, String razonSocial, String cuit) {
		super();
		this.id = id;
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.servicios = new ArrayList<>();
		
	}
    
	public void agregarServ(EspecialidadEnum serv) {
		this.servicios.add(serv);
		
	}
    
	public void verServ() {
		
		System.out.println(this.servicios);
	}


}
