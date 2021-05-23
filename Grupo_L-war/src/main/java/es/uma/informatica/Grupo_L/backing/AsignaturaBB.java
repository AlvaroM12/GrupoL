package es.uma.informatica.Grupo_L.backing;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Exception.AsignaturaException;
import es.uma.informatica.Interfaces.InterfazAsignatura;

@Named
@RequestScoped
public class AsignaturaBB {
	
	@Inject
	private InterfazAsignatura asignatura;
	
	private Asignatura asig;
	private Alumno alum;
	
	public AsignaturaBB(){
	}
	
	public Asignatura getAs() {
		return asig;
	}

	public void setAs(Asignatura as) {
		this.asig = as;
	}
	
	public Alumno getAlum() {
		return alum;
	}

	public void setAlum(Alumno alum) {
		this.alum = alum;
	}
	
	//METODO PARA LEER UNA ASIGNATURA
	public  synchronized List<Asignatura> getAsignaturaAlumno(){
		List<Asignatura> asigalum = new ArrayList<Asignatura>();
		
        for (Expediente ex : alum.getExpedientes()) {
        	
			for (Asignatura a : ex.getTE().getAsignaturas()) {
				asigalum.add(a);
			}
		}
        return asigalum;
	}

	//METODO PARA LEER TODAS LAS ASIGNATURAS
	public  synchronized List<Asignatura> getAsignaturas(){
		return asignatura.leerAsignaturas();
	}
	
	public  synchronized String getEliminar(Long ref){
		try {
			asignatura.eliminarAsignatura(ref);
		} catch (AsignaturaException e) {
			e.printStackTrace();
		}
		return "";
	}
}
