package es.uma.informatica.Entidades;

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

	private static final long serialVersionUID = 1L;   
	
	@Id @GeneratedValue
	private Long Num_Expediente;
	private String Activo;
	private Float Nota_Media;

	private Double Creditos_Superados;
	private Double Creditos_FB;
	private Double Creditos_OB;
	private Double Creditos_OP;
	private Double Creditos_CF;
	private Double Creditos_PE;
	private Double Creditos_TF;
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	//@JoinColumn(name="CodTitulacion",foreignKey=@ForeignKey(name="FKTitulacion", foreignKeyDefinition = "FOREIGN KEY (TE) REFERENCES Titulacion (Código)"))
	private Titulacion TE;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	//@JoinColumn(name="idAlumno",foreignKey=@ForeignKey(name="FKAlumno", foreignKeyDefinition = "FOREIGN KEY (AE) REFERENCES Alumno (ID)"))
	private Alumno AE;
	
	
	@OneToMany(mappedBy = "EM", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	private List<Matrícula> matriculas;
	
	@OneToMany(mappedBy = "EE" , cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	private List<Encuesta> encuestas;
	
	

	public Expediente(Long num_Expediente, String activo, Float nota_Media, Double creditos_Superados, Double creditos_FB,
			Double creditos_OB, Double creditos_OP, Double creditos_CF, Double creditos_PE, Double creditos_TF) {
		super();
		Num_Expediente = num_Expediente;
		Activo = activo;
		Nota_Media = nota_Media;
		Creditos_Superados = creditos_Superados;
		Creditos_FB = creditos_FB;
		Creditos_OB = creditos_OB;
		Creditos_OP = creditos_OP;
		Creditos_CF = creditos_CF;
		Creditos_PE = creditos_PE;
		Creditos_TF = creditos_TF;
		
	}

	public Expediente() {
		super();
	}

	public Long getNum_Expediente() {
		return Num_Expediente;
	}

	public void setNum_Expediente(Long num_Expediente) {
		Num_Expediente = num_Expediente;
	}

	public String getActivo() {
		return Activo;
	}

	public void setActivo(String activo) {
		Activo = activo;
	}

	public Float getNota_Media() {
		return Nota_Media;
	}

	public void setNota_Media(Float nota_Media) {
		Nota_Media = nota_Media;
	}

	public void setCreditos_Superados(Double creditos_Superados) {
		Creditos_Superados = creditos_Superados;
	}

	public void setCreditos_FB(Double creditos_FB) {
		Creditos_FB = creditos_FB;
	}

	public void setCreditos_OB(Double creditos_OB) {
		Creditos_OB = creditos_OB;
	}

	public void setCreditos_OP(Double creditos_OP) {
		Creditos_OP = creditos_OP;
	}

	public void setCreditos_CF(Double creditos_CF) {
		Creditos_CF = creditos_CF;
	}

	public void setCreditos_PE(Double creditos_PE) {
		Creditos_PE = creditos_PE;
	}

	public void setCreditos_TF(Double creditos_TF) {
		Creditos_TF = creditos_TF;
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
		result = prime * result + ((Activo == null) ? 0 : Activo.hashCode());
		result = prime * result + ((Creditos_CF == null) ? 0 : Creditos_CF.hashCode());
		result = prime * result + ((Creditos_FB == null) ? 0 : Creditos_FB.hashCode());
		result = prime * result + ((Creditos_OB == null) ? 0 : Creditos_OB.hashCode());
		result = prime * result + ((Creditos_OP == null) ? 0 : Creditos_OP.hashCode());
		result = prime * result + ((Creditos_PE == null) ? 0 : Creditos_PE.hashCode());
		result = prime * result + ((Creditos_Superados == null) ? 0 : Creditos_Superados.hashCode());
		result = prime * result + ((Creditos_TF == null) ? 0 : Creditos_TF.hashCode());
		result = prime * result + ((Nota_Media == null) ? 0 : Nota_Media.hashCode());
		result = prime * result + ((Num_Expediente == null) ? 0 : Num_Expediente.hashCode());
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
		if (Activo == null) {
			if (other.Activo != null)
				return false;
		} else if (!Activo.equals(other.Activo))
			return false;
		if (Creditos_CF == null) {
			if (other.Creditos_CF != null)
				return false;
		} else if (!Creditos_CF.equals(other.Creditos_CF))
			return false;
		if (Creditos_FB == null) {
			if (other.Creditos_FB != null)
				return false;
		} else if (!Creditos_FB.equals(other.Creditos_FB))
			return false;
		if (Creditos_OB == null) {
			if (other.Creditos_OB != null)
				return false;
		} else if (!Creditos_OB.equals(other.Creditos_OB))
			return false;
		if (Creditos_OP == null) {
			if (other.Creditos_OP != null)
				return false;
		} else if (!Creditos_OP.equals(other.Creditos_OP))
			return false;
		if (Creditos_PE == null) {
			if (other.Creditos_PE != null)
				return false;
		} else if (!Creditos_PE.equals(other.Creditos_PE))
			return false;
		if (Creditos_Superados == null) {
			if (other.Creditos_Superados != null)
				return false;
		} else if (!Creditos_Superados.equals(other.Creditos_Superados))
			return false;
		if (Creditos_TF == null) {
			if (other.Creditos_TF != null)
				return false;
		} else if (!Creditos_TF.equals(other.Creditos_TF))
			return false;
		if (Nota_Media == null) {
			if (other.Nota_Media != null)
				return false;
		} else if (!Nota_Media.equals(other.Nota_Media))
			return false;
		if (Num_Expediente == null) {
			if (other.Num_Expediente != null)
				return false;
		} else if (!Num_Expediente.equals(other.Num_Expediente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Expediente [Num_Expediente=" + Num_Expediente + ", Activo=" + Activo + ", Nota_Media=" + Nota_Media
				+ ", Creditos_Superados=" + Creditos_Superados + ", Creditos_FB=" + Creditos_FB + ", Creditos_OB="
				+ Creditos_OB + ", Creditos_OP=" + Creditos_OP + ", Creditos_CF=" + Creditos_CF + ", Creditos_PE="
				+ Creditos_PE + ", Creditos_TF=" + Creditos_TF + "]";
	}   
	
	
}
