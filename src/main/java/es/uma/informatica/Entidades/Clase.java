package es.uma.informatica.Entidades;

import java.io.Serializable;
import java.lang.Long;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Clase
 *
 */
@Entity
@IdClass(Clase.ClaseId.class)
public class Clase implements Serializable {
	
	public static class ClaseId implements Serializable{
		private String Dia;
		private String HoraInicio;
		private Long GC;
	}

	   
	@Id
	private String Dia;   
	@Id 
	private String HoraInicio;
	private String HoraFin;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Asignatura AC;
	
	@Id
	@ManyToOne
	private Grupo GC;

	public Clase(String dia, String horaInicio, String horaFin) {
		super();
		Dia = dia;
		HoraInicio = horaInicio;
		HoraFin = horaFin;
	}

	public Clase() {
		super();
	}   
	   
	public String getDia() {
		return Dia;
	}

	public void setDia(String dia) {
		Dia = dia;
	}

	public String getHoraInicio() {
		return HoraInicio;
	}

	public void setHoraInicio(String horaInicio) {
		HoraInicio = horaInicio;
	}

	public String getHoraFin() {
		return HoraFin;
	}

	public void setHoraFin(String horaFin) {
		HoraFin = horaFin;
	}

	public Asignatura getAC() {
		return AC;
	}
	
	public void setAC(Asignatura aC) {
		AC = aC;
	}
	
	public Grupo getGC() {
		return GC;
	}

	public void setGC(Grupo gC) {
		GC = gC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AC == null) ? 0 : AC.hashCode());
		result = prime * result + ((Dia == null) ? 0 : Dia.hashCode());
		result = prime * result + ((GC == null) ? 0 : GC.hashCode());
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
		if (GC == null) {
			if (other.GC != null)
				return false;
		} else if (!GC.equals(other.GC))
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
		return "Clase [Dia=" + Dia + ", HoraInicio=" + HoraInicio + ", HoraFin=" + HoraFin + ", AC=" + AC + ", GC=" + GC
				+ "]";
	}
}
