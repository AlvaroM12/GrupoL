package es.uma.informatica.Entidades;

import java.io.Serializable;
import javax.persistence.*;

import es.uma.informatica.Entidades.Matrícula.MatriculaId;

/**
 * Entity implementation class for Entity: Asignaturas_Matrícula
 *
 */
@Entity
@IdClass(Asignaturas_Matrícula.Asignaturas_MatriculaId.class)

public class Asignaturas_Matrícula implements Serializable {
	
	public static class Asignaturas_MatriculaId implements Serializable{
		private Long asignatura;
		private MatriculaId matricula;
	}
	
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="Curso_Academico", referencedColumnName="Curso_Academico"),
		@JoinColumn(name="EM", referencedColumnName="EM")
		})
	private Matrícula matricula;
	
	@Id
	@ManyToOne
	private Asignatura asignatura;
	
	@ManyToOne
	private Grupo G_AM;
	
	private static final long serialVersionUID = 1L;
	
	public Asignaturas_Matrícula(Matrícula matricula, Asignatura asignatura, Grupo g_AM) {
		super();
		this.matricula = matricula;
		this.asignatura = asignatura;
		
	}

	public Matrícula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matrícula matricula) {
		this.matricula = matricula;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Grupo getG_AM() {
		return G_AM;
	}

	public void setG_AM(Grupo g_AM) {
		G_AM = g_AM;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((G_AM == null) ? 0 : G_AM.hashCode());
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Asignaturas_Matrícula other = (Asignaturas_Matrícula) obj;
		if (G_AM == null) {
			if (other.G_AM != null)
				return false;
		} else if (!G_AM.equals(other.G_AM))
			return false;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asignaturas_Matrícula [matricula=" + matricula + ", asignatura=" + asignatura + ", G_AM=" + G_AM + "]";
	}
	
   
}
