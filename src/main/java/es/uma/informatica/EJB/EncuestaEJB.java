package es.uma.informatica.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Exception.EncuestaErrorException;
import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Exception.EncuestaExistenteException;
import es.uma.informatica.Exception.EncuestaNullException;
import es.uma.informatica.Exception.GrupoErrorException;
import es.uma.informatica.Exception.GrupoNullException;
import es.uma.informatica.Interfaces.InterfazEncuesta;

/**
 * Session Bean implementation class Encuesta
 */
@Stateless
public class EncuestaEJB implements InterfazEncuesta {

	@PersistenceContext(name="Encuesta")
	private EntityManager em;

	@Override
	public void responderEncuesta(String campos, Encuesta e) throws EncuestaException {
		
		Encuesta en = em.find(Encuesta.class, e.getFecha_De_Envío());
		
		if(en == null){
			throw new EncuestaExistenteException("No existe ninguna encuesta");
		}
		//suponemos que la encuesta se responde con texto
		if(campos == null) {
            throw new EncuestaNullException();
        }
        if(campos.length() < 75){
            throw new EncuestaErrorException();
        }
        
        //suponiendo que se elige una opcion ¿como seria?
	}
}

