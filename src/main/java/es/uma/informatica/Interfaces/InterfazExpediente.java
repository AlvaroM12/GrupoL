package es.uma.informatica.Interfaces;

import es.uma.informatica.EJB.ExpedienteEJB;
import es.uma.informatica.Exception.ExpedienteException;

public interface InterfazExpediente {
	/**
	  Este método debe importar un expediente en la base de datos.
	 
	 */
	public void importarExpediente(ExpedienteEJB exp) throws ExpedienteException;

}
