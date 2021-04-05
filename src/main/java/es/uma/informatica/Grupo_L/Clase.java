package es.uma.informatica.Grupo_L;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Clase
 *
 */
@Entity
@IdClass(Clase.ClaseId.class)
public class Clase implements Serializable {
	
	public static class ClaseId implements Serializable{
		private Date Dia;
		private Long HoraInicio;
		private Long GC;
	}

	   
	@Id @Temporal(TemporalType.DATE)
	private Date Dia;   
	@Id 
	private Long HoraInicio;
	private Long HoraFin;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Asignatura AC;
	
	@Id
	@ManyToOne
	private Grupo GC;

	public Clase() {
		super();
	}   
	   
	public Date getDia() {
		return Dia;
	}

	public void setDia(Date dia) {
		Dia = dia;
	}

	public Long getHoraInicio() {
		return this.HoraInicio;
	}

	public void setHoraInicio(Long HoraInicio) {
		this.HoraInicio = HoraInicio;
	}   
	public Long getHoraFin() {
		return this.HoraFin;
	}

	public void setHoraFin(Long HoraFin) {
		this.HoraFin = HoraFin;
	}
	
	public Asignatura getAC() {
		return AC;
	}
	public void setAC(Asignatura aC) {
		AC = aC;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AC == null) ? 0 : AC.hashCode());
		result = prime * result + ((Dia == null) ? 0 : Dia.hashCode());
		result = prime * result + ((HoraFin == null) ? 0 : HoraFin.hashCode());
		result = prime * result + ((HoraInicio == null) ? 0 : HoraInicio.hashCode());
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
		Clase other = (Clase) obj;
		if (AC == null) {
			if (other.AC != null)
				return false;
		} else if (!AC.equals(other.AC))
			return false;
		if (Dia == null) {
			if (other.Dia != null)
				return false;
		} else if (!Dia.equals(other.Dia))
			return false;
		if (HoraFin == null) {
			if (other.HoraFin != null)
				return false;
		} else if (!HoraFin.equals(other.HoraFin))
			return false;
		if (HoraInicio == null) {
			if (other.HoraInicio != null)
				return false;
		} else if (!HoraInicio.equals(other.HoraInicio))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Clase [Dia=" + Dia + ", HoraInicio=" + HoraInicio + ", HoraFin=" + HoraFin + ", AC=" + AC + "]";
	}
	
}
