package es.uma.informatica.Grupo_L.backing;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Matrícula;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazMatricula;

@Named
@RequestScoped
public class MatriculaBB {

	@Inject
	private InterfazMatricula matricula;
	
	private Matrícula mat;
	private Alumno alum;
	
	public MatriculaBB() {
		
	}
	
	public Matrícula getMatricula() {
		return mat;
	}
	
	public void setMatricula(Matrícula mat) {
		this.mat = mat;
	}

	//METODO PARA LEER UNA MATRICULA
	public  synchronized List<Matrícula> getMatriculaAlumno(){
		List<Matrícula> matalum = new ArrayList<Matrícula>();
		
        for (Expediente ex : alum.getExpedientes()) {
			for (Matrícula mat : ex.getMatriculas()) {
					matalum.add(mat);
			}
		}
        return matalum;
	}

	//METODO PARA LEER TODAS LAS MATRICULAS(S)
	public  synchronized List<Matrícula> getMatriculas(){
		try {
			return matricula.leerMatriculas();
		} catch (MatriculaException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public  synchronized String getImportarMatricula(){
		try {
			matricula.importarMatricula();
		} catch (MatriculaException e) {
			e.printStackTrace();
		}
		return "LeerMatricula.xhtml";
	}
}
