package es.uma.informatica.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Exception.AlumnoErrorException;
import es.uma.informatica.Exception.AlumnoExistenteException;
import es.uma.informatica.Exception.GrupoErrorException;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.GrupoExistenteException;
import es.uma.informatica.Exception.GrupoNullException;
import es.uma.informatica.Exception.PlazasException;
import es.uma.informatica.Interfaces.InterfazGrupo;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Grupo;

/**
 * Session Bean implementation class Grupo
 */
@Stateless
public class GrupoEJB implements InterfazGrupo {
	
	@PersistenceContext(name="Grupo")
	private EntityManager em;

	@Override
	public void Crear_Grupo(Grupo g) throws GrupoException {
		Grupo grupoB = em.find(Grupo.class, g.getID());
		if(grupoB!=null) {
			//El grupo ya existe
			throw new GrupoExistenteException();
		}
		em.persist(g);		
	}

	@Override
	public void Leer_Grupo(Grupo g) throws GrupoException {
		// TODO Auto-generated method stub
		Grupo gr=em.find(Grupo.class,  g.getID());
		if(gr==null) {
			throw new GrupoErrorException();
		}
	}

	@Override
	public void Actualizar_Grupo(Grupo g) throws GrupoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Eliminar_Grupo(Grupo g) throws GrupoException {
		// TODO Auto-generated method stub
		
		
	}

	@Override
    public void Solicitar_Cambio_Grupo(String causa, Grupo g) throws GrupoException{
        if(causa == null) {
            throw new GrupoNullException();
        }
        if(causa.length() < 75){
            throw new GrupoErrorException();
        }
    }

    @Override
    public void Solicitar_Grupo(Grupo g) throws GrupoException {
        // TODO Auto-generated method stub

    }

    @Override
    public void Asignar_Grupo(Grupo g) throws GrupoException{
        Grupo grupoPref = em.find(Grupo.class, g.getID());
        if(grupoPref.getAsignar()==0){
            throw new PlazasException();
        }
        grupoPref.setAsignar(grupoPref.getAsignar()-1);
        Actualizar_Grupo(grupoPref);

    }

}
