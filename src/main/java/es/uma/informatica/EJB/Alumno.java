package es.uma.informatica.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Interfaces.InterfazAlumno;

/**
 * Session Bean implementation class Alumno
 */

@Stateless
public class Alumno implements InterfazAlumno {

	@PersistenceContext(name="Alumno")
	private EntityManager em;
    

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
		Leer_Alumno(a);
		em.remove(em.merge(a));
		
	}

}
