package es.uma.informatica.Grupo_L.backing;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignaturas_Matricula;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Entidades.Matricula;
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
	
	@Inject
	private InfoSesion infosesion;
	
	private Asignaturas_Matricula asigmat;
	
	
	
	public GrupoBB() {
		
	}


	public Asignaturas_Matricula getAsigmat() {
		return asigmat;
	}


	public void setAsigmat(Asignaturas_Matricula asigmat) {
		this.asigmat = asigmat;
	}
	
	


	//LEE LA ASIGNATURAS MATRICULA DE UN ALUMNO (FUNCIONA)
	public List<Asignaturas_Matricula> getAsignaturasMatriculasAlumno()
    {
		List<Asignaturas_Matricula> asigmatalum = new ArrayList<Asignaturas_Matricula>();
        for (Expediente ex : infosesion.getAlumno().getExpedientes()) {
			for (Matricula mat : ex.getMatriculas()) {
				for (Asignaturas_Matricula asignaturasmat: mat.getAsigMatricula()) {
					asigmatalum.add(asignaturasmat);
				}
			}
		}
        return asigmatalum;
    }
	
	//METODO PARA LEER TODAS LAS ASIG_MATRICULAS(S)
	public List<Asignaturas_Matricula> getAsignaturasMatriculas(){
		
		try {
			return grupo.leerAsignaturasMatricula();
		} catch (GrupoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//METODO PARA LEER TODAS LOS GRUPOS(S)
	public  synchronized List<Grupo> getGrupos(){
		
		try {
			return grupo.leerGrupos();
		} catch (GrupoException e) {
			e.printStackTrace();
		}
		return null;
	}
		
		
	
	public synchronized void refrescarUsuario()
    {
        try {
	        if (infosesion.getAlumno() != null)
	        {
	        	alumno.actualizarAlumno(infosesion.getAlumno());
	        }
        }
        catch (AlumnoException e) {
            // TODO
        }
    }
	
	
	
	
	
	

}
