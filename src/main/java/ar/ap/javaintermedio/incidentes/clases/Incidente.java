package ar.ap.javaintermedio.incidentes.clases;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Incidente {

	private int id;
	private Cliente cliente;
	private EspecialidadEnum servicio;
	private String descripcion;
	private Tecnico tecnico;
	
	public Incidente(int id, Cliente cliente, EspecialidadEnum serv,String des) {
		this.id = id;
		this.cliente = cliente;
		this.servicio = serv;
		this.descripcion = des;
	}
	
	public void verTecnicos(List<Tecnico> tec) {
		
		tec.stream()
	        .filter((x)-> x.getEspecialidades().stream().anyMatch((l) -> l.equals(this.servicio)))
	        .forEach((k) -> System.out.println(k.toString()));
				
	}
	
	
    public void enviarNotificacion() {
		
		if (this.tecnico.getMedioCOm().equals(MedioComEnum.WHATSAPP)) {
			System.out.println("WHATSAPP SE INFORMA NUEVO INCIDENTE N: " 
				+ this.getId() + " CLIENTE: " + this.getCliente().getRazonSocial() +  " Descripcion: " + this.getDescripcion());
		}
		else {
			System.out.println("Email SE INFORMA NUEVO INCIDENTE N: " 
					+ this.getId() + " CLIENTE: " + this.getCliente().getRazonSocial() +  " Descripcion: " + this.getDescripcion());
		}
		
				
	}
	

	@Override
	public String toString() {
		return "Incidente [id=" + id + ", cliente=" + cliente.getRazonSocial() + ", servicio=" + servicio + ", descripcion="
				+ descripcion + ", tecnico=" + tecnico.getNombre() + "]";
	}
	
	
	
	
	
	
}
