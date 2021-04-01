package es.uma.informatica.Grupo_L;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	   
	@Id @GeneratedValue
	private Long ID;
	private Long Telefono;
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}   
	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}   
	public Long getTelefono() {
		return this.Telefono;
	}

	public void setTelefono(Long Telefono) {
		this.Telefono = Telefono;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((Telefono == null) ? 0 : Telefono.hashCode());
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
		Usuario other = (Usuario) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (Telefono == null) {
			if (other.Telefono != null)
				return false;
		} else if (!Telefono.equals(other.Telefono))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [ID=" + ID + ", Telefono=" + Telefono + "]";
	}
	
	
   
}
