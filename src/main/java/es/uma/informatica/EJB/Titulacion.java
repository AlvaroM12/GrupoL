package es.uma.informatica.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazTitulacion;

/**
 * Session Bean implementation class Titulacion
 */
@Stateless
public class Titulacion implements InterfazTitulacion{

	@PersistenceContext(name="Titilación")
	private EntityManager em;

	@Override
	public void Consultar_Titulacion(es.uma.informatica.Entidades.Titulacion t) throws TitulacionException {
		// TODO Auto-generated method stub
		
	}

}
