package es.uma.informatica.Grupo_L.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Interfaces.InterfazGrupo;
import es.uma.informatica.Interfaces.InterfazTitulacion;

@Named(value = "ma")
@RequestScoped
public class ModificarAlumnoBB {
	
	@Inject
	private InterfazAlumno interfazAlumno;
	
	private Alumno a;


	
	public ModificarAlumnoBB() {
		a = new Alumno();
	}

	
	
	public Alumno getA() {
		return a;
	}



	public void setA(Alumno a) {
		this.a = a;
	}



	public String crear() {
		
		try {
			interfazAlumno.crearAlumno(a);
		} catch (AlumnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "LeerAlumnos.xhtml";

	
}


	public String modificar() {
		try {
			interfazAlumno.actualizarAlumno(a);
		} catch (AlumnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "LeerAlumnos.xhtml";
	}
	

}
