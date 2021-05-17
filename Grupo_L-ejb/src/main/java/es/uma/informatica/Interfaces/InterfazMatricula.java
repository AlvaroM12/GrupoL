package es.uma.informatica.Interfaces;

import es.uma.informatica.Entidades.Matrícula;
import es.uma.informatica.Entidades.Matrícula.MatriculaId;
import es.uma.informatica.Exception.MatriculaException;

public interface InterfazMatricula {
	/**
	  Este método debe importar una matricula en la base de datos.
	 
	 */
	public void importarMatricula() throws MatriculaException;

	Matrícula leerMatricula(MatriculaId ma) throws MatriculaException;
	
}
