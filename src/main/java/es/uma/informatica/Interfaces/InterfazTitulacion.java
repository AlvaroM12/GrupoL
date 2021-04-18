package es.uma.informatica.Interfaces;

import es.uma.informatica.EJB.TitulacionEJB;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.TitulacionException;

public interface InterfazTitulacion {
	/**
	  Este método debe consultar una titulacion en la base de datos.
	  En caso de que la titulacion no existiese, se lanza la excepción TitulacionExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción TitulacionErrorException.
	  En caso de que la titulacion sea null, se lanza la excepción TitulacionNullException.
	 */
	public void Consultar_Titulacion(Titulacion t) throws TitulacionException;
	public void Importar_Titulacion() throws TitulacionException;
}
