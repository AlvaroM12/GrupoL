package es.uma.informatica.EJB;

import javax.ejb.Stateless;

import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazTitulacion;

/**
 * Session Bean implementation class Titulacion
 */
@Stateless
public class Titulacion implements InterfazTitulacion{

    /**
     * Default constructor. 
     */
    public Titulacion() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Consultar_Titulacion(es.uma.informatica.Entidades.Titulacion t) throws TitulacionException {
		// TODO Auto-generated method stub
		
	}

}
