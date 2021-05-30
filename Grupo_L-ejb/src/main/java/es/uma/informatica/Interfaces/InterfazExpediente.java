package es.uma.informatica.Interfaces;

import java.util.List;
import javax.ejb.Local;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Exception.ExpedienteException;
@Local
public interface InterfazExpediente {
	/**
	  Este método debe importar un expediente en la base de datos.
	 * @param path 
	 
	 */
	public void importarExpediente(String path) throws ExpedienteException;
	
	public Expediente leerExpediente (Long num) throws ExpedienteException;

	public List<Expediente> leerExpedientes() throws ExpedienteException;

	

}
