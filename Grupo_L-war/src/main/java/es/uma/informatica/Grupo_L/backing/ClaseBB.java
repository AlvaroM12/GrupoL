package es.uma.informatica.Grupo_L.backing;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.Entidades.Asignaturas_Matrícula;
import es.uma.informatica.Entidades.Clase;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Matricula;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Interfaces.InterfazClase;

@Named
@RequestScoped
public class ClaseBB {

	@Inject
	private InterfazClase clase;
	
	private Clase clas;
	
	public ClaseBB() {
		
	}
	
	public Clase getClase() {
		return clas;
	}
	
	public void setClase(Clase clas) {
		this.clas = clas;
	}
	
	/*
	//METODO PARA LEER LAS CLASES DE UN ALUMNO
	public synchronized List<Asignaturas_Matrícula> getAsignaturasMatriculasAlumno()
    {
		List<Clase> asigmatalum = new ArrayList<Asignaturas_Matrícula>();
        for (Expediente ex : alum.getExpedientes()) {
			for (Matrícula mat : ex.getMatriculas()) {
				for (Asignaturas_Matrícula asignaturasmat: mat.getAsigMatricula()) {
					asigmatalum.add(asignaturasmat);
				}
			}
		}
        return asigmatalum;
    }*/
	
}
