package es.uma.informatica.EJB;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.AlumnoExistenteException;
import es.uma.informatica.Exception.AlumnoNullException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Matricula;


/**
 * Session Bean implementation class Alumno
 */

@Stateless
public class AlumnoEJB implements InterfazAlumno {

	@PersistenceContext(name="Grupo_L")
	private EntityManager em;

	@Override
	public void crearAlumno(Alumno a) throws AlumnoException {
		Alumno alumno = em.find(Alumno.class, a.getID());
		if(alumno!=null) {
			//El alumno ya existe
			throw new AlumnoExistenteException();
		}
		em.persist(a);	
	}

	@Override
	public Alumno leerAlumno(Long id) throws AlumnoException {
		Alumno al = em.find(Alumno.class, id );
		if(al==null) {
			throw new AlumnoExistenteException();
		}
		return al;
	}
	
	@Override
	public List<Alumno> listaAlumno() throws AlumnoException {
		TypedQuery <Alumno> query = em.createQuery("SELECT a FROM Alumno a ", Alumno.class);
    	List<Alumno> list = query.getResultList();		
		return list; 
	}
	
	@Override
	public void actualizarAlumno(Alumno a) throws AlumnoException{
		Alumno al = leerAlumno(a.getID());
		al.setApellido1(a.getApellido1());
		al.setApellido2(a.getApellido2());
		al.setContrasenia(a.getContrasenia());
		al.setCP(a.getCP());
		al.setDireccion(a.getDireccion());
		al.setEmail_Institucional(a.getEmail_Institucional());
		al.setEmail_Personal(a.getEmail_Personal());
		al.setLocalidad(a.getLocalidad());
		al.setMovil(a.getMovil());
		al.setNombre(a.getNombre());
		al.setProvincia(a.getProvincia());
		al.setTelefono(a.getTelefono());
		em.merge(al);
	}
	
	@Override
	public void eliminarAlumno(Long id) throws AlumnoException{
		Alumno a1 = leerAlumno(id);
		if(a1 == null) {
			throw new AlumnoNullException();
		}
		em.remove(a1);		
	}
}
