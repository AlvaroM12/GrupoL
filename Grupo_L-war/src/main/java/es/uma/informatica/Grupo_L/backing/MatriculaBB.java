package es.uma.informatica.Grupo_L.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.Entidades.Matricula;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazMatricula;

@Named
@RequestScoped
public class MatriculaBB {

	@Inject
	private InterfazMatricula matricula;
	
	private Matricula mat;
	
	public MatriculaBB() {
		
	}
	
	public Matricula getMatricula() {
		return mat;
	}
	
	public void setMatricula(Matricula mat) {
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


	//METODO PARA LEER TODAS LAS ASIG_MATRICULAS(S)
	public  synchronized List<Matricula> getMatriculas(){
		
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
