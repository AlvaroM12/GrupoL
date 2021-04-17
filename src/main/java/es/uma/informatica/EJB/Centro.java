package es.uma.informatica.EJB;

import javax.ejb.Stateless;

import es.uma.informatica.Exception.CentroException;
import es.uma.informatica.Interfaces.InterfazCentro;

/**
 * Session Bean implementation class Centro
 */
@Stateless
public class Centro implements InterfazCentro {

    /**
     * Default constructor. 
     */
    public Centro() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Consultar_Centro(Centro c) throws CentroException {
		// TODO Auto-generated method stub
		
	}

}
