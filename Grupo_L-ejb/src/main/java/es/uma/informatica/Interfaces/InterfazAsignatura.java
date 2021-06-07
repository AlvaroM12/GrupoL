package es.uma.informatica.Interfaces;


import java.io.File;
import java.util.List;
import javax.ejb.Local;
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.AsignaturaException;


@Local
public interface InterfazAsignatura {
	/**
	  Este método debe importar una asignatura en la base de datos.
	  
	 */
	
	public Asignatura leerAsignatura(Long ref) throws AsignaturaException;

	public List<Asignatura> leerAsignaturas();

	void eliminarAsignatura(Long ref) throws AsignaturaException;

	void importarAsignatura(File fichero) throws AsignaturaException;

	public List<Asignatura> leerAsignaturasTitulacion(Titulacion t);

	public List<Asignatura> leerAsignaturas(Long curso, Titulacion t) throws AsignaturaException;

	
}
