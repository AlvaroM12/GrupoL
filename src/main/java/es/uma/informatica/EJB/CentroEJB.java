package es.uma.informatica.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Entidades.Centro;
import es.uma.informatica.Exception.CentroException;
import es.uma.informatica.Exception.CentroNullException;
import es.uma.informatica.Interfaces.InterfazCentro;

/**
 * Session Bean implementation class Centro
 */
@Stateless
public class CentroEJB implements InterfazCentro {
	
	@PersistenceContext(name="Centro")
	private EntityManager em;

	@Override
	public void ConsultarCentro(Centro c) throws CentroException {
		Centro ce = em.find(Centro.class,c.getNombre());
		if(ce==null) {
			throw new CentroNullException();
		}
	}

}