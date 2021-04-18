package es.uma.informatica.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Exception.AlumnoErrorException;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.AlumnoExistenteException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Entidades.Alumno;

/**
 * Session Bean implementation class Alumno
 */

@Stateless
public class AlumnoEJB implements InterfazAlumno {

	@PersistenceContext(name="Alumno")
	private EntityManager em;
    

	@Override
	public void Crear_Alumno(Alumno a) throws AlumnoException {
		Alumno alumno = em.find(Alumno.class, a.getID());
		if(alumno!=null) {
			//El grupo ya existe
			throw new AlumnoExistenteException();
		}
		em.persist(a);	
		
	}

	@Override
	public void Leer_Alumno(Alumno a) throws AlumnoException {
		Alumno al=em.find(Alumno.class,  a.getID() );
		if(al==null) {
			throw new AlumnoExistenteException();
		}else if(al!=null) {
			throw new AlumnoErrorException();
		}
		
	}

	@Override
	public void Actualizar_Alumno(Alumno a) throws AlumnoException{
		Leer_Alumno(a);
		Alumno al=em.find(Alumno.class, a.getID());
		em.merge(al);
		
		
		
	}

	@Override
	public void Eliminar_Alumno(Alumno a) throws AlumnoException{
		Leer_Alumno(a);
		em.remove(em.merge(a));
		
	}

}
