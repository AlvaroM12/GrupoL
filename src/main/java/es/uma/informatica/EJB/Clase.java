package es.uma.informatica.EJB;

import java.util.Date;

import javax.ejb.Stateless;

import es.uma.informatica.Exception.ClaseException;
import es.uma.informatica.Interfaces.InterfazClase;

/**
 * Session Bean implementation class Clase
 */
@Stateless
public class Clase implements InterfazClase{

    /**
     * Default constructor. 
     */
    public Clase() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Importar_Horario(Date horario) throws ClaseException {
		// TODO Auto-generated method stub
		
	}

}
