

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: GruposPorAsignatura
 *
 */
@Entity

public class GruposPorAsignatura implements Serializable {

	   
	@Override
	public String toString() {
		return "GruposPorAsignatura [Curso_Academico=" + Curso_Academico + ", Oferta=" + Oferta + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Curso_Academico == null) ? 0 : Curso_Academico.hashCode());
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
		if (Curso_Academico == null) {
			if (other.Curso_Academico != null)
				return false;
		} else if (!Curso_Academico.equals(other.Curso_Academico))
			return false;
		if (Oferta == null) {
			if (other.Oferta != null)
				return false;
		} else if (!Oferta.equals(other.Oferta))
			return false;
		return true;
	}

	@Id @GeneratedValue
	private Long Curso_Academico;
	private Long Oferta;
	private static final long serialVersionUID = 1L;
	

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
   
}
