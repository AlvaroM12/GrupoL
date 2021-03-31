package es.uma.informatica.Grupo_L;


import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Titulacion
 *
 */
@Entity

public class Titulacion implements Serializable {

	   
	@Id @GeneratedValue
	private Long Código;
	private String Nombre;
	private Long Créditos;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "TA")
	private List<Asignatura> asignaturas;

	public Titulacion() {
		super();
	}   
	public Long getCódigo() {
		return this.Código;
	}

	public void setCódigo(Long Código) {
		this.Código = Código;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public Long getCréditos() {
		return this.Créditos;
	}

	public void setCréditos(Long Créditos) {
		this.Créditos = Créditos;
	}
	
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Créditos == null) ? 0 : Créditos.hashCode());
		result = prime * result + ((Código == null) ? 0 : Código.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((asignaturas == null) ? 0 : asignaturas.hashCode());
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
		Titulacion other = (Titulacion) obj;
		if (Créditos == null) {
			if (other.Créditos != null)
				return false;
		} else if (!Créditos.equals(other.Créditos))
			return false;
		if (Código == null) {
			if (other.Código != null)
				return false;
		} else if (!Código.equals(other.Código))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (asignaturas == null) {
			if (other.asignaturas != null)
				return false;
		} else if (!asignaturas.equals(other.asignaturas))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Titulacion [Código=" + Código + ", Nombre=" + Nombre + ", Créditos=" + Créditos + ", asignaturas="
				+ asignaturas + "]";
	}
	
	
	
	
   
}
