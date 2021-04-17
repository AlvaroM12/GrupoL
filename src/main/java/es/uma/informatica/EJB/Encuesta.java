package es.uma.informatica.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Interfaces.InterfazEncuesta;

/**
 * Session Bean implementation class Encuesta
 */
@Stateless
public class Encuesta implements InterfazEncuesta {

	@PersistenceContext(name="Encuesta")
	private EntityManager em;

	@Override
	public void Responder_Encuesta(Encuesta e) throws EncuestaException {
		// TODO Auto-generated method stub
		
	}

}
