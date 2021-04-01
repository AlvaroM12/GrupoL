package es.uma.informatica.Grupo_L;

import es.uma.informatica.Grupo_L.Asignatura;
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

	
	private Long Plazas;
	private String Mención;
	private static final long serialVersionUID = 1L;

	public Optativa() {
		super();
	}   
	public Long getPlazas() {
		return this.Plazas;
	}

	public void setPlazas(Long Plazas) {
		this.Plazas = Plazas;
	}   
	public String getMención() {
		return this.Mención;
	}

	public void setMención(String Mención) {
		this.Mención = Mención;
	}
   
}
