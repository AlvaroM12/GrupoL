package es.uma.informatica.Grupo_L;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personal_de_secretaria
 *
 */
@Entity

public class Personal_de_secretaria extends Usuario implements Serializable {

	
	private String Rango;
	private static final long serialVersionUID = 1L;

	public Personal_de_secretaria() {
		super();
	}   
	public String getRango() {
		return this.Rango;
	}

	public void setRango(String Rango) {
		this.Rango = Rango;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Rango == null) ? 0 : Rango.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personal_de_secretaria other = (Personal_de_secretaria) obj;
		if (Rango == null) {
			if (other.Rango != null)
				return false;
		} else if (!Rango.equals(other.Rango))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Personal_de_secretaria [Rango=" + Rango + "]";
	}
   
}
