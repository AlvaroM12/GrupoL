package es.uma.informatica.Interfaces;

import java.util.Date;

import es.uma.informatica.Entidades.Clase;
import es.uma.informatica.Entidades.Clase.ClaseId;
import es.uma.informatica.Exception.ClaseException;

public interface InterfazClase {
	/**
	  Este método debe importar un horario en la base de datos.
	  En caso de que el horario no existiese, se lanza la excepción HorarioExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción HorarioErrorException.
	  En caso de que el horario sea null, se lanza la excepción HorarioNullException.
	 */
	public void Importar_Horario() throws ClaseException;
	
	public Clase leerClase(ClaseId cl) throws ClaseException;
}
