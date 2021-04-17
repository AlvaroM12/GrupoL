package es.uma.informatica.Interfaces;

import es.uma.informatica.EJB.ExpedienteEJB;
import es.uma.informatica.Exception.ExpedienteException;

public interface InterfazExpediente {
	/**
	  Este método debe importar un expediente en la base de datos.
	  En caso de que el expediente no existiese, se lanza la excepción ExpedienteExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción ExpedienteErrorException.
	  En caso de que el expediente sea null, se lanza la excepción ExpedienteNullException.
	 */
	public void Importar_Expediente(ExpedienteEJB exp) throws ExpedienteException;

}
