package es.uma.informatica.Entidades;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Encuesta
 *
 */
@Entity
@IdClass(Encuesta.EncuestaId.class)
public class Encuesta implements Serializable {

	public static class EncuestaId implements Serializable{
		private Long EE;
		private Long Fecha_De_Envio;
		
		public EncuestaId() {
		}
		
		public EncuestaId(Long ne, Long f) {
			EE=ne;
			Fecha_De_Envio=f;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((EE == null) ? 0 : EE.hashCode());
			result = prime * result + ((Fecha_De_Envio == null) ? 0 : Fecha_De_Envio.hashCode());
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
			EncuestaId other = (EncuestaId) obj;
			if (EE == null) {
				if (other.EE != null)
					return false;
			} else if (!EE.equals(other.EE))
				return false;
			if (Fecha_De_Envio == null) {
				if (other.Fecha_De_Envio != null)
					return false;
			} else if (!Fecha_De_Envio.equals(other.Fecha_De_Envio))
				return false;
			return true;
		}
	}
	   
	@Id 
	private Long Fecha_De_Envio;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(mappedBy = "E_GPA")
	private List<GruposPorAsignatura> gruposPorAsignaturas;
	
	@Id
	@ManyToOne
	private Expediente EE;

	public Encuesta(Long fecha_De_Envío) {
		super();
		Fecha_De_Envio = fecha_De_Envío;
	}
	
	public Encuesta() {
		super();
	}   
	
	public Long getFecha_De_Envio() {
		return this.Fecha_De_Envio;
	}

	public void setFecha_De_Envio(Long Fecha_De_Envío) {
		this.Fecha_De_Envio = Fecha_De_Envío;
	}
    
	public List<GruposPorAsignatura> getGruposPorAsignaturas() {
		return gruposPorAsignaturas;
	}
	
	public void setGruposPorAsignaturas(List<GruposPorAsignatura> gruposPorAsignaturas) {
		this.gruposPorAsignaturas = gruposPorAsignaturas;
	}
	
	public Expediente getEE() {
		return EE;
	}
	
	public void setEE(Expediente eE) {
		EE = eE;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EE == null) ? 0 : EE.hashCode());
		result = prime * result + ((Fecha_De_Envio == null) ? 0 : Fecha_De_Envio.hashCode());
		result = prime * result + ((gruposPorAsignaturas == null) ? 0 : gruposPorAsignaturas.hashCode());
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
		Encuesta other = (Encuesta) obj;
		if (EE == null) {
			if (other.EE != null)
				return false;
		} else if (!EE.equals(other.EE))
			return false;
		if (Fecha_De_Envio == null) {
			if (other.Fecha_De_Envio != null)
				return false;
		} else if (!Fecha_De_Envio.equals(other.Fecha_De_Envio))
			return false;
		if (gruposPorAsignaturas == null) {
			if (other.gruposPorAsignaturas != null)
				return false;
		} else if (!gruposPorAsignaturas.equals(other.gruposPorAsignaturas))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Encuesta [Fecha_De_Envío=" + Fecha_De_Envio + ", gruposPorAsignaturas=" + gruposPorAsignaturas + ", EE="
				+ EE + "]";
	}
}
