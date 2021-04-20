package es.uma.informatica.Entidades;


import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: GruposPorAsignatura
 *
 */
@Entity
@IdClass(GruposPorAsignatura.GruposPorAsignaturaId.class)
public class GruposPorAsignatura implements Serializable {
	
	public static class GruposPorAsignaturaId implements Serializable{
		private Long G_GPA;
		private Long Curso_Academico;
		private Long A_GPA;
	}	   

	@Id @GeneratedValue
	private Long Curso_Academico;
	private Long Oferta;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	private List<Encuesta> E_GPA;
	
	@Id
	@ManyToOne
	private Asignatura A_GPA;	
	
	@Id
	@ManyToOne
	private Grupo G_GPA;

	
	public GruposPorAsignatura(Long curso_Academico, Long oferta) {
		super();
		Curso_Academico = curso_Academico;
		Oferta = oferta;
		
	}
	public GruposPorAsignatura() {
		super();
	}   
	public Long getCurso_Academico() {
		return this.Curso_Academico;
	}

	public void setCurso_Academico(Long Curso_Academico) {
		this.Curso_Academico = Curso_Academico;
	}   
	public Long getOferta() {
		return this.Oferta;
	}

	public void setOferta(Long Oferta) {
		this.Oferta = Oferta;
	}
	
	public List<Encuesta> getE_GPA() {
		return E_GPA;
	}
	public void setE_GPA(List<Encuesta> e_GPA) {
		E_GPA = e_GPA;
	}
	public Asignatura getA_GPA() {
		return A_GPA;
	}
	public void setA_GPA(Asignatura a_GPA) {
		A_GPA = a_GPA;
	}
	
	public Grupo getG_GPA() {
		return G_GPA;
	}
	public void setG_GPA(Grupo g_GPA) {
		G_GPA = g_GPA;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((A_GPA == null) ? 0 : A_GPA.hashCode());
		result = prime * result + ((Curso_Academico == null) ? 0 : Curso_Academico.hashCode());
		result = prime * result + ((E_GPA == null) ? 0 : E_GPA.hashCode());
		result = prime * result + ((G_GPA == null) ? 0 : G_GPA.hashCode());
		result = prime * result + ((Oferta == null) ? 0 : Oferta.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GruposPorAsignatura other = (GruposPorAsignatura) obj;
		if (A_GPA == null) {
			if (other.A_GPA != null)
				return false;
		} else if (!A_GPA.equals(other.A_GPA))
			return false;
		if (Curso_Academico == null) {
			if (other.Curso_Academico != null)
				return false;
		} else if (!Curso_Academico.equals(other.Curso_Academico))
			return false;
		if (E_GPA == null) {
			if (other.E_GPA != null)
				return false;
		} else if (!E_GPA.equals(other.E_GPA))
			return false;
		if (G_GPA == null) {
			if (other.G_GPA != null)
				return false;
		} else if (!G_GPA.equals(other.G_GPA))
			return false;
		if (Oferta == null) {
			if (other.Oferta != null)
				return false;
		} else if (!Oferta.equals(other.Oferta))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GruposPorAsignatura [Curso_Academico=" + Curso_Academico + ", Oferta=" + Oferta + ", E_GPA=" + E_GPA
				+ ", A_GPA=" + A_GPA + ", G_GPA=" + G_GPA + "]";
	}
	
	
	
   
}
