package es.uma.informatica.Interfaces;

import javax.ejb.Local;

import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Exception.ExpedienteException;
@Local
public interface InterfazExpediente {
	/**
	  Este método debe importar un expediente en la base de datos.
	 
	 */
	public void importarExpediente() throws ExpedienteException;
	
	public Expediente leerExpediente (Long num) throws ExpedienteException;

}
