package es.uma.informatica.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Exception.AlumnoErrorException;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.AlumnoExistenteException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Entidades.*;
/**
 * Session Bean implementation class Alumno
 */

@Stateless
public class AlumnoEJB implements InterfazAlumno {

	@PersistenceContext(name="Alumno")
	private EntityManager em;
    

	@Override
	public void Crear_Alumno(Alumno a) throws AlumnoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Leer_Alumno(Alumno a) throws AlumnoException, AlumnoExistenteException, AlumnoErrorException {
		Alumno al=em.find(Alumno.class,  a.getDNI() );
		if(al==null) {
			throw new AlumnoExistenteException();
		}else if(al!=null) {
			throw new AlumnoErrorException();
		}
		
	}

	@Override
	public void Actualizar_Alumno(Alumno a) throws AlumnoException, AlumnoExistenteException, AlumnoErrorException {
		Leer_Alumno(a);
		Alumno al=em.find(Alumno.class, a.getDNI());
		em.merge(al);
		
		
		
	}

	@Override
	public void Eliminar_Alumno(Alumno a) throws AlumnoException, AlumnoExistenteException, AlumnoErrorException {
		Leer_Alumno(a);
		em.remove(em.merge(a));
		
	}

}
