package es.uma.informatica.EJB;

import javax.ejb.Stateless;

import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazMatricula;

/**
 * Session Bean implementation class Matrícula
 */
@Stateless
public class Matricula implements InterfazMatricula {

    /**
     * Default constructor. 
     */
    public Matricula() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Importar_Matricula(Matricula m) throws MatriculaException {
		// TODO Auto-generated method stub
		
	}

}
