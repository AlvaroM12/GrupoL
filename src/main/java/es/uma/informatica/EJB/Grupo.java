package es.uma.informatica.EJB;

import javax.ejb.Stateless;

import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Interfaces.InterfazGrupo;

/**
 * Session Bean implementation class Grupo
 */
@Stateless
public class Grupo implements InterfazGrupo {

    /**
     * Default constructor. 
     */
    public Grupo() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Crear_Grupo(Grupo g) throws GrupoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Leer_Grupo(Grupo g) throws GrupoException {
		// TODO Auto-generated method stub
		
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
	public void Solicitar_Cambio_Grupo(String causa, Grupo g) throws GrupoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Solicitar_Grupo(Grupo g) throws GrupoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Asignar_Grupo(Grupo g) throws GrupoException {
		// TODO Auto-generated method stub
		
	}

}
