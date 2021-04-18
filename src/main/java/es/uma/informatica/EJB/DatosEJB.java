package es.uma.informatica.EJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class DatosEJB
 */
@Stateless
@LocalBean
public class DatosEJB {
	
	@PersistenceContext(name="Datos")
	private EntityManager em;

	public void Exportar_datos() {
		
	}
}