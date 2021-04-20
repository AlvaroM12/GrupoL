package es.uma.informatica.Entidades;


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

	   
	@Id
	private Long Código;
	private String Nombre;
	private Long Créditos;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "TA")
	private List<Asignatura> asignaturas;
	
	@OneToMany(mappedBy = "TG")
	private List<Grupo> grupos;
	
	@OneToMany(mappedBy = "TE")
	private List<Expediente> expedientes;
	
	@ManyToMany(mappedBy = "TC")
	private List<Centro> centros;

	public Titulacion(Long código, String nombre, Long créditos) {
		super();
		Código = código;
		Nombre = nombre;
		Créditos = créditos;
		
	}
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
	
	
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	public List<Expediente> getExpedientes() {
		return expedientes;
	}
	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}
	public List<Centro> getCentros() {
		return centros;
	}
	public void setCentros(List<Centro> centros) {
		this.centros = centros;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Créditos == null) ? 0 : Créditos.hashCode());
		result = prime * result + ((Código == null) ? 0 : Código.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((asignaturas == null) ? 0 : asignaturas.hashCode());
		result = prime * result + ((centros == null) ? 0 : centros.hashCode());
		result = prime * result + ((expedientes == null) ? 0 : expedientes.hashCode());
		result = prime * result + ((grupos == null) ? 0 : grupos.hashCode());
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
		if (centros == null) {
			if (other.centros != null)
				return false;
		} else if (!centros.equals(other.centros))
			return false;
		if (expedientes == null) {
			if (other.expedientes != null)
				return false;
		} else if (!expedientes.equals(other.expedientes))
			return false;
		if (grupos == null) {
			if (other.grupos != null)
				return false;
		} else if (!grupos.equals(other.grupos))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Titulacion [Código=" + Código + ", Nombre=" + Nombre + ", Créditos=" + Créditos + "]";
	}
	  
}
