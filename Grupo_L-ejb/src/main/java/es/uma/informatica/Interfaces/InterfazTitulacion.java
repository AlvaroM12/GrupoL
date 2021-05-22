package es.uma.informatica.Interfaces;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.Entidades.Asignaturas_Matrícula;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.GrupoException;
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
	public void importarTitulacion() throws TitulacionException;
	Titulacion leerTitulacion(Long cod) throws TitulacionException;
	public List<Titulacion> leerTitulaciones() throws TitulacionException;
}
