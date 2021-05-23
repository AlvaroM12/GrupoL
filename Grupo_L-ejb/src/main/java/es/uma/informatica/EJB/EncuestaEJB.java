package es.uma.informatica.EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Entidades.Encuesta.EncuestaId;
import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Exception.EncuestaExistenteException;
import es.uma.informatica.Interfaces.InterfazEncuesta;

/**
 * Session Bean implementation class Encuesta
 */
@Stateless
public class EncuestaEJB implements InterfazEncuesta {

	@PersistenceContext(name="Grupo_L")
	private EntityManager em;

	@Override

	public void responderEncuesta(String campos, Encuesta e) throws EncuestaException {
		
		Long Fecha=e.getFecha_De_Envio();
		Long ne=e.getEE().getNum_Expediente();
		EncuestaId ei = new EncuestaId(ne, Fecha);
		Encuesta en = em.find(Encuesta.class, ei);		
		if(en == null){
			throw new EncuestaExistenteException("No existe ninguna encuesta");
		}
	}
	
	public Encuesta leerEncuesta(EncuestaId id) throws EncuestaException {
		Encuesta e = em.find(Encuesta.class, id );
		if(e==null) {
			throw new EncuestaException();
		}
		return e;
		
	}
	
	 @Override
	    public List<Encuesta> leerEncuestas() throws EncuestaException{
	    	
	    	TypedQuery <Encuesta> query = em.createQuery("SELECT a FROM Encuesta a ", Encuesta.class);
	    	List<Encuesta> list = query.getResultList();
			
			return list;    	
	    }
}