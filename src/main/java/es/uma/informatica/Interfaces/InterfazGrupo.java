package es.uma.informatica.Interfaces;

import es.uma.informatica.EJB.GrupoEJB;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.GrupoErrorException;
import es.uma.informatica.Exception.GrupoNullException;
import es.uma.informatica.Exception.PlazasException;

public interface InterfazGrupo {
	
	/**
	  Este método debe crear un grupo en la base de datos.
	  En caso de que el grupo ya estuviera creado se lanza la excepción GrupoExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción GrupoErrorException.
	  En caso de que el grupo sea null, se lanza la excepción GrupoNullException.
	 */
	public void crearGrupo(Grupo g) throws GrupoException;
	
	/**
	  Este método debe leer un grupo de la base de datos.
	  En caso de que el grupo no existiese, se lanza la excepción GrupoExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción GrupoErrorException.
	  En caso de que el grupo sea null, se lanza la excepción GrupoNullException.
	 */
	public Grupo leerGrupo(Grupo g) throws GrupoException;
	
	 /**
	  Este método debe actualizar un grupo de la base de datos.
	  En caso de que el grupo no existiese, se lanza la excepción GrupoExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción GrupoErrorException.
	  En caso de que el grupo sea null, se lanza la excepción GrupoNullException.
	 */
	public void actualizarGrupo(Grupo g) throws GrupoException;
	
	/**
	  Este método debe eliminar un grupo de la base de datos.
	  En caso de que el grupo no existiese, se lanza la excepción GrupoExistenteException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción GrupoErrorException.
	  En caso de que el grupo sea null, se lanza la excepción GrupoNullException.
	 */
	public void eliminarGrupo(Grupo g, Alumno a) throws GrupoException;
	
	/**
	  Este método debe permite solicitar un cambio de grupo.
	  En caso de que no haya plaza, se lanza la excepción PlazasException.
	  En caso de que haya algun dato incorrecto, se lanza la excepción GrupoErrorException.
	  En caso de que el campo sea null, se lanza la excepción GrupoNullException. 
	 * @throws GrupoException 
	 */
	public void solicitarCambioGrupo(String causa, Grupo g, Alumno al, Asignatura a) throws GrupoException;

	/**
	  Este método debe permite solicitar un grupo entre los existentes.
	 */
	public void solicitarGrupo(Grupo g) throws GrupoException;

	/**
	  Este método asigna solicitar un grupo entre los existentes.
	 * @throws PlazasException 
	 */
	public void asignarGrupo(Grupo g) throws GrupoException;
}
