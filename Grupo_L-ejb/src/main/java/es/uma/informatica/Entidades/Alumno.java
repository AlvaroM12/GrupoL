package es.uma.informatica.Entidades;

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
	private String Nombre;
	private String Apellido1;
	private String Apellido2;
	private String Email_Personal;
	private Long Móvil;
	private String Direccion;
	private String Localidad;
	private String Provincia;
	private Long CP;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "AE", cascade = CascadeType.REMOVE)
	private List<Expediente> expedientes;
	
	

	public Alumno(Long id, Long telefono, String Contraseña , String dNI, String nombre, String apellido1, String apellido2, String email_Institucional,
			String email_Personal, Long móvil, String direccion, String localidad, String provincia, Long cP) {
		super(id,telefono,email_Institucional,Contraseña);
		DNI = dNI;
		Nombre = nombre;
		Apellido1 = apellido1;
		Apellido2 = apellido2;
		Email_Personal = email_Personal;
		Móvil = móvil;
		Direccion = direccion;
		Localidad = localidad;
		Provincia = provincia;
		CP = cP;
		
	}
	public Alumno() {
		super();
	}   
	public String getDNI() {
		return this.DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
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
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido1() {
		return Apellido1;
	}
	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}
	public String getApellido2() {
		return Apellido2;
	}
	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}
	
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public Long getCP() {
		return CP;
	}
	public void setCP(Long cP) {
		CP = cP;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Apellido1 == null) ? 0 : Apellido1.hashCode());
		result = prime * result + ((Apellido2 == null) ? 0 : Apellido2.hashCode());
		result = prime * result + ((CP == null) ? 0 : CP.hashCode());
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((Direccion == null) ? 0 : Direccion.hashCode());
		result = prime * result + ((Email_Personal == null) ? 0 : Email_Personal.hashCode());
		result = prime * result + ((Localidad == null) ? 0 : Localidad.hashCode());
		result = prime * result + ((Móvil == null) ? 0 : Móvil.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((Provincia == null) ? 0 : Provincia.hashCode());
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
		if (Apellido1 == null) {
			if (other.Apellido1 != null)
				return false;
		} else if (!Apellido1.equals(other.Apellido1))
			return false;
		if (Apellido2 == null) {
			if (other.Apellido2 != null)
				return false;
		} else if (!Apellido2.equals(other.Apellido2))
			return false;
		if (CP == null) {
			if (other.CP != null)
				return false;
		} else if (!CP.equals(other.CP))
			return false;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (Direccion == null) {
			if (other.Direccion != null)
				return false;
		} else if (!Direccion.equals(other.Direccion))
			return false;
		if (Email_Personal == null) {
			if (other.Email_Personal != null)
				return false;
		} else if (!Email_Personal.equals(other.Email_Personal))
			return false;
		if (Localidad == null) {
			if (other.Localidad != null)
				return false;
		} else if (!Localidad.equals(other.Localidad))
			return false;
		if (Móvil == null) {
			if (other.Móvil != null)
				return false;
		} else if (!Móvil.equals(other.Móvil))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (Provincia == null) {
			if (other.Provincia != null)
				return false;
		} else if (!Provincia.equals(other.Provincia))
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
		return "Alumno [DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido1=" + Apellido1 + ", Apellido2=" + Apellido2
				+ ", Email_Institucional="  + ", Email_Personal=" + Email_Personal + ", Móvil=" + Móvil + ", Direccion=" + Direccion + ", Localidad=" + Localidad
				+ ", Provincia=" + Provincia + ", CP=" + CP + ", expedientes=" + expedientes + "]";
	}
	
	
	  
}
