package es.uma.informatica.Grupo_L.backing;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Matricula;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Interfaces.InterfazAlumno;

@Named
@RequestScoped
public class AlumnoBB {

	@Inject
	private InterfazAlumno alejb;

	private Alumno al;

	public AlumnoBB() {
		al = new Alumno();
	}
	
	public Alumno getAl() {
		return al;
	}

	public void setAl(Alumno al) {
		this.al = al;
	}
	
	public String eliminar(Alumno a) {
		try {
			alejb.eliminarAlumno(a.getID());

		} catch (AlumnoException e) {
			return "IndexAlumno.xhtml";
		}
		return null;
	}

	public String modificar(Alumno a) {
		al = a;
		// setModo(Modo.MODIFICAR);
		return "edicionAlumno.xhtml";
	}

	//METODO PARA LEER UN ALUMNO
	public  synchronized List<Alumno> getAlumno(){
		List<Alumno> alum = new ArrayList<Alumno>();
		
        for (Alumno a : alum) {
			if(a.getDNI().equals(al.getDNI())) {
				alum.add(a);
			}
		}
        return alum;
	}
	
	//METODO PARA LEER TODOS LOS ALUMNOS
	public  synchronized List<Alumno> getAlumnos(){
		try {
			return alejb.listaAlumno();
		} catch (AlumnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
        
	}
}
