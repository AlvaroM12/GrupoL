package es.uma.informatica.Interfaces;

import es.uma.informatica.Entidades.Centro;
import es.uma.informatica.Exception.CentroException;

public interface InterfazCentro {
	/**
	  Este método debe consultar un centro de la base de datos.
	  En caso de que el centro sea null, se lanza la excepción CentroNullException.
	 */
	public void ConsultarCentro(Centro c) throws CentroException;
}
