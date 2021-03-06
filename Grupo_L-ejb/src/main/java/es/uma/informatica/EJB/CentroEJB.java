package es.uma.informatica.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import es.uma.informatica.Entidades.Centro;
import es.uma.informatica.Exception.CentroException;
import es.uma.informatica.Exception.CentroNullException;
import es.uma.informatica.Interfaces.InterfazCentro;

/**
 * Session Bean implementation class Centro
 */
@Stateless
public class CentroEJB implements InterfazCentro {
	
	@PersistenceContext(name="Grupo_L")
	private EntityManager em;

	@Override
	public Centro ConsultarCentro(Long id) throws CentroException {
		Centro ce = em.find(Centro.class, id);
		if(ce==null) {
			throw new CentroNullException();
		}		
		return ce;
	}
	
	 @Override
	    public List<Centro> leerCentros() throws CentroException{
	    	
	    	TypedQuery <Centro> query = em.createQuery("SELECT a FROM Centro a ", Centro.class);
	    	List<Centro> list = query.getResultList();
			
			return list;    	
	    }
}