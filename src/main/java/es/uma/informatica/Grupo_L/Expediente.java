package es.uma.informatica.Grupo_L;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Expediente
 *
 */
@Entity 

public class Expediente implements Serializable {

	   
	@Id @GeneratedValue
	private Long Num_Expediente;
	private String Activo;
	private Float Nota_Media_Provisional;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Titulacion TE;
	
	@ManyToOne
	private Alumno AE;
	
	@OneToMany(mappedBy = "EM")
	private List<Matrícula> matriculas;
	
	@OneToMany(mappedBy = "EE")
	private List<Encuesta> encuestas;

	public Expediente() {
		super();
	}   
	
	public Long getNum_Expediente() {
		return this.Num_Expediente;
	}
	public void setNum_Expediente(Long Num_Expediente) {
		this.Num_Expediente = Num_Expediente;
	}   
	public String getActivo() {
		return this.Activo;
	}

	public void setActivo(String Activo) {
		this.Activo = Activo;
	}   
	public Float getNota_Media_Provisional() {
		return this.Nota_Media_Provisional;
	}

	public void setNota_Media_Provisional(Float Nota_Media_Provisional) {
		this.Nota_Media_Provisional = Nota_Media_Provisional;
	}
	
	
	
	public Titulacion getTE() {
		return TE;
	}

	public void setTE(Titulacion tE) {
		TE = tE;
	}

	public Alumno getAE() {
		return AE;
	}

	public void setAE(Alumno aE) {
		AE = aE;
	}

	public List<Matrícula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matrícula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Encuesta> getEncuestas() {
		return encuestas;
	}

	public void setEncuestas(List<Encuesta> encuestas) {
		this.encuestas = encuestas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AE == null) ? 0 : AE.hashCode());
		result = prime * result + ((Activo == null) ? 0 : Activo.hashCode());
		result = prime * result + ((Nota_Media_Provisional == null) ? 0 : Nota_Media_Provisional.hashCode());
		result = prime * result + ((Num_Expediente == null) ? 0 : Num_Expediente.hashCode());
		result = prime * result + ((TE == null) ? 0 : TE.hashCode());
		result = prime * result + ((encuestas == null) ? 0 : encuestas.hashCode());
		result = prime * result + ((matriculas == null) ? 0 : matriculas.hashCode());
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
		Expediente other = (Expediente) obj;
		if (AE == null) {
			if (other.AE != null)
				return false;
		} else if (!AE.equals(other.AE))
			return false;
		if (Activo == null) {
			if (other.Activo != null)
				return false;
		} else if (!Activo.equals(other.Activo))
			return false;
		if (Nota_Media_Provisional == null) {
			if (other.Nota_Media_Provisional != null)
				return false;
		} else if (!Nota_Media_Provisional.equals(other.Nota_Media_Provisional))
			return false;
		if (Num_Expediente == null) {
			if (other.Num_Expediente != null)
				return false;
		} else if (!Num_Expediente.equals(other.Num_Expediente))
			return false;
		if (TE == null) {
			if (other.TE != null)
				return false;
		} else if (!TE.equals(other.TE))
			return false;
		if (encuestas == null) {
			if (other.encuestas != null)
				return false;
		} else if (!encuestas.equals(other.encuestas))
			return false;
		if (matriculas == null) {
			if (other.matriculas != null)
				return false;
		} else if (!matriculas.equals(other.matriculas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Expediente [Num_Expediente=" + Num_Expediente + ", Activo=" + Activo + ", Nota_Media_Provisional="
				+ Nota_Media_Provisional + ", TE=" + TE + ", AE=" + AE + ", matriculas=" + matriculas + ", encuestas="
				+ encuestas + "]";
	}

   
}
