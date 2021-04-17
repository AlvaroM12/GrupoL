package es.uma.informatica.EJB;

import javax.ejb.Stateless;

import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Interfaces.InterfazEncuesta;

/**
 * Session Bean implementation class Encuesta
 */
@Stateless
public class Encuesta implements InterfazEncuesta {

    /**
     * Default constructor. 
     */
    public Encuesta() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Responder_Encuesta(Encuesta e) throws EncuestaException {
		// TODO Auto-generated method stub
		
	}

}
