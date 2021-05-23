package es.uma.informatica.Interfaces;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Entidades.Encuesta.EncuestaId;
import es.uma.informatica.Exception.EncuestaException;
@Local
public interface InterfazEncuesta {

	/**
	  Este método debe responder una encuesta.
	  En caso de que la encuesta no existiese, se lanza la excepción EncuestaExistenteException.
	  
	  
	 */
	public void responderEncuesta(String campos, Encuesta e)throws EncuestaException;
	
	
	public Encuesta leerEncuesta(EncuestaId id) throws EncuestaException;


	public List<Encuesta> leerEncuestas() throws EncuestaException;
}

