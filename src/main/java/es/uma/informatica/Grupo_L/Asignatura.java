package es.uma.informatica.Grupo_L;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Asignatura
 *
 */
@Entity

public class Asignatura implements Serializable {

	   
	@Id
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
   
}
