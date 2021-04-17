package es.uma.informatica.Interfaces;

import es.uma.informatica.EJB.Alumno;
import es.uma.informatica.Exception.AlumnoException;

public interface InterfazAlumno {
	/**
	  Este método debe crear un alumno en la base de datos.
	  En caso de que el alumno ya estuviera creado se lanza la excepción AlumnoExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción AlumnoErrorException.
	  En caso de que el alumno sea null, se lanza la excepción AlumnoNullException.
	 */
	public void Crear_Alumno(Alumno a) throws AlumnoException;
	
	/**
	  Este método debe leer un alumno de la base de datos.
	  En caso de que el alumno no existiese, se lanza la excepción AlumnoExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción AlumnoErrorException.
	  En caso de que el alumno sea null, se lanza la excepción AlumnoNullException.
	 */
	public void Leer_Alumno(Alumno a) throws AlumnoException;
	
	 /**
	  Este método debe actualizar un alumno de la base de datos.
	  En caso de que el alumno no existiese, se lanza la excepción AlumnoExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción AlumnoErrorException.
	  En caso de que el alumno sea null, se lanza la excepción AlumnoNullException.
	 */
	public void Actualizar_Alumno(Alumno a) throws AlumnoException;
	
	/**
	  Este método debe eliminar un alumno de la base de datos.
	  En caso de que el alumno no existiese, se lanza la excepción AlumnoExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción AlumnoErrorException.
	  En caso de que el alumno sea null, se lanza la excepción AlumnoNullException.
	 */
	public void Eliminar_Alumno(Alumno a) throws AlumnoException;
}
