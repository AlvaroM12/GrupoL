package es.uma.informatica.Interfaces;

import es.uma.informatica.EJB.AsignaturaEJB;
import es.uma.informatica.Exception.AsignaturaException;

public interface InterfazAsignatura {
	/**
	  Este método debe importar una asignatura en la base de datos.
	  En caso de que la asignatura no existiese, se lanza la excepción AsignaturaExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción AsignaturaErrorException.
	  En caso de que la asignatura sea null, se lanza la excepción AsignaturaNullException.
	 */
	public void Importar_Asignatura(AsignaturaEJB asig) throws AsignaturaException;
}
