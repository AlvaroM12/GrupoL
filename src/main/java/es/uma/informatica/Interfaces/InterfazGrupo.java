package es.uma.informatica.Interfaces;

import es.uma.informatica.EJB.GrupoEJB;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Entidades.Usuario;
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
	  En caso de que la causa supere el número de carácteres permitidos, se lanza la excepción GrupoErrorException.
	  En caso de que la causa, grupo, asignatura o alumno sea null, se lanza la excepción GrupoNullException. 
	  En caso de que la Asignatura no pertenezca al grupo indicado, se lanza la excepción GrupoAsigErrorException.
	 * @throws GrupoException 
	 */
	public void solicitarCambioGrupo(String causa, Grupo g, Alumno al, Asignatura a) throws GrupoException;

	/**
	  Este método debe permite solicitar un grupo entre los existentes.
	  En caso de que el grupo sea null, se lanza la excepción GrupoNullException.
	 */
<<<<<<< HEAD
	public void solicitarGrupo(Grupo g, Alumno a) throws GrupoException;
=======
	public void solicitarGrupo(Grupo g) throws GrupoException;
>>>>>>> branch 'EJB' of https://github.com/AlvaroM12/GrupoL.git

	/**
	  Este método asigna solicitar un grupo entre los existentes.
	 * @throws PlazasException 
	 */
<<<<<<< HEAD
	public void asignarGrupo(Grupo g, Alumno a) throws GrupoException;
=======
	public void asignarGrupo(Grupo g) throws GrupoException;
>>>>>>> branch 'EJB' of https://github.com/AlvaroM12/GrupoL.git
}
