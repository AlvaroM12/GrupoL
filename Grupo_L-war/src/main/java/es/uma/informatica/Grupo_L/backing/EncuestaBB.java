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
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazEncuesta;
import es.uma.informatica.Interfaces.InterfazGrupo;

@Named(value = "encuesta")
@RequestScoped
public class EncuestaBB {

	@Inject
	private InfoSesion infosesion;
	@Inject
	private InterfazEncuesta encuesta;	
	@Inject
	private InterfazGrupo grupo;
	
	private Encuesta e;
	
	private String letra;
	
	public EncuestaBB() {
		
	}

	public Encuesta getE() {
		return e;
	}

	public void setE(Encuesta e) {
		this.e = e;
	}
	
	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	//METODO PARA LEER LAS ENCUESTA DE UN ALUMNO
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
	}

	//METODO PARA LEER TODAS LAS ENCUESTAS
	public List<Encuesta> getEncuestas(){

		try {
			return encuesta.leerEncuestas();
		} catch (EncuestaException e) {
			e.printStackTrace();
		}
		return null;
	}
/*
	public List<String> getLetraPrimero() {

		try {
			return grupo.leerLetraGrupo((long)1, (long)1703);
		} catch (GrupoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TitulacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	public List<String> getLetraSegundo() {

		try {
			return grupo.leerLetraGrupo((long)2, (long)1703);
		} catch (GrupoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TitulacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	public List<String> getLetraTercero() {

		try {
			return grupo.leerLetraGrupo((long)3, (long)1703);
		} catch (GrupoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TitulacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	public List<String> getLetraCuarto() {

		try {
			return grupo.leerLetraGrupo((long)4, (long)1703);
		} catch (GrupoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TitulacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
*/
}