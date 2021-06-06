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
	private Long Codigo;
	private String Nombre;
	private Long Creditos;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "TA")
	private List<Asignatura> asignaturas;
	
	@OneToMany(mappedBy = "TG")
	private List<Grupo> grupos;
	
	@OneToMany(mappedBy = "TE")
	private List<Expediente> expedientes;
	
	@ManyToMany(mappedBy = "TC")
	private List<Centro> centros;

	public Titulacion(Long codigo, String nombre, Long creditos) {
		super();
		Codigo = codigo;
		Nombre = nombre;
		Creditos = creditos;
		
	}
	public Titulacion() {
		super();
	}   
	public Long getCodigo() {
		return this.Codigo;
	}

	public void setCodigo(Long Código) {
		this.Codigo = Código;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public Long getCreditos() {
		return this.Creditos;
	}

	public void setCreditos(Long Créditos) {
		this.Creditos = Créditos;
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
		result = prime * result + ((Creditos == null) ? 0 : Creditos.hashCode());
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((asignaturas == null) ? 0 : asignaturas.hashCode());
		result = prime * result + ((centros == null) ? 0 : centros.hashCode());
		result = prime * result + ((expedientes == null) ? 0 : expedientes.hashCode());
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
		if (Creditos == null) {
			if (other.Creditos != null)
				return false;
		} else if (!Creditos.equals(other.Creditos))
			return false;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
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
		return true;
	}
	@Override
	public String toString() {
		return Nombre;
	}
	  
}
