package ar.ap.javaintermedio.incidentes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.ap.javaintermedio.incidentes.clases.Tecnico;
import ar.ap.javaintermedio.incidentes.clases.Cliente;
import ar.ap.javaintermedio.incidentes.clases.EspecialidadEnum;
import ar.ap.javaintermedio.incidentes.clases.EstadoTecOcu;
import ar.ap.javaintermedio.incidentes.clases.Incidente;
import ar.ap.javaintermedio.incidentes.clases.MedioComEnum;
import ar.ap.javaintermedio.incidentes.clases.Persona;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	List<Tecnico> tecnicos = new ArrayList<>();
    	List<Cliente> clientes = new ArrayList<>();
    	Cliente busqueda = null;
    	
    	
    	//CARGO TECNICOS
    	Tecnico tec1 = new Tecnico(1,"Ramon","lopez","10/10/86",MedioComEnum.EMAIL);
    	Tecnico tec2 = new Tecnico(2,"Carlos","lopez","15/10/86",MedioComEnum.WHATSAPP);
    	Tecnico tec3 = new Tecnico(2,"Juan","lopez","18/10/86",MedioComEnum.EMAIL);
    	
    	//CARGO ESP
    	tec1.cargarEsp(EspecialidadEnum.SAP);
    	tec1.cargarEsp(EspecialidadEnum.WINDOWS);
    	tec2.cargarEsp(EspecialidadEnum.WINDOWS);
    	tec3.cargarEsp(EspecialidadEnum.TANGO);
    	
    	//AGREGO A LA LISTA DE TEC
    	tecnicos.add(tec1);
    	tecnicos.add(tec2);
    	tecnicos.add(tec3);
    	
    	tec1.setEstado(new EstadoTecOcu());
    	
    	//CREO CLIENTES 
    	Cliente cli1 = new Cliente(1,"PEREX COMP","2222222");
    	Cliente cli2 = new Cliente(1,"REPOEX","3333333");
    	
    	//CARGO SERVIVIOS
    	cli1.agregarServ(EspecialidadEnum.WINDOWS);
    	cli1.agregarServ(EspecialidadEnum.TANGO);
    	cli2.agregarServ(EspecialidadEnum.SAP);
    	//CARGO A LA LISTA CLI
    	clientes.add(cli1);
    	clientes.add(cli2);
    	
        //BUSCA POR CUIL
    	try {
        	busqueda = clientes.stream()
        	    	 .filter((x)-> x.getCuit().equals("333333"))
        	    	 .findFirst().orElseThrow();
        	System.out.println(busqueda.getRazonSocial());
        } catch (Exception e) {
			System.out.println(e.getMessage());
		}
      
    	   	  
    	//GENERO INCIDENTE
    	Incidente inc1 = new Incidente(1,cli1,EspecialidadEnum.WINDOWS,"falla de inicio en windows");
    	Incidente inc2 = new Incidente(2,cli2,EspecialidadEnum.SAP,"Falla en db"); 	 
    	

       // tecnicos.stream().forEach((x) -> System.out.println(x.getEspecialidades()));
     
        //VEO TECNICOS QUE TIENEN ESA ESPECIALIDAD
    	
    	System.out.println("TECNICOS DEISPONIBLES PARA "+ inc1.getServicio() +" " +  inc1.getDescripcion());
    	inc1.verTecnicos(tecnicos);
    	System.out.println("TECNICOS DEISPONIBLES PARA " + inc2.getServicio() +" " + inc2.getDescripcion());
    	inc2.verTecnicos(tecnicos);
    	
    	//ASIGNO TECNICO
    	inc1.setTecnico(tec2);
    	inc2.setTecnico(tec1);
    	
    	//VEO INCIDENTE
        System.out.println(inc1);
        System.out.println(inc2);
    	
        //NOTIFICO AL TECNICO
        inc1.enviarNotificacion();
        inc2.enviarNotificacion();
        
        /*  tecnicos.stream()
        .filter((x)-> x.getEspecialidades().stream().anyMatch((l) -> l.equals(EspecialidadEnum.WINDOWS)))
        .forEach((k) -> System.out.println(k.toString()));*/
    	
    }
}
