package es.uma.informatica.EJB;

import javax.ejb.Stateless;

import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Interfaces.InterfazExpediente;

/**
 * Session Bean implementation class Expediente
 */
@Stateless
public class Expediente implements InterfazExpediente {

    /**
     * Default constructor. 
     */
    public Expediente() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Importar_Expediente(Expediente exp) throws ExpedienteException {
		// TODO Auto-generated method stub
		
	}

}
