package es.uma.informatica.Grupo_L;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Clase
 *
 */
@Entity

public class Clase implements Serializable {

	   
	@Id 
	private Long Dia;   
	@Id 
	private Long HoraInicio;
	private Long HoraFin;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Asignatura AC;

	public Clase() {
		super();
	}   
	public Long getDia() {
		return this.Dia;
	}

	public void setDia(Long Dia) {
		this.Dia = Dia;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		return "Clase [Dia=" + Dia + ", HoraInicio=" + HoraInicio + ", HoraFin=" + HoraFin + "]";
	}
	
   
}
