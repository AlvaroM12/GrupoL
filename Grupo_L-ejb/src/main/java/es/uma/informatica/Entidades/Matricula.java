package es.uma.informatica.Entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Matrícula
 *
 */
@Entity
@IdClass(Matricula.MatriculaId.class)
public class Matricula implements Serializable {

	public static class MatriculaId implements Serializable{
		private String Curso_Academico;
		private Long EM;
		
		public MatriculaId() {
		}
		
		public MatriculaId(String c, Long em) {
			Curso_Academico = c;
			EM = em;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Curso_Academico == null) ? 0 : Curso_Academico.hashCode());
			result = prime * result + ((EM == null) ? 0 : EM.hashCode());
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
			MatriculaId other = (MatriculaId) obj;
			if (Curso_Academico == null) {
				if (other.Curso_Academico != null)
					return false;
			} else if (!Curso_Academico.equals(other.Curso_Academico))
				return false;
			if (EM == null) {
				if (other.EM != null)
					return false;
			} else if (!EM.equals(other.EM))
				return false;
			return true;
		}
	}
	   
	@Id
	private String Curso_Academico;
	private String Estado;
	private Long Num_Archivo;
	private String Turno_Preferente;
	
	@Temporal(TemporalType.DATE)
	private Date Fecha_De_Matricula;
	private String Nuevo_Ingreso;
	@OneToMany(mappedBy="matriculas")
	private List<Asignatura> a;
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne 
	@JoinColumn(name="EM")
	private Expediente EM;
	
	@OneToMany(mappedBy = "matricula", cascade = CascadeType.REMOVE)
	private List<Asignaturas_Matricula> asigMatricula;

	
	public Matricula(String curso_Academico, String estado, Long num_Archivo, String turno_Preferente,
			Date fecha_De_Matrícula, String nuevo_Ingreso, List<Asignatura> listado_Asignaturas, Expediente E) {
		super();
		Curso_Academico = curso_Academico;
		Estado = estado;
		Num_Archivo = num_Archivo;
		Turno_Preferente = turno_Preferente;
		Fecha_De_Matricula = fecha_De_Matrícula;
		Nuevo_Ingreso = nuevo_Ingreso;
		a = listado_Asignaturas;
		EM = E;
		
	}
	public Matricula() {
		super();
	}   
	public String getCurso_Academico() {
		return this.Curso_Academico;
	}

	public void setCurso_Academico(String Curso_Academico) {
		this.Curso_Academico = Curso_Academico;
	}   
	public String getEstado() {
		return this.Estado;
	}

	public void setEstado(String Estado) {
		this.Estado = Estado;
	}   
	public Long getNum_Archivo() {
		return this.Num_Archivo;
	}

	public void setNum_Archivo(Long Num_Archivo) {
		this.Num_Archivo = Num_Archivo;
	}   
	public String getTurno_Preferente() {
		return this.Turno_Preferente;
	}

	public void setTurno_Preferente(String Turno_Preferente) {
		this.Turno_Preferente = Turno_Preferente;
	}   
	
	public Date getFecha_De_Matricula() {
		return Fecha_De_Matricula;
	}
	public void setFecha_De_Matricula(Date fecha_De_Matrícula) {
		Fecha_De_Matricula = fecha_De_Matrícula;
	}
	public String getNuevo_Ingreso() {
		return this.Nuevo_Ingreso;
	}

	public void setNuevo_Ingreso(String Nuevo_Ingreso) {
		this.Nuevo_Ingreso = Nuevo_Ingreso;
	}   
	public List<Asignatura> getA() {
		return a;
	}
	public void setA(List<Asignatura> a) {
		this.a = a;
	}
	public Expediente getEM() {
		return EM;
	}
	public void setEM(Expediente eM) {
		EM = eM;
	}
	public List<Asignaturas_Matricula> getAsigMatricula() {
		return asigMatricula;
	}
	public void setAsigMatricula(List<Asignaturas_Matricula> asigMatricula) {
		this.asigMatricula = asigMatricula;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Curso_Academico == null) ? 0 : Curso_Academico.hashCode());
		result = prime * result + ((Estado == null) ? 0 : Estado.hashCode());
		result = prime * result + ((Fecha_De_Matricula == null) ? 0 : Fecha_De_Matricula.hashCode());
		result = prime * result + ((Nuevo_Ingreso == null) ? 0 : Nuevo_Ingreso.hashCode());
		result = prime * result + ((Num_Archivo == null) ? 0 : Num_Archivo.hashCode());
		result = prime * result + ((Turno_Preferente == null) ? 0 : Turno_Preferente.hashCode());
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
		Matricula other = (Matricula) obj;
		if (Curso_Academico == null) {
			if (other.Curso_Academico != null)
				return false;
		} else if (!Curso_Academico.equals(other.Curso_Academico))
			return false;
		if (Estado == null) {
			if (other.Estado != null)
				return false;
		} else if (!Estado.equals(other.Estado))
			return false;
		if (Fecha_De_Matricula == null) {
			if (other.Fecha_De_Matricula != null)
				return false;
		} else if (!Fecha_De_Matricula.equals(other.Fecha_De_Matricula))
			return false;
		if (Nuevo_Ingreso == null) {
			if (other.Nuevo_Ingreso != null)
				return false;
		} else if (!Nuevo_Ingreso.equals(other.Nuevo_Ingreso))
			return false;
		if (Num_Archivo == null) {
			if (other.Num_Archivo != null)
				return false;
		} else if (!Num_Archivo.equals(other.Num_Archivo))
			return false;
		if (Turno_Preferente == null) {
			if (other.Turno_Preferente != null)
				return false;
		} else if (!Turno_Preferente.equals(other.Turno_Preferente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Matrícula [Curso_Academico=" + Curso_Academico + ", Estado=" + Estado + ", Num_Archivo=" + Num_Archivo
				+ ", Turno_Preferente=" + Turno_Preferente + ", Fecha_De_Matrícula=" + Fecha_De_Matricula
				+ ", Nuevo_Ingreso=" + Nuevo_Ingreso + ", a=" + a + ", EM=" + EM + ", asigMatricula=" + asigMatricula
				+ "]";
	}
	   
}
