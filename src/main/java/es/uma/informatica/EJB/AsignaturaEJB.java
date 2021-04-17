package es.uma.informatica.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Exception.AsignaturaException;
import es.uma.informatica.Interfaces.InterfazAsignatura;

/**
 * Session Bean implementation class Asignatura
 */
@Stateless
public class AsignaturaEJB implements InterfazAsignatura {

	@PersistenceContext(name="Asignatura")
	private EntityManager em;

	@Override
	public void Importar_Asignatura(AsignaturaEJB asig) throws AsignaturaException {
		// TODO Auto-generated method stub
		
	}

}
