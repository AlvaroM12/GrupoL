package es.uma.informatica.Grupo_L.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignaturas_Matrícula;
import es.uma.informatica.Entidades.Usuario;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Interfaces.InterfazGrupo;


@Named
@RequestScoped
public class GrupoBB {
	
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
	
	//FALTA CREAR METODO EN EJB PARA QUE LEA LAS DE UN ALUMNO
	/*public synchronized List<Asignaturas_Matrícula> getAsignaturasMatriculasAlumno()
    {
        if (alum != null)
        {
            return alum.getExpedientes();
        }
        return null;
    }*/
	
	//METODO PARA LEER TODAS LAS ASIG_MATRICULAS(S)
	public  synchronized List<Asignaturas_Matrícula> getAsignaturasMatriculas(){
		
		try {
			return grupo.leerAsignaturasMatricula();
		} catch (GrupoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	

}
