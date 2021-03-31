package es.uma.informatica.Grupo_L;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	   
	@Id @GeneratedValue
	private Integer ID; //LONG
	private String DNI;
	private String Nombre;
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}   
	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}   
	public String getDNI() {
		return this.DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
   
}
