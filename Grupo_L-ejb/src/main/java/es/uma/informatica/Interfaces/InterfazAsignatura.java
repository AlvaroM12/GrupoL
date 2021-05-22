package es.uma.informatica.Interfaces;


import javax.ejb.Local;

import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Exception.AsignaturaException;


@Local
public interface InterfazAsignatura {
	/**
	  Este método debe importar una asignatura en la base de datos.
	  
	 */
	public void importarAsignatura() throws AsignaturaException;
	
	public Asignatura leerAsignatura(Long ref) throws AsignaturaException;
}
