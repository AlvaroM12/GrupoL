package es.uma.informatica.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Exception.UsuarioErrorException;
import es.uma.informatica.Exception.UsuarioException;
import es.uma.informatica.Exception.UsuarioExistenteException;
import es.uma.informatica.Exception.UsuarioNullException;
import es.uma.informatica.Interfaces.InterfazUsuario;
import es.uma.informatica.Entidades.*;

/**
 * Session Bean implementation class Usuario
 */
@Stateless
public class UsuarioEJB implements InterfazUsuario{

	@PersistenceContext(name="Usuario")
	private EntityManager em;

	@Override
	public void Registrar_Usuario(Usuario u) throws UsuarioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Validar_Acceso(Usuario u) throws UsuarioException, UsuarioExistenteException {
		// TODO Auto-generated method stub
		Usuario us = em.find(Usuario.class, u.getID());
        if(us == null) {
            throw new UsuarioExistenteException();
        }


		
	}

	@Override
	public void Iniciar_Sesión(String username, String contraseña) throws UsuarioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Cerrar_Sesión(Usuario u) throws UsuarioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Solicitar_Recuperar_Contraseña(String email) throws UsuarioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Generar_Nueva_Contraseña(String contraseña) throws UsuarioException {
		// TODO Auto-generated method stub
		
	}

}
