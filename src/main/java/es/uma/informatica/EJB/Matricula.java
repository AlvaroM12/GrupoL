package es.uma.informatica.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazMatricula;

/**
 * Session Bean implementation class Matrícula
 */
@Stateless
public class Matricula implements InterfazMatricula {
	
	@PersistenceContext(name="Matricula")
	private EntityManager em;

	@Override
	public void Importar_Matricula(Matricula m) throws MatriculaException {
		
		
	}

}
