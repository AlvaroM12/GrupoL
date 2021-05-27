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
	private Alumno alum;
	
	public MatriculaBB() {
		
	}

	public Matricula getMat() {
		return mat;
	}

	public void setMat(Matricula mat) {
		this.mat = mat;
	}

	public Alumno getAlum() {
		return alum;
	}

	public void setAlum(Alumno alum) {
		this.alum = alum;
	}

	//METODO PARA LEER UNA MATRICULA
	public  synchronized List<Matricula> getMatriculaAlumno(){
		List<Matricula> matalum = new ArrayList<Matricula>();
		
        for (Expediente ex : alum.getExpedientes()) {
			for (Matricula mat : ex.getMatriculas()) {
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
}
