package es.uma.informatica.Entidades;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements Serializable {

	   
	@Id @GeneratedValue
	private Long ID;
	private Long Telefono;
	private String contraseña;
	private static final long serialVersionUID = 1L;

	public Usuario(Long iD, Long telefono, String contraseña) {
		super();
		ID = iD;
		Telefono = telefono;
		this.contraseña = contraseña;
	}
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
	
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((Telefono == null) ? 0 : Telefono.hashCode());
		result = prime * result + ((contraseña == null) ? 0 : contraseña.hashCode());
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
		if (contraseña == null) {
			if (other.contraseña != null)
				return false;
		} else if (!contraseña.equals(other.contraseña))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [ID=" + ID + ", Telefono=" + Telefono + "]";
	}
	
	
   
}
