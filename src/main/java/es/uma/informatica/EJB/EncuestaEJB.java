package es.uma.informatica.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Exception.EncuestaExistenteException;
import es.uma.informatica.Interfaces.InterfazEncuesta;

/**
 * Session Bean implementation class Encuesta
 */
@Stateless
public class EncuestaEJB implements InterfazEncuesta {

	@PersistenceContext(name="Encuesta")
	private EntityManager em;

	@Override
	public void Responder_Encuesta(Encuesta e) throws EncuestaException {
		if(e == null){
			throw new EncuestaExistenteException("No existe ninguna encuesta");
		}
		
		Encuesta en = em.find(Encuesta.class, e.getFecha_De_Envío());
		
		if(en == null){
			throw new EncuestaExistenteException("No existe ninguna encuesta");
		}
		
		
	}

}
