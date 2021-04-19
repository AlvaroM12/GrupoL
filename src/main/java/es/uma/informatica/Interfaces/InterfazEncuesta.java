package es.uma.informatica.Interfaces;

import es.uma.informatica.EJB.EncuestaEJB;
import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Exception.EncuestaException;

public interface InterfazEncuesta {

	/**
	  Este método debe responder una encuesta.
	  En caso de que la encuesta no existiese, se lanza la excepción EncuestaExistenteException.
	  En caso de que haya alguna respuesta incorrecta, se lanza la excepción EncuestaErrorException.
	  En caso de que algun campo de la encuesta sea null, se lanza la excepción EncuestaNullException.
	 */
	public void responderEncuesta(Encuesta e)throws EncuestaException;
}
