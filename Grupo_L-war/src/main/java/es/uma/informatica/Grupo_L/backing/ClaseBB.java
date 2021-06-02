package es.uma.informatica.Grupo_L.backing;



import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Entidades.Clase;
import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Exception.AsignaturaException;
import es.uma.informatica.Exception.ClaseException;
import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Interfaces.InterfazAsignatura;
import es.uma.informatica.Interfaces.InterfazClase;

@Named
@RequestScoped
public class ClaseBB {

	@Inject
	private InterfazClase clase;
	
	
	
	@Inject
	private InfoSesion infosesion;
	
	private Clase clas;
	
	public ClaseBB() {
		
	}
	
	public Clase getClase() {
		return clas;
	}
	
	public void setClase(Clase clas) {
		this.clas = clas;
	}
	
	
	//METODO PARA LEER LAS CLASES DE UN ALUMNO

	public List<Clase> getClases(){
		List<Clase> clase2 = new ArrayList<Clase>();
		try {
			clase2 = clase.leerClasesAlumno(infosesion.getAlumno());
		} catch (ClaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clase2;

	}
}

		
