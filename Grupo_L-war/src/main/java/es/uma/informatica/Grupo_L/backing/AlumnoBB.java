package es.uma.informatica.Grupo_L.backing;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.EJB.AlumnoEJB;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Interfaces.InterfazAlumno;

@Named(value = "alumnos")
@RequestScoped
public class AlumnoBB {

	@Inject
	private InterfazAlumno alejb;

	private List<Alumno> listaAl = new ArrayList();
	private Alumno al;

	public AlumnoBB() {
		al = new Alumno();
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

	public void listarAlumnos() throws AlumnoException {
		for (Alumno alumno : alejb.listaAlumno()) {
			al.setDNI(alumno.getDNI());
			al.setNombre(alumno.getNombre());
			al.setApellido1(alumno.getApellido1());
			al.setApellido2(alumno.getApellido2());
			al.setEmail_Institucional(alumno.getEmail_Institucional());
			al.setEmail_Personal(alumno.getEmail_Personal());
			al.setMovil(alumno.getMovil());
			al.setDireccion(alumno.getDireccion());
			al.setLocalidad(alumno.getLocalidad());
			al.setProvincia(alumno.getProvincia());
			al.setCP(alumno.getCP());

			listaAl.add(al);
		}
	}
	
	public void añadirAlumno() {
		al.setDNI(al.getDNI());
		al.setNombre(al.getNombre());
		
		listaAl.add(al);
	}
}
