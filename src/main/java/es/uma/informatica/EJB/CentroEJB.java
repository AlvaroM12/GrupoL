package es.uma.informatica.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Exception.CentroException;
import es.uma.informatica.Interfaces.InterfazCentro;

/**
 * Session Bean implementation class Centro
 */
@Stateless
public class CentroEJB implements InterfazCentro {
	
	@PersistenceContext(name="Centro")
	private EntityManager em;

	@Override
	public void Consultar_Centro(CentroEJB c) throws CentroException {
		// TODO Auto-generated method stub
		
	}

}
