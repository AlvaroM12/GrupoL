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

	private String Mencion;	
	private static final long serialVersionUID = 1L;

	
	public Optativa(Long referencia, Long codigo, Long creditos_Teoricos, Long creditos_Practicos,
			Long total_Creditos, String ofertada, String nombre, Long curso, String plazas, String cuatrimestre,
			String idioma_de_imparticion,String mencion) {
		super(referencia,codigo,creditos_Teoricos, creditos_Practicos, total_Creditos, ofertada, nombre, curso,
				plazas, cuatrimestre, idioma_de_imparticion);
		Mencion = mencion;
	}

	public Optativa() {
		super();
	}   
	
	public String getMencion() {
		return this.Mencion;
	}

	public void setMencion(String Mencion) {
		this.Mencion = Mencion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Mencion == null) ? 0 : Mencion.hashCode());
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
		if (Mencion == null) {
			if (other.Mencion != null)
				return false;
		} else if (!Mencion.equals(other.Mencion))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Optativa [Mención=" + Mencion + ", getReferencia()=" + getReferencia() + ", getPlazas()=" + getPlazas()
				+ "]";
	}
   
}
