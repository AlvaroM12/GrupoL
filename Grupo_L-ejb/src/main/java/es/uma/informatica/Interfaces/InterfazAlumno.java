package es.uma.informatica.Interfaces;

import es.uma.informatica.Exception.AlumnoErrorException;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.AlumnoExistenteException;
import java.util.List;
import javax.ejb.Local;
import es.uma.informatica.Entidades.*;

@Local
public interface InterfazAlumno {
	/**
	  Este método debe crear un alumno en la base de datos.
	  En caso de que el alumno ya estuviera creado se lanza la excepción AlumnoExistenteException.
	  
	 */
	public void crearAlumno(Alumno a) throws AlumnoException;
	
	/**
	  Este método debe leer un alumno de la base de datos.
	  En caso de que el alumno no existiese, se lanza la excepción AlumnoExistenteException.
	  
	 * @throws AlumnoExistenteException 
	 * @throws AlumnoErrorException 
	 */
	public Alumno leerAlumno(Long id) throws AlumnoException;
	
	 /**
	  Este método debe actualizar un alumno de la base de datos.
	  En caso de que el alumno no existiese, se lanza la excepción AlumnoExistenteException.
	  
	 * @throws AlumnoExistenteException 
	 * @throws AlumnoErrorException 
	  
	 */
	public void actualizarAlumno(Alumno a) throws AlumnoException;
	
	/**
	  Este método debe eliminar un alumno de la base de datos.
	  En caso de que el alumno no existiese, se lanza la excepción AlumnoExistenteException.
	  
	 * @throws AlumnoExistenteException 
	 * @throws AlumnoErrorException 
	  
	 */
	public void eliminarAlumno(Long id) throws AlumnoException;

	
	public List<Alumno> listaAlumno() throws AlumnoException;
}
