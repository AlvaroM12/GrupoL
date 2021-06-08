package es.uma.informatica.Grupo_L.backing;

import java.util.ArrayList;
import java.util.Date;
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
import es.uma.informatica.Interfaces.InterfazTitulacion;

@Named(value = "encuesta")
@RequestScoped
public class EncuestaBB {

	@Inject
	private InfoSesion infosesion;
	@Inject
	private InterfazEncuesta encuesta;	
	@Inject
	private InterfazGrupo grupo;
	@Inject 
	private InterfazTitulacion titulacion;
	
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

	public List<String> getLetraPrimero() {

		try {
			return grupo.leerLetraGrupo((long)1, titulacion.leerTitulacion((long)1041));
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
			return grupo.leerLetraGrupo((long)2, titulacion.leerTitulacion((long)1041));
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
			return grupo.leerLetraGrupo((long)3, titulacion.leerTitulacion((long)1041));
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
			return grupo.leerLetraGrupo((long)4, titulacion.leerTitulacion((long)1041));
		} catch (GrupoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TitulacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	
	public String atras() {

        return "Principal.xhtml";

    }
	
	public String aceptarEncuesta() {
		
		try {
			Expediente exp = encuesta.obtenerExpTitu(titulacion.leerTitulacion((long)1041), infosesion.getAlumno());
			Date fecha = new Date();
			encuesta.crearEncuesta(fecha,exp);
		} catch (TitulacionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (EncuestaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "LeerEncuesta.xhtml";
		
			
	}

}