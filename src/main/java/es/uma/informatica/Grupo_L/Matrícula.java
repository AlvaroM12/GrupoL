package es.uma.informatica.Grupo_L;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Matrícula
 *
 */
@Entity

public class Matrícula implements Serializable {

	   
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
		return this.Fecha_De_Matrícula;
	}

	public void setFecha_De_Matrícula(Date Fecha_De_Matrícula) {
		this.Fecha_De_Matrícula = Fecha_De_Matrícula;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Curso_Academico == null) ? 0 : Curso_Academico.hashCode());
		result = prime * result + ((Estado == null) ? 0 : Estado.hashCode());
		result = prime * result + ((Listado_Asignaturas == null) ? 0 : Listado_Asignaturas.hashCode());
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
		Matrícula other = (Matrícula) obj;
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
		return true;
	}
	@Override
	public String toString() {
		return "Matrícula [Curso_Academico=" + Curso_Academico + ", Estado=" + Estado + ", Num_Archivo=" + Num_Archivo
				+ ", Turno_Preferente=" + Turno_Preferente + ", Nuevo_Ingreso=" + Nuevo_Ingreso
				+ ", Listado_Asignaturas=" + Listado_Asignaturas + "]";
	}
	
	
   
}
