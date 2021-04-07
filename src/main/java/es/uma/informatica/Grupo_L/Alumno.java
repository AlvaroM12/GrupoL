package es.uma.informatica.Grupo_L;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Alumno
 *
 */
@Entity

public class Alumno extends Usuario implements Serializable {

	@Column(unique=true)
	private String DNI;
	private String Nombre_Completo;
	private String Email_Institucional;
	private String Email_Personal;
	private Long Móvil;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "AE")
	private List<Expediente> expedientes;

	public Alumno() {
		super();
	}   
	public String getDNI() {
		return this.DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}   
	public String getNombre_Completo() {
		return this.Nombre_Completo;
	}

	public void setNombre_Completo(String Nombre_Completo) {
		this.Nombre_Completo = Nombre_Completo;
	}   
	public String getEmail_Institucional() {
		return this.Email_Institucional;
	}

	public void setEmail_Institucional(String Email_Institucional) {
		this.Email_Institucional = Email_Institucional;
	}   
	public String getEmail_Personal() {
		return this.Email_Personal;
	}

	public void setEmail_Personal(String Email_Personal) {
		this.Email_Personal = Email_Personal;
	}   
	public Long getMóvil() {
		return this.Móvil;
	}

	public void setMóvil(Long Móvil) {
		this.Móvil = Móvil;
	}
	
	
	public List<Expediente> getExpedientes() {
		return expedientes;
	}
	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((Email_Institucional == null) ? 0 : Email_Institucional.hashCode());
		result = prime * result + ((Email_Personal == null) ? 0 : Email_Personal.hashCode());
		result = prime * result + ((Móvil == null) ? 0 : Móvil.hashCode());
		result = prime * result + ((Nombre_Completo == null) ? 0 : Nombre_Completo.hashCode());
		result = prime * result + ((expedientes == null) ? 0 : expedientes.hashCode());
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
		Alumno other = (Alumno) obj;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (Email_Institucional == null) {
			if (other.Email_Institucional != null)
				return false;
		} else if (!Email_Institucional.equals(other.Email_Institucional))
			return false;
		if (Email_Personal == null) {
			if (other.Email_Personal != null)
				return false;
		} else if (!Email_Personal.equals(other.Email_Personal))
			return false;
		if (Móvil == null) {
			if (other.Móvil != null)
				return false;
		} else if (!Móvil.equals(other.Móvil))
			return false;
		if (Nombre_Completo == null) {
			if (other.Nombre_Completo != null)
				return false;
		} else if (!Nombre_Completo.equals(other.Nombre_Completo))
			return false;
		if (expedientes == null) {
			if (other.expedientes != null)
				return false;
		} else if (!expedientes.equals(other.expedientes))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Alumno [DNI=" + DNI + ", Nombre_Completo=" + Nombre_Completo + ", Email_Institucional="
				+ Email_Institucional + ", Email_Personal=" + Email_Personal + ", Móvil=" + Móvil + ", expedientes="
				+ expedientes + "]";
	}
	
	  
}
