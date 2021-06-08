package es.uma.informatica.Grupo_L.backing;


import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Entidades.Asignaturas_Matricula;
import es.uma.informatica.Entidades.Grupo;
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
	private ModificarGrupoBB mg;
	
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
		try {
			return grupo.leerAsigMatriculaAlumno(infosesion.getAlumno());
		} catch (GrupoException e) {
			e.printStackTrace();
		} 
		return null;
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
		

	
	//ELIMINAR GRUPO
	public void eliminarGrupo(Grupo g) {
		try {
			grupo.eliminarGrupo(g);
		} catch (GrupoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//MODIFICAR GRUPO
	public String actualizarGrupo(Grupo g) {
		mg.setG(g);
		return "ModificarGrupo.xhtml";
	}
	
	//CREAR GRUPO
	public String crearGrupo() {
		return "CrearGrupo.xhtml";
	}
	
}
