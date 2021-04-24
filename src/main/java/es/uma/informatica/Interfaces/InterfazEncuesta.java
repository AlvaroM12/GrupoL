package es.uma.informatica.Interfaces;

import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Entidades.Encuesta.EncuestaId;
import es.uma.informatica.Exception.EncuestaException;

public interface InterfazEncuesta {

	/**
	  Este método debe responder una encuesta.
	  En caso de que la encuesta no existiese, se lanza la excepción EncuestaExistenteException.
	  
	  
	 */
	public void responderEncuesta(String campos, Encuesta e)throws EncuestaException;
	
	
	public Encuesta leerEncuesta(EncuestaId id) throws EncuestaException;
}

