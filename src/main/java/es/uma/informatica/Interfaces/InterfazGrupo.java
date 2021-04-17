package es.uma.informatica.Interfaces;

import es.uma.informatica.EJB.Grupo;
import es.uma.informatica.Exception.GrupoException;

public interface InterfazGrupo {
	
	/**
	  Este método debe crear un grupo en la base de datos.
	  En caso de que el grupo ya estuviera creado se lanza la excepción GrupoExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción GrupoErrorException.
	  En caso de que el grupo sea null, se lanza la excepción GrupoNullException.
	 */
	public void Crear_Grupo(Grupo g) throws GrupoException;
	
	/**
	  Este método debe leer un grupo de la base de datos.
	  En caso de que el grupo no existiese, se lanza la excepción GrupoExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción GrupoErrorException.
	  En caso de que el grupo sea null, se lanza la excepción GrupoNullException.
	 */
	public void Leer_Grupo(Grupo g) throws GrupoException;
	
	 /**
	  Este método debe actualizar un grupo de la base de datos.
	  En caso de que el grupo no existiese, se lanza la excepción GrupoExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción GrupoErrorException.
	  En caso de que el grupo sea null, se lanza la excepción GrupoNullException.
	 */
	public void Actualizar_Grupo(Grupo g) throws GrupoException;
	
	/**
	  Este método debe eliminar un grupo de la base de datos.
	  En caso de que el grupo no existiese, se lanza la excepción GrupoExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción GrupoErrorException.
	  En caso de que el grupo sea null, se lanza la excepción GrupoNullException.
	 */
	public void Eliminar_Grupo(Grupo g) throws GrupoException;
	
	/**
	  Este método debe permite solicitar un cambio de grupo.
	  En caso de que no haya plaza, se lanza la excepción PlazasException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción GrupoErrorException.
	  En caso de que el campo sea null, se lanza la excepción GrupoNullException.
	 */
	public void Solicitar_Cambio_Grupo(String causa, Grupo g) throws GrupoException;

	/**
	  Este método debe permite solicitar un grupo entre los existentes.
	 */
	public void Solicitar_Grupo(Grupo g) throws GrupoException;

	/**
	  Este método asigna solicitar un grupo entre los existentes.
	 */
	public void Asignar_Grupo(Grupo g) throws GrupoException;
}
