package es.uma.informatica.Grupo_L.backing;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Matricula;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazMatricula;

@Named
@RequestScoped
public class MatriculaBB {

	@Inject
	private InterfazMatricula matricula;
	
	private Matricula mat;
	
	@Inject
	private InfoSesion infosesion;
	
	public MatriculaBB() {
		
	}

	public Matricula getMat() {
		return mat;
	}

	public void setMat(Matricula mat) {
		this.mat = mat;
	}

	

	//METODO PARA LEER UNA MATRICULA (ALUMNO)
	public  synchronized List<Matricula> getMatriculaAlumno() throws MatriculaException{
		List<Matricula> matalum = new ArrayList<Matricula>();
		
        for (Expediente ex : infosesion.getAlumno().getExpedientes()) {
			for (Matricula matricula : matricula.buscarMatriculas(ex)) {
				matalum.add(matricula);
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
}
