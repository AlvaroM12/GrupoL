package es.uma.informatica.Grupo_L;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Encuesta
 *
 */
@Entity

public class Encuesta implements Serializable {

	   
	@Id @GeneratedValue
	private Long Fecha_De_Envío;
	private static final long serialVersionUID = 1L;

	public Encuesta() {
		super();
	}   
	public Long getFecha_De_Envío() {
		return this.Fecha_De_Envío;
	}

	public void setFecha_De_Envío(Long Fecha_De_Envío) {
		this.Fecha_De_Envío = Fecha_De_Envío;
	}
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Fecha_De_Envío == null) ? 0 : Fecha_De_Envío.hashCode());
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
		Encuesta other = (Encuesta) obj;
		if (Fecha_De_Envío == null) {
			if (other.Fecha_De_Envío != null)
				return false;
		} else if (!Fecha_De_Envío.equals(other.Fecha_De_Envío))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Encuesta [Fecha_De_Envío=" + Fecha_De_Envío + "]";
	}
}
