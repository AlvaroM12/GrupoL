package es.uma.informatica.Interfaces;

import java.util.List;
import javax.ejb.Local;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Asignaturas_Matricula;
import es.uma.informatica.Entidades.Asignaturas_Matricula.Asignaturas_MatriculaId;
import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.PlazasException;
import es.uma.informatica.Exception.TitulacionException;
@Local
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
	public Grupo leerGrupo(Long ID) throws GrupoException ;
	
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
	public void eliminarGrupo(Grupo g) throws GrupoException;
	
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
	public void solicitarGrupo(Grupo g, Alumno a) throws GrupoException;

	/**
	  Este método asigna solicitar un grupo entre los existentes.
	  En caso de que el grupo no haya plazas, se lanza la excepción PlazasException.
	 * @throws PlazasException 
	 */

	public Asignaturas_Matricula leerGrupoAsignatura(Asignaturas_MatriculaId a) throws GrupoException;

	public void asignarGrupo(Alumno a) throws GrupoException;

	public List<Asignaturas_Matricula> leerAsignaturasMatricula() throws GrupoException;

	public List<Grupo> leerGrupos() throws GrupoException;

	public List<String> leerLetraGrupo(Long curso, Titulacion t) throws GrupoException;

	public List<Asignaturas_Matricula> leerAsigMatriculaAlumno(Alumno al) throws GrupoException;

	public List<Long> leerCursosTitulacion(Titulacion t) throws GrupoException;

	public void asignaGrupo(Alumno al, Grupo g, Asignatura a, Titulacion t) throws GrupoException;

	

	

	
}
