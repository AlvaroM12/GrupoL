package es.uma.informatica.Interfaces;

import es.uma.informatica.EJB.ExpedienteEJB;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Exception.ExpedienteException;

public interface InterfazExpediente {
	/**
	  Este método debe importar un expediente en la base de datos.
	 
	 */
	public void importarExpediente() throws ExpedienteException;
	
	public Expediente leerExpediente (Long num) throws ExpedienteException;

}
