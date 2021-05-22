package es.uma.informatica.Grupo_L.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.Entidades.Matrícula;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazMatricula;

@Named
@RequestScoped
public class MatriculaBB {

	@Inject
	private InterfazMatricula matricula;
	
	private Matrícula mat;
	
	public MatriculaBB() {
		
	}
	
	public Matrícula getMatricula() {
		return mat;
	}
	
	public void setMatricula(Matrícula mat) {
		this.mat = mat;
	}



	//METODO PARA LEER TODAS LAS ASIG_MATRICULAS(S)
	public  synchronized List<Matrícula> getMatriculas(){
		
		try {
			return matricula.leerMatriculas();
		} catch (MatriculaException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
