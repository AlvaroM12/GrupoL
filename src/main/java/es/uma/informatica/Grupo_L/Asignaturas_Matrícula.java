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
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Curso_Academico", nullable = false, referencedColumnName = "Curso_Academico")
	private Matrícula matricula;
	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Referencia", nullable = false, referencedColumnName = "Referencia")
	private Asignatura asignatura;
	
	@ManyToOne
	private Grupo G_AM;
	
	
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
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		return "Asignaturas_Matrícula [matricula=" + matricula + ", asignatura=" + asignatura + "]";
	}

	private static final long serialVersionUID = 1L;

	public Asignaturas_Matrícula() {
		super();
	}
   
}
