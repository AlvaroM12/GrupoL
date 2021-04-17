package es.uma.informatica.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Interfaces.InterfazExpediente;

/**
 * Session Bean implementation class Expediente
 */
@Stateless
public class ExpedienteEJB implements InterfazExpediente {

	@PersistenceContext(name="Expediente")
	private EntityManager em;

	@Override
	public void Importar_Expediente(ExpedienteEJB exp) throws ExpedienteException {
		// TODO Auto-generated method stub
		
	}

}
