package es.uma.informatica.Grupo_L;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Asignaturas_Matrícula
 *
 */
@Entity

public class Asignaturas_Matrícula implements Serializable {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "Curso_Academico", nullable = false, referencedColumnName = "Curso_Academico"),
		@JoinColumn(name = "EM", nullable = false, referencedColumnName = "EM"),
	})	
	private Matrícula matricula;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Referencia", nullable = false, referencedColumnName = "Referencia")
	private Asignatura asignatura;
	
	@ManyToOne
	private Grupo G_AM;
	
	private static final long serialVersionUID = 1L;
	
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
