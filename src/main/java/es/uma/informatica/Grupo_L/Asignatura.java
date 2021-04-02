package es.uma.informatica.Grupo_L;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Asignatura
 *
 */
@Entity

public class Asignatura implements Serializable {

	   
	@Id @GeneratedValue
	private Long Referencia;
	private Long Codigo;
	private Long Créditos;
	private String Ofertada;
	private Long Nombre;
	private Long Curso;
	private Long Caracter;
	private Long Duración;
	private Long Unidad_Temporal_Cuatrimestre;
	private String Idioma_de_imparticion;
	
	@ManyToOne
	private Titulacion TA;
	
	@OneToMany(mappedBy = "AC")
	private List<Clase> clases;
	
	
	private static final long serialVersionUID = 1L;

	public Asignatura() {
		super();
	}   
	public Long getReferencia() {
		return this.Referencia;
	}

	public void setReferencia(Long Referencia) {
		this.Referencia = Referencia;
	}   
	public Long getCodigo() {
		return this.Codigo;
	}

	public void setCodigo(Long Codigo) {
		this.Codigo = Codigo;
	}   
	public Long getCréditos() {
		return this.Créditos;
	}

	public void setCréditos(Long Créditos) {
		this.Créditos = Créditos;
	}   
	public String getOfertada() {
		return this.Ofertada;
	}

	public void setOfertada(String Ofertada) {
		this.Ofertada = Ofertada;
	}   
	public Long getNombre() {
		return this.Nombre;
	}

	public void setNombre(Long Nombre) {
		this.Nombre = Nombre;
	}   
	public Long getCurso() {
		return this.Curso;
	}

	public void setCurso(Long Curso) {
		this.Curso = Curso;
	}   
	public Long getCaracter() {
		return this.Caracter;
	}

	public void setCaracter(Long Caracter) {
		this.Caracter = Caracter;
	}   
	public Long getDuración() {
		return this.Duración;
	}

	public void setDuración(Long Duración) {
		this.Duración = Duración;
	}   
	public Long getUnidad_Temporal_Cuatrimestre() {
		return this.Unidad_Temporal_Cuatrimestre;
	}

	public void setUnidad_Temporal_Cuatrimestre(Long Unidad_Temporal_Cuatrimestre) {
		this.Unidad_Temporal_Cuatrimestre = Unidad_Temporal_Cuatrimestre;
	}   
	public String getIdioma_de_imparticion() {
		return this.Idioma_de_imparticion;
	}

	public void setIdioma_de_imparticion(String Idioma_de_imparticion) {
		this.Idioma_de_imparticion = Idioma_de_imparticion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Caracter == null) ? 0 : Caracter.hashCode());
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
		result = prime * result + ((Créditos == null) ? 0 : Créditos.hashCode());
		result = prime * result + ((Curso == null) ? 0 : Curso.hashCode());
		result = prime * result + ((Duración == null) ? 0 : Duración.hashCode());
		result = prime * result + ((Idioma_de_imparticion == null) ? 0 : Idioma_de_imparticion.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((Ofertada == null) ? 0 : Ofertada.hashCode());
		result = prime * result + ((Referencia == null) ? 0 : Referencia.hashCode());
		result = prime * result
				+ ((Unidad_Temporal_Cuatrimestre == null) ? 0 : Unidad_Temporal_Cuatrimestre.hashCode());
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
		Asignatura other = (Asignatura) obj;
		if (Caracter == null) {
			if (other.Caracter != null)
				return false;
		} else if (!Caracter.equals(other.Caracter))
			return false;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		if (Créditos == null) {
			if (other.Créditos != null)
				return false;
		} else if (!Créditos.equals(other.Créditos))
			return false;
		if (Curso == null) {
			if (other.Curso != null)
				return false;
		} else if (!Curso.equals(other.Curso))
			return false;
		if (Duración == null) {
			if (other.Duración != null)
				return false;
		} else if (!Duración.equals(other.Duración))
			return false;
		if (Idioma_de_imparticion == null) {
			if (other.Idioma_de_imparticion != null)
				return false;
		} else if (!Idioma_de_imparticion.equals(other.Idioma_de_imparticion))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (Ofertada == null) {
			if (other.Ofertada != null)
				return false;
		} else if (!Ofertada.equals(other.Ofertada))
			return false;
		if (Referencia == null) {
			if (other.Referencia != null)
				return false;
		} else if (!Referencia.equals(other.Referencia))
			return false;
		if (Unidad_Temporal_Cuatrimestre == null) {
			if (other.Unidad_Temporal_Cuatrimestre != null)
				return false;
		} else if (!Unidad_Temporal_Cuatrimestre.equals(other.Unidad_Temporal_Cuatrimestre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Asignatura [Referencia=" + Referencia + ", Codigo=" + Codigo + ", Créditos=" + Créditos + ", Ofertada="
				+ Ofertada + ", Nombre=" + Nombre + ", Curso=" + Curso + ", Caracter=" + Caracter + ", Duración="
				+ Duración + ", Unidad_Temporal_Cuatrimestre=" + Unidad_Temporal_Cuatrimestre
				+ ", Idioma_de_imparticion=" + Idioma_de_imparticion + "]";
	}
	
	
   
}
