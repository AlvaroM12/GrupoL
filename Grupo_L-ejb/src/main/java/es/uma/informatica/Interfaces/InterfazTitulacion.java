package es.uma.informatica.Interfaces;

import java.io.File;
import java.util.List;
import javax.ejb.Local;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.TitulacionException;
@Local
public interface InterfazTitulacion {
	/**
	  Este método debe consultar una titulacion en la base de datos.
	  En caso de que la titulacion sea null, se lanza la excepción TitulacionNullException.
	 */
	public Titulacion consultarTitulacion(Long codigo) throws TitulacionException;
	/**
	  Este método debe importar una titulacion en la base de datos.

	 */
	Titulacion leerTitulacion(Long cod) throws TitulacionException;
	public List<Titulacion> leerTitulaciones() throws TitulacionException;
	void importarTitulacion(File fichero) throws TitulacionException;
	public List<Titulacion> leerTitulacionesAlumno(Alumno a) throws TitulacionException;
	
}
