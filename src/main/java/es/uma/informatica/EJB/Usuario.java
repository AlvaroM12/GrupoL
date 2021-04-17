package es.uma.informatica.EJB;

import javax.ejb.Stateless;

import es.uma.informatica.Exception.UsuarioException;
import es.uma.informatica.Interfaces.InterfazUsuario;

/**
 * Session Bean implementation class Usuario
 */
@Stateless
public class Usuario implements InterfazUsuario{

    /**
     * Default constructor. 
     */
    public Usuario() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Registrar_Usuario(Usuario u) throws UsuarioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Validar_Acceso(Usuario u) throws UsuarioException {
		// TODO Auto-generated method stub
		
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
