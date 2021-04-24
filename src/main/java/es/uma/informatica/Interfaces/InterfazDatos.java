package es.uma.informatica.Interfaces;

import java.io.IOException;

import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.DatosException;

public interface InterfazDatos {
	/**
	  Este método debe exportar los datos de los grupos por asignatura de la base de datos.
	  En caso de que no haya datos para exportar, se lanza la excepción DatosExistenteException.
	 */
	public void exportarDatos(Titulacion t) throws DatosException, IOException;
}
