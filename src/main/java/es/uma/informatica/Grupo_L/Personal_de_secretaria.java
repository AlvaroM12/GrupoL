package es.uma.informatica.Grupo_L;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personal_de_secretaria
 *
 */
@Entity

public class Personal_de_secretaria implements Serializable {

	
	private String Rango;
	private static final long serialVersionUID = 1L;

	public Personal_de_secretaria() {
		super();
	}   
	public String getRango() {
		return this.Rango;
	}

	public void setRango(String Rango) {
		this.Rango = Rango;
	}
   
}
