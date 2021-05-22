package es.uma.informatica.Grupo_L.backing;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignaturas_Matrícula;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Matrícula;
import es.uma.informatica.Entidades.Usuario;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Interfaces.InterfazGrupo;


@Named
@RequestScoped
public class GrupoBB {
	
	@Inject
	private InterfazAlumno alumno;
	
	@Inject
	private InterfazGrupo grupo;
	
	private Asignaturas_Matrícula asigmat;
	private Alumno alum;
	
	
	public GrupoBB() {
		
	}


	public Asignaturas_Matrícula getAsigmat() {
		return asigmat;
	}


	public void setAsigmat(Asignaturas_Matrícula asigmat) {
		this.asigmat = asigmat;
	}
	
	
	
	public Alumno getAlum() {
		return alum;
	}


	public void setAlum(Alumno alum) {
		this.alum = alum;
	}


	//NO SE SI FUNCIONA PORQUE SON 3 FOREACH ANIDADOS
	public synchronized List<Asignaturas_Matrícula> getAsignaturasMatriculasAlumno()
    {
		List<Asignaturas_Matrícula> asigmatalum = new ArrayList<Asignaturas_Matrícula>();
        for (Expediente ex : alum.getExpedientes()) {
			for (Matrícula mat : ex.getMatriculas()) {
				for (Asignaturas_Matrícula asignaturasmat: mat.getAsigMatricula()) {
					asigmatalum.add(asignaturasmat);
				}
			}
		}
        return asigmatalum;
    }
	
	//METODO PARA LEER TODAS LAS ASIG_MATRICULAS(S)
	public  synchronized List<Asignaturas_Matrícula> getAsignaturasMatriculas(){
		
		try {
			return grupo.leerAsignaturasMatricula();
		} catch (GrupoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public synchronized void refrescarUsuario()
    {
        try {
	        if (alum != null)
	        {
	        	alumno.actualizarAlumno(alum);
	        }
        }
        catch (AlumnoException e) {
            // TODO
        }
    }
	
	
	
	
	
	

}
