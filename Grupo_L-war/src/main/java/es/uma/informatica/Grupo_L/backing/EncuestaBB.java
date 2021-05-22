package es.uma.informatica.Grupo_L.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Interfaces.InterfazEncuesta;

@Named
@RequestScoped
public class EncuestaBB {

	@Inject
	private InterfazEncuesta encuesta;
	
	
	public EncuestaBB() {
		
	}

	//METODO PARA LEER TODAS LAS ENCUESTAS(A)
	public  synchronized List<Encuesta> getEncuesta(){
		
		try {
			return encuesta.leerEncuestas();
		} catch (EncuestaException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
