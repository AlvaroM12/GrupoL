package es.uma.informatica.Interfaces;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.Entidades.Matrícula;
import es.uma.informatica.Entidades.Matrícula.MatriculaId;
import es.uma.informatica.Exception.MatriculaException;
@Local
public interface InterfazMatricula {
	/**
	  Este método debe importar una matricula en la base de datos.
	 
	 */
	public void importarMatricula() throws MatriculaException;

	public Matrícula leerMatricula(MatriculaId ma) throws MatriculaException;

	public List<Matrícula> leerMatriculas() throws MatriculaException;
	
}
