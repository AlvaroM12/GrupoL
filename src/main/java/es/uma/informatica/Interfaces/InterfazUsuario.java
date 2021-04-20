package es.uma.informatica.Interfaces;

import es.uma.informatica.Entidades.*;
import es.uma.informatica.Exception.UsuarioException;
import es.uma.informatica.Exception.UsuarioExistenteException;
import es.uma.informatica.Exception.UsuarioNullException;

public interface InterfazUsuario {
	/**
	  Este método registra un usuario de la base de datos.
	  En caso de que el usuario no existiese, se lanza la excepción UsuarioExistenteException.
	 */
	public void crearUsuario(Usuario u) throws UsuarioException;
	
	
	public Usuario leerUsuario(Long num) throws UsuarioException;
	/**
	  Este método valida el acceso de un usuario en la plataforma.
	  En caso de que el usuario no existiese, se lanza la excepción UsuarioExistenteException.
	  En caso de que la contraseña sea incorrecto, se lanza la excepción UsuarioErrorException.

	 * @throws UsuarioExistenteException 
	 */
	public void validarAcceso(String email, String pass) throws UsuarioException;
	

	/**
	  Este método solicita una recuperacion de contraseña de un usuario de la plataforma.
	  En caso de que el email no existiese, se lanza la excepción UsuarioExistenteException.
	  En caso de que el email sea incorrecto, se lanza la excepción UsuarioErrorException.
	  En caso de que el email sea null, se lanza la excepción UsuarioNullException.
	 * @throws UsuarioExistenteException 
	 * @throws UsuarioNullException 
	 */
	public void solicitarRecuperarContraseña(String email) throws UsuarioException;

	/**
	  Este método genera una nueva contraseña para un usuario en la plataforma.
	  En caso de que haya la contraseña coincida con la anterior, se lanza la excepción UsuarioErrorException.
	  En caso de que haya la contraseña sea incorrecto, se lanza la excepción UsuarioErrorException.
	  En caso de que la contraseña sea null, se lanza la excepción UsuarioNullException.
	 * @throws UsuarioNullException 
	 */
	public void generarNuevaContraseña(Usuario u, String contraseña) throws UsuarioException;
}
