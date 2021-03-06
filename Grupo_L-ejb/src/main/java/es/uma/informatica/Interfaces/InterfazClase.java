package es.uma.informatica.Interfaces;

import java.io.File;
import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Clase;
import es.uma.informatica.Entidades.Clase.ClaseId;
import es.uma.informatica.Exception.ClaseException;
@Local
public interface InterfazClase {
	/**
	  Este método debe importar un horario en la base de datos.
	  En caso de que el horario no existiese, se lanza la excepción HorarioExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción HorarioErrorException.
	  En caso de que el horario sea null, se lanza la excepción HorarioNullException.
	 */
	public void Importar_Horario(File fichero) throws ClaseException;
	
	public List<Clase> leerClasesAlumno(Alumno al) throws ClaseException;

	public Clase leerClase(ClaseId cl) throws ClaseException;

	
}
