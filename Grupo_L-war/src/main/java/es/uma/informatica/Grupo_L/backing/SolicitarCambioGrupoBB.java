package es.uma.informatica.Grupo_L.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.AsignaturaException;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Interfaces.InterfazAsignatura;
import es.uma.informatica.Interfaces.InterfazGrupo;
import es.uma.informatica.Interfaces.InterfazTitulacion;

@Named (value="solicitar")
@ViewScoped
public class SolicitarCambioGrupoBB implements Serializable {
	
	private static final Logger LOGGER = Logger.getLogger(Titulacion.class.getName());
	
	private Long t;
	private Long curso;	
	private String letra;
	private Asignatura asig;
	
	@Inject
	private InterfazGrupo interfazGrupo;		
	@Inject
	private InterfazTitulacion interfazTitulacion;
	@Inject
	private InterfazAsignatura interfazAsignatura;
	@Inject
	private InfoSesion infosesion;
		
	

	public Long getT() {
		return t;
	}
	
	public void setT(Long t) {
		this.t = t;
	}
	
	
	public List<Titulacion> getTodasTitulaciones(){
		try {
			return interfazTitulacion.leerTitulaciones();
		} catch (TitulacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Long getCurso() {
		return curso;
	}

	public void setCurso(Long curso) {
		this.curso = curso;
	}
	
	
	public List<Long> getCursos(){
		if(t==null) {
			return null;
		}else {
			try {
				return interfazGrupo.leerCursosTitulacion(interfazTitulacion.leerTitulacion(t));
			} catch (GrupoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TitulacionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		return null;				
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}
	
	public List<String> getLetras(){
		if(t==null && curso==null) {
			return null;
		}else {			
			try {
				return interfazGrupo.leerLetraGrupo(curso, interfazTitulacion.leerTitulacion(t));
			} catch (GrupoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TitulacionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return null;				
	}

	public Asignatura getAsig() {
		return asig;
	}

	public void setAsig(Asignatura asig) {
		this.asig = asig;
	}
	
	
	public List<Asignatura> getAsignaturas(){
		if(t==null && curso==null && letra==null) {
			return null;
		}else {			
			try {
				return interfazAsignatura.leerAsignaturas(curso, interfazTitulacion.leerTitulacion(t));
			} catch (AsignaturaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TitulacionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
		}
		return null;					
	}
	
	public String asigna() {
		try {
			LOGGER.info("He entrado");
			interfazGrupo.asignaGrupo(infosesion.getAlumno(), interfazGrupo.buscarGrupo(curso, letra,interfazTitulacion.leerTitulacion(t)), asig, interfazTitulacion.leerTitulacion(t));
		} catch (GrupoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TitulacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Principal.xhtml";
		
	}

}
