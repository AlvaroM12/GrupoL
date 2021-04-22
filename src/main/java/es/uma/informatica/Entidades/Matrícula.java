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
@IdClass(Matrícula.MatriculaId.class)
public class Matrícula implements Serializable {

	public static class MatriculaId implements Serializable{
		private String Curso_Academico;
		private Long EM;
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
	private Date Fecha_De_Matrícula;
	private String Nuevo_Ingreso;
	private String Listado_Asignaturas;
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne 
	@JoinColumn(name="EM")
	private Expediente EM;
	
	@OneToMany(mappedBy = "matricula")
	private List<Asignaturas_Matrícula> asigMatricula;

	
	public Matrícula(String curso_Academico, String estado, Long num_Archivo, String turno_Preferente,
			Date fecha_De_Matrícula, String nuevo_Ingreso, String listado_Asignaturas, Expediente E) {
		super();
		Curso_Academico = curso_Academico;
		Estado = estado;
		Num_Archivo = num_Archivo;
		Turno_Preferente = turno_Preferente;
		Fecha_De_Matrícula = fecha_De_Matrícula;
		Nuevo_Ingreso = nuevo_Ingreso;
		Listado_Asignaturas = listado_Asignaturas;
		EM = E;
		
	}
	public Matrícula() {
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
	
	public Date getFecha_De_Matrícula() {
		return Fecha_De_Matrícula;
	}
	public void setFecha_De_Matrícula(Date fecha_De_Matrícula) {
		Fecha_De_Matrícula = fecha_De_Matrícula;
	}
	public String getNuevo_Ingreso() {
		return this.Nuevo_Ingreso;
	}

	public void setNuevo_Ingreso(String Nuevo_Ingreso) {
		this.Nuevo_Ingreso = Nuevo_Ingreso;
	}   
	public String getListado_Asignaturas() {
		return this.Listado_Asignaturas;
	}

	public void setListado_Asignaturas(String Listado_Asignaturas) {
		this.Listado_Asignaturas = Listado_Asignaturas;
	}
	
	
	public Expediente getEM() {
		return EM;
	}
	public void setEM(Expediente eM) {
		EM = eM;
	}
	public List<Asignaturas_Matrícula> getAsigMatricula() {
		return asigMatricula;
	}
	public void setAsigMatricula(List<Asignaturas_Matrícula> asigMatricula) {
		this.asigMatricula = asigMatricula;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Curso_Academico == null) ? 0 : Curso_Academico.hashCode());
		result = prime * result + ((EM == null) ? 0 : EM.hashCode());
		result = prime * result + ((Estado == null) ? 0 : Estado.hashCode());
		result = prime * result + ((Fecha_De_Matrícula == null) ? 0 : Fecha_De_Matrícula.hashCode());
		result = prime * result + ((Listado_Asignaturas == null) ? 0 : Listado_Asignaturas.hashCode());
		result = prime * result + ((Nuevo_Ingreso == null) ? 0 : Nuevo_Ingreso.hashCode());
		result = prime * result + ((Num_Archivo == null) ? 0 : Num_Archivo.hashCode());
		result = prime * result + ((Turno_Preferente == null) ? 0 : Turno_Preferente.hashCode());
		result = prime * result + ((asigMatricula == null) ? 0 : asigMatricula.hashCode());
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
		Matrícula other = (Matrícula) obj;
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
		if (Estado == null) {
			if (other.Estado != null)
				return false;
		} else if (!Estado.equals(other.Estado))
			return false;
		if (Fecha_De_Matrícula == null) {
			if (other.Fecha_De_Matrícula != null)
				return false;
		} else if (!Fecha_De_Matrícula.equals(other.Fecha_De_Matrícula))
			return false;
		if (Listado_Asignaturas == null) {
			if (other.Listado_Asignaturas != null)
				return false;
		} else if (!Listado_Asignaturas.equals(other.Listado_Asignaturas))
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
		if (asigMatricula == null) {
			if (other.asigMatricula != null)
				return false;
		} else if (!asigMatricula.equals(other.asigMatricula))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Matrícula [Curso_Academico=" + Curso_Academico + ", Estado=" + Estado + ", Num_Archivo=" + Num_Archivo
				+ ", Turno_Preferente=" + Turno_Preferente + ", Fecha_De_Matrícula=" + Fecha_De_Matrícula
				+ ", Nuevo_Ingreso=" + Nuevo_Ingreso + ", Listado_Asignaturas=" + Listado_Asignaturas + ", EM=" + EM
				+ ", asigMatricula=" + asigMatricula + "]";
	}
	   
}
