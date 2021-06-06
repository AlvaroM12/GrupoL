package es.uma.informatica.Grupo_L.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazGrupo;
import es.uma.informatica.Interfaces.InterfazTitulacion;

@Named (value="solicitar")
@ViewScoped
public class SolicitarCambioGrupoBB implements Serializable {
	
	private Titulacion t;
	List<Titulacion> titulaciones;
	
	private Long curso;
	List<Long>cursos;
	
	@Inject
	private InterfazGrupo interfazGrupo;
	
	
	@Inject
	private InterfazTitulacion InterfazTitulacion;
	
	public SolicitarCambioGrupoBB() {
		
	}	
	
	
	public Titulacion getT() {
		return t;
	}



	public void setT(Titulacion t) {
		this.t = t;
	}



	public void setTitulaciones(List<Titulacion> titulaciones) {
		this.titulaciones = titulaciones;
	}

	
	public Long getCurso() {
		return curso;
	}


	public void setCurso(Long curso) {
		this.curso = curso;
	}

	public void setCursos(List<Long> cursos) {
		this.cursos = cursos;
	}


	public List<Titulacion> getTitulaciones(){
		try {
			titulaciones= InterfazTitulacion.leerTitulaciones();
		} catch (TitulacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titulaciones;
	}
	
	public List<Long> getCursos(){
		try {
			cursos = interfazGrupo.leerCursosTitulacion(t);
		} catch (GrupoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return cursos;		
	}
	

}
