package es.uma.informatica.Interfaces;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.Entidades.Centro;
import es.uma.informatica.Exception.CentroException;
@Local
public interface InterfazCentro {
	/**
	  Este método debe consultar un centro de la base de datos.
	  En caso de que el centro sea null, se lanza la excepción CentroNullException.
	 */
	public Centro ConsultarCentro(Long id) throws CentroException;

	public List<Centro> leerCentros() throws CentroException;
}
