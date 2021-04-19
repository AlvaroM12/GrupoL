package es.uma.informatica.Interfaces;

import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.TitulacionException;

public interface InterfazTitulacion {
	/**
	  Este método debe consultar una titulacion en la base de datos.
	  En caso de que la titulacion sea null, se lanza la excepción TitulacionNullException.
	 */
	public void consultarTitulacion(Titulacion t) throws TitulacionException;
	/**
	  Este método debe importar una titulacion en la base de datos.

	 */
	public void importarTitulacion() throws TitulacionException;
}
