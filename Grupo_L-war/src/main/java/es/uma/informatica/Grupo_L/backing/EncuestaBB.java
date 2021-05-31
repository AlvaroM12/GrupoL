package es.uma.informatica.Grupo_L.backing;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Interfaces.InterfazEncuesta;

@Named(value = "encuesta")
@RequestScoped
public class EncuestaBB {

	@Inject
	private InfoSesion infosesion;
	@Inject
	private InterfazEncuesta encuesta;
	
	private Encuesta e;
	
	public EncuestaBB() {
		
	}

	public Encuesta getE() {
		return e;
	}

	public void setE(Encuesta e) {
		this.e = e;
	}
	
	//METODO PARA LEER LA ENCUESTA DESDE ALUMNO
	public List<Encuesta> getEncuesta()
    {
		List<Encuesta> encuestas = new ArrayList<Encuesta>();
		try {
			encuestas = encuesta.leerEncuestasAlumno(infosesion.getAlumno());
		} catch (EncuestaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encuestas;
		
		
		
		/*List<Encuesta> encuesta = new ArrayList<Encuesta>();
        for (Expediente e : infosesion.getAlumno().getExpedientes()) {	
        	for (Encuesta encuesta2 : e.getEncuestas()) {
				encuesta.add(encuesta2);
			}
        						
		}
        return encuesta;*/
    }

	//METODO PARA LEER LAS ENCUESTAS DESDE SECRETARIA
	public List<Encuesta> getEncuestas(){
		
		try {
			return encuesta.leerEncuestas();
		} catch (EncuestaException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
