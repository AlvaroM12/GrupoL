package es.uma.informatica.Entidades;

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
@Inheritance(strategy = InheritanceType.JOINED)
public class Asignatura implements Serializable {

	   
	@Id @GeneratedValue
	private Long Referencia;
	private Long Codigo;
	private Long Creditos_Teoricos;
	private Long Creditos_Practicos;
	private Long Total_Creditos;
	private String Ofertada;
	private String Nombre;
	private Long Curso;
	private String Plazas;
	private String Cuatrimestre;
	private String Idioma_de_imparticion;
	
	public Asignatura(Long referencia, Long codigo, Long creditos_Teoricos, Long creditos_Practicos,
			Long total_Creditos, String ofertada, String nombre, Long curso, String plazas, String cuatrimestre,
			String idioma_de_imparticion) {
		super();
		Referencia = referencia;
		Codigo = codigo;
		Creditos_Teoricos = creditos_Teoricos;
		Creditos_Practicos = creditos_Practicos;
		Total_Creditos = total_Creditos;
		Ofertada = ofertada;
		Nombre = nombre;
		Curso = curso;
		Plazas = plazas;
		Cuatrimestre = cuatrimestre;
		Idioma_de_imparticion = idioma_de_imparticion;
	}
	
	public Asignatura() {
		super();
	} 
	
	@ManyToOne
	private Titulacion TA;
	
	@OneToMany(mappedBy = "AC")
	private List<Clase> clases;
	
	@OneToMany(mappedBy = "asignatura")
	private List<Asignaturas_Matricula> asignaturasMatricula;
	
	@OneToMany(mappedBy = "A_GPA")
	private List<GruposPorAsignatura> gruposPorAsignatura;
	
	@ManyToOne
	private Matricula matriculas;
	
	private static final long serialVersionUID = 1L;
  
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
	
	public String getOfertada() {
		return this.Ofertada;
	}

	public void setOfertada(String Ofertada) {
		this.Ofertada = Ofertada;
	}   
	

	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	  
	public Long getCurso() {
		return this.Curso;
	}

	public void setCurso(Long Curso) {
		this.Curso = Curso;
	}   
	 
	public String getIdioma_de_imparticion() {
		return this.Idioma_de_imparticion;
	}

	public void setIdioma_de_imparticion(String Idioma_de_imparticion) {
		this.Idioma_de_imparticion = Idioma_de_imparticion;
	}	
	
	public Long getCreditos_Teoricos() {
		return Creditos_Teoricos;
	}
	public void setCreditos_Teoricos(Long créditos_Teoricos) {
		Creditos_Teoricos = créditos_Teoricos;
	}
	public Long getCreditos_Practicos() {
		return Creditos_Practicos;
	}
	public void setCreditos_Practicos(Long créditos_Practicos) {
		Creditos_Practicos = créditos_Practicos;
	}
	public Long getTotal_Creditos() {
		return Total_Creditos;
	}
	public void setTotal_Creditos(Long total_Créditos) {
		Total_Creditos = total_Créditos;
	}
	public String getPlazas() {
		return Plazas;
	}
	public void setPlazas(String plazas) {
		Plazas = plazas;
	}
	
	public String getCuatrimestre() {
		return Cuatrimestre;
	}
	public void setCuatrimestre(String cuatrimestre) {
		Cuatrimestre = cuatrimestre;
	}
	public Titulacion getTA() {
		return TA;
	}
	public void setTA(Titulacion tA) {
		TA = tA;
	}
	public List<Clase> getClases() {
		return clases;
	}
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	public List<Asignaturas_Matricula> getAsignaturasMatricula() {
		return asignaturasMatricula;
	}
	public void setAsignaturasMatricula(List<Asignaturas_Matricula> asignaturasMatricula) {
		this.asignaturasMatricula = asignaturasMatricula;
	}
	
	
	public List<GruposPorAsignatura> getGruposPorAsignatura() {
		return gruposPorAsignatura;
	}
	public void setGruposPorAsignatura(List<GruposPorAsignatura> gruposPorAsignatura) {
		this.gruposPorAsignatura = gruposPorAsignatura;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
		result = prime * result + ((Creditos_Practicos == null) ? 0 : Creditos_Practicos.hashCode());
		result = prime * result + ((Creditos_Teoricos == null) ? 0 : Creditos_Teoricos.hashCode());
		result = prime * result + ((Cuatrimestre == null) ? 0 : Cuatrimestre.hashCode());
		result = prime * result + ((Curso == null) ? 0 : Curso.hashCode());
		result = prime * result + ((Idioma_de_imparticion == null) ? 0 : Idioma_de_imparticion.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((Ofertada == null) ? 0 : Ofertada.hashCode());
		result = prime * result + ((Plazas == null) ? 0 : Plazas.hashCode());
		result = prime * result + ((Referencia == null) ? 0 : Referencia.hashCode());
		result = prime * result + ((Total_Creditos == null) ? 0 : Total_Creditos.hashCode());
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
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		if (Creditos_Practicos == null) {
			if (other.Creditos_Practicos != null)
				return false;
		} else if (!Creditos_Practicos.equals(other.Creditos_Practicos))
			return false;
		if (Creditos_Teoricos == null) {
			if (other.Creditos_Teoricos != null)
				return false;
		} else if (!Creditos_Teoricos.equals(other.Creditos_Teoricos))
			return false;
		if (Cuatrimestre == null) {
			if (other.Cuatrimestre != null)
				return false;
		} else if (!Cuatrimestre.equals(other.Cuatrimestre))
			return false;
		if (Curso == null) {
			if (other.Curso != null)
				return false;
		} else if (!Curso.equals(other.Curso))
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
		if (Plazas == null) {
			if (other.Plazas != null)
				return false;
		} else if (!Plazas.equals(other.Plazas))
			return false;
		if (Referencia == null) {
			if (other.Referencia != null)
				return false;
		} else if (!Referencia.equals(other.Referencia))
			return false;
		if (Total_Creditos == null) {
			if (other.Total_Creditos != null)
				return false;
		} else if (!Total_Creditos.equals(other.Total_Creditos))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Asignatura [Referencia=" + Referencia + ", Codigo=" + Codigo + ", Créditos_Teoricos="
				+ Creditos_Teoricos + ", Créditos_Practicos=" + Creditos_Practicos + ", Total_Créditos="
				+ Total_Creditos + ", Ofertada=" + Ofertada + ", Nombre=" + Nombre + ", Curso=" + Curso + ", Plazas="
				+ Plazas + ", Cuatrimestre=" + Cuatrimestre + ", Idioma_de_imparticion=" + Idioma_de_imparticion
				+ ", TA=" + TA + ", clases=" + clases + ", asignaturasMatricula=" + asignaturasMatricula
				+ ", gruposPorAsignatura=" + gruposPorAsignatura + "]";
	}
}
