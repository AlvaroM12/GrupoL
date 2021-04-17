package es.uma.informatica.Interfaces;

import es.uma.informatica.EJB.CentroEJB;
import es.uma.informatica.Exception.CentroException;

public interface InterfazCentro {
	/**
	  Este método debe consultar un centro de la base de datos.
	  En caso de que el centro no existiese, se lanza la excepción CentroExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción CentroErrorException.
	  En caso de que el centro sea null, se lanza la excepción CentroNullException.
	 */
	public void Consultar_Centro(CentroEJB c) throws CentroException;
}
