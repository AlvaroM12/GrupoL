package es.uma.informatica.Interfaces;

import es.uma.informatica.Exception.AlumnoErrorException;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.AlumnoExistenteException;
import es.uma.informatica.Entidades.*;
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
}
