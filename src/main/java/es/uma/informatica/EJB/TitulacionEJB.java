package es.uma.informatica.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.AlumnoNullException;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Exception.TitulacionNullException;
import es.uma.informatica.Interfaces.InterfazTitulacion;

/**
 * Session Bean implementation class Titulacion
 */
@Stateless
public class TitulacionEJB implements InterfazTitulacion{

	@PersistenceContext(name="Titilación")
	private EntityManager em;

	@Override
	public void Consultar_Titulacion(Titulacion t) throws TitulacionException {
		// TODO Auto-generated method stub
		Titulacion ti=em.find(Titulacion.class,  t.getNombre() );
		if(ti==null) {
			throw new TitulacionNullException();
		}
	}

}
