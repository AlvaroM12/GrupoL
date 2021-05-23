package es.uma.informatica.Grupo_L.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Entidades.Centro;
import es.uma.informatica.Exception.CentroException;
import es.uma.informatica.Interfaces.InterfazCentro;

@Named
@RequestScoped
public class CentroBB {

	@Inject
	private InterfazCentro centro;
	
	
	public CentroBB() {
		
	}

	//METODO PARA LEER TODAS LOS CENTROS(S)
	public  synchronized List<Centro> getCentro(){
		
		try {
			return centro.leerCentros();
		} catch (CentroException e) {
			e.printStackTrace();
		}
		return null;
	}
}
