package es.uma.informatica.Interfaces;

import es.uma.informatica.EJB.UsuarioEJB;
import es.uma.informatica.Entidades.*;
import es.uma.informatica.Exception.UsuarioException;
import es.uma.informatica.Exception.UsuarioExistenteException;
import es.uma.informatica.Exception.UsuarioNullException;

public interface InterfazUsuario {
	/**
	  Este método registra un usuario de la base de datos.
	  En caso de que el usuario no existiese, se lanza la excepción UsuarioExistenteException.
	 */
	public void Registrar_Usuario(Usuario u) throws UsuarioException;
	
	/**
	  Este método valida el acceso de un usuario en la plataforma.
	  En caso de que el usuario no existiese, se lanza la excepción UsuarioExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción UsuarioErrorException.
	  En caso de que algun campo sea null, se lanza la excepción UsuarioNullException.
	 * @throws UsuarioExistenteException 
	 */
	public void Validar_Acceso(Usuario u) throws UsuarioException;
	
	/**
	  Este método crea la sesión del usuario introducido.
	 */
	public void Iniciar_Sesión(String username, String contraseña) throws UsuarioException;
	
	/**
	  Este método cierra la sesión del usuario introducido.
	 */
	public void Cerrar_Sesión(Usuario u) throws UsuarioException;

	/**
	  Este método solicita una recuperacion de contraseña de un usuario de la plataforma.
	  En caso de que el email no existiese, se lanza la excepción UsuarioExistenteException.
	  En caso de que el email sea incorrecto, se lanza la excepción UsuarioErrorException.
	  En caso de que el email sea null, se lanza la excepción UsuarioNullException.
	 * @throws UsuarioExistenteException 
	 * @throws UsuarioNullException 
	 */
	public void Solicitar_Recuperar_Contraseña(String email) throws UsuarioException;

	/**
	  Este método genera una nueva contraseña para un usuario en la plataforma.
	  En caso de que haya la contraseña coincida con la anterior, se lanza la excepción UsuarioErrorException.
	  En caso de que haya la contraseña sea incorrecto, se lanza la excepción UsuarioErrorException.
	  En caso de que la contraseña sea null, se lanza la excepción UsuarioNullException.
	 * @throws UsuarioNullException 
	 */
	public void Generar_Nueva_Contraseña(String contraseña) throws UsuarioException;
}
