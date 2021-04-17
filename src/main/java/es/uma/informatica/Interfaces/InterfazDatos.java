package es.uma.informatica.Interfaces;

public interface InterfazDatos {
	/**
	  Este método debe exportar los datos de la base de datos.
	  En caso de que no haya datos para exportar, se lanza la excepción GeneralExistenteException.
	 */
	public void Exportar_datos();
}
