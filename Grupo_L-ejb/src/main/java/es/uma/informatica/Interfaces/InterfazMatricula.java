package es.uma.informatica.Interfaces;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.Entidades.Matricula;
import es.uma.informatica.Entidades.Matricula.MatriculaId;
import es.uma.informatica.Exception.MatriculaException;
@Local
public interface InterfazMatricula {
	/**
	  Este método debe importar una matricula en la base de datos.
	 
	 */
	public void importarMatricula() throws MatriculaException;

	public Matricula leerMatricula(MatriculaId ma) throws MatriculaException;

	public List<Matricula> leerMatriculas() throws MatriculaException;
	
}
