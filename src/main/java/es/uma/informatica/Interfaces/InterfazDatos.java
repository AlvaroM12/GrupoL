package es.uma.informatica.Interfaces;

import es.uma.informatica.Entidades.GruposPorAsignatura;

public interface InterfazDatos {
	/**
	  Este método debe exportar los datos de los grupos por asignatura de la base de datos.
	  En caso de que no haya datos para exportar, se lanza la excepción DatosExistenteException.
	 */
	public void Exportar_datos(GruposPorAsignatura gpa);
}
