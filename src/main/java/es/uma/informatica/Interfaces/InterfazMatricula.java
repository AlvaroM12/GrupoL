package es.uma.informatica.Interfaces;

import es.uma.informatica.EJB.MatriculaEJB;
import es.uma.informatica.Exception.MatriculaException;

public interface InterfazMatricula {
	/**
	  Este método debe importar una matricula en la base de datos.
	  En caso de que la matricula no existiese, se lanza la excepción MatriculaExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción MatriculaErrorException.
	  En caso de que la matricula sea null, se lanza la excepción MatriculaNullException.
	 */
	public void Importar_Matricula(MatriculaEJB m) throws MatriculaException;
	
}
