package es.uma.informatica.EJB;

import javax.ejb.Stateless;

import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Interfaces.InterfazAlumno;

/**
 * Session Bean implementation class Alumno
 */
@Stateless
public class Alumno implements InterfazAlumno {

    /**
     * Default constructor. 
     */
    public Alumno() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Crear_Alumno(Alumno a) throws AlumnoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Leer_Alumno(Alumno a) throws AlumnoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Actualizar_Alumno(Alumno a) throws AlumnoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Eliminar_Alumno(Alumno a) throws AlumnoException {
		// TODO Auto-generated method stub
		
	}

}
