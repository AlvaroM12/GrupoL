package es.uma.informatica.EJB;

import javax.ejb.Stateless;

import es.uma.informatica.Exception.AsignaturaException;
import es.uma.informatica.Interfaces.InterfazAsignatura;

/**
 * Session Bean implementation class Asignatura
 */
@Stateless
public class Asignatura implements InterfazAsignatura {

    /**
     * Default constructor. 
     */
    public Asignatura() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Importar_Asignatura(Asignatura asig) throws AsignaturaException {
		// TODO Auto-generated method stub
		
	}

}
