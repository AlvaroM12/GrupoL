package es.uma.informatica.Entidades;

import es.uma.informatica.Entidades.Asignatura;
import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Optativa
 *
 */
@Entity

public class Optativa extends Asignatura implements Serializable {

	private String Mención;	
	private static final long serialVersionUID = 1L;

	
	public Optativa(Long referencia, Long codigo, Long créditos_Teoricos, Long créditos_Practicos,
			Long total_Créditos, String ofertada, String nombre, Long curso, String plazas, String cuatrimestre,
			String idioma_de_imparticion,String mención) {
		super(referencia,codigo,créditos_Teoricos, créditos_Practicos, total_Créditos, ofertada, nombre, curso,
				plazas, cuatrimestre, idioma_de_imparticion);
		Mención = mención;
	}

	public Optativa() {
		super();
	}   
	
	public String getMención() {
		return this.Mención;
	}

	public void setMención(String Mención) {
		this.Mención = Mención;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Mención == null) ? 0 : Mención.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Optativa other = (Optativa) obj;
		if (Mención == null) {
			if (other.Mención != null)
				return false;
		} else if (!Mención.equals(other.Mención))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Optativa [Mención=" + Mención + ", getReferencia()=" + getReferencia() + ", getPlazas()=" + getPlazas()
				+ "]";
	}
   
}
