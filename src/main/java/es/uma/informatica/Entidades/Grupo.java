package es.uma.informatica.Entidades;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Grupo
 *
 */
@Entity

public class Grupo implements Serializable {

	   
	@Id @GeneratedValue
	private Long ID;
	@Column(unique=true)
	private Long Curso;
	@Column(unique=true)
	private String Letra;
	private String Turno_Mañana_Tarde;
	private String Ingles;
	private Long Visible;
	private Long Asignar;
	private Long Plazas;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Titulacion TG;
	
	@OneToMany(mappedBy = "G_AM")
	private List<Asignaturas_Matrícula> asignaturasMatriculas;
	
	@OneToMany(mappedBy = "GG")
	private List<Grupo> grupos;
	
	@OneToMany(mappedBy = "G_GPA")
	private List<GruposPorAsignatura> gruposPorAsig;
	
	@ManyToOne
	private Grupo GG;
	
	@OneToMany(mappedBy = "GC")
	private List<Clase> clases;
	
	public Grupo(Long id, Long curso, String letra, String turno, String ingles, Long visible, Long asignar, Long plazas) {
		super();
		ID = id;
		Curso = curso;
		Letra = letra;
		Turno_Mañana_Tarde = turno;
		Ingles = ingles;
		Visible = visible;
		Asignar = asignar;
		Plazas = plazas;
	}

	public Grupo() {
		super();
	}   
	public Long getID() {
		return this.ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}   
	public Long getCurso() {
		return this.Curso;
	}

	public void setCurso(Long Curso) {
		this.Curso = Curso;
	}   
	public String getLetra() {
		return this.Letra;
	}

	public void setLetra(String Letra) {
		this.Letra = Letra;
	}   
	public String getTurno_Mañana_Tarde() {
		return this.Turno_Mañana_Tarde;
	}

	public void setTurno_Mañana_Tarde(String Turno_Mañana_Tarde) {
		this.Turno_Mañana_Tarde = Turno_Mañana_Tarde;
	}   
	public String getIngles() {
		return this.Ingles;
	}

	public void setIngles(String Ingles) {
		this.Ingles = Ingles;
	}   
	public Long getVisible() {
		return this.Visible;
	}

	public void setVisible(Long Visible) {
		this.Visible = Visible;
	}   
	public Long getAsignar() {
		return this.Asignar;
	}

	public void setAsignar(Long Asignar) {
		this.Asignar = Asignar;
	}   
	public Long getPlazas() {
		return this.Plazas;
	}

	public void setPlazas(Long Plazas) {
		this.Plazas = Plazas;
	}
	
	public Titulacion getTG() {
		return TG;
	}
	public void setTG(Titulacion tG) {
		TG = tG;
	}
	public List<Asignaturas_Matrícula> getAsignaturasMatriculas() {
		return asignaturasMatriculas;
	}
	public void setAsignaturasMatriculas(List<Asignaturas_Matrícula> asignaturasMatriculas) {
		this.asignaturasMatriculas = asignaturasMatriculas;
	}
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	public List<GruposPorAsignatura> getGruposPorAsig() {
		return gruposPorAsig;
	}
	public void setGruposPorAsig(List<GruposPorAsignatura> gruposPorAsig) {
		this.gruposPorAsig = gruposPorAsig;
	}
	public Grupo getGG() {
		return GG;
	}
	public void setGG(Grupo gG) {
		GG = gG;
	}
	public List<Clase> getClases() {
		return clases;
	}
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Asignar == null) ? 0 : Asignar.hashCode());
		result = prime * result + ((Curso == null) ? 0 : Curso.hashCode());
		result = prime * result + ((GG == null) ? 0 : GG.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((Ingles == null) ? 0 : Ingles.hashCode());
		result = prime * result + ((Letra == null) ? 0 : Letra.hashCode());
		result = prime * result + ((Plazas == null) ? 0 : Plazas.hashCode());
		result = prime * result + ((TG == null) ? 0 : TG.hashCode());
		result = prime * result + ((Turno_Mañana_Tarde == null) ? 0 : Turno_Mañana_Tarde.hashCode());
		result = prime * result + ((Visible == null) ? 0 : Visible.hashCode());
		result = prime * result + ((asignaturasMatriculas == null) ? 0 : asignaturasMatriculas.hashCode());
		result = prime * result + ((clases == null) ? 0 : clases.hashCode());
		result = prime * result + ((grupos == null) ? 0 : grupos.hashCode());
		result = prime * result + ((gruposPorAsig == null) ? 0 : gruposPorAsig.hashCode());
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
		Grupo other = (Grupo) obj;
		if (Asignar == null) {
			if (other.Asignar != null)
				return false;
		} else if (!Asignar.equals(other.Asignar))
			return false;
		if (Curso == null) {
			if (other.Curso != null)
				return false;
		} else if (!Curso.equals(other.Curso))
			return false;
		if (GG == null) {
			if (other.GG != null)
				return false;
		} else if (!GG.equals(other.GG))
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (Ingles == null) {
			if (other.Ingles != null)
				return false;
		} else if (!Ingles.equals(other.Ingles))
			return false;
		if (Letra == null) {
			if (other.Letra != null)
				return false;
		} else if (!Letra.equals(other.Letra))
			return false;
		if (Plazas == null) {
			if (other.Plazas != null)
				return false;
		} else if (!Plazas.equals(other.Plazas))
			return false;
		if (TG == null) {
			if (other.TG != null)
				return false;
		} else if (!TG.equals(other.TG))
			return false;
		if (Turno_Mañana_Tarde == null) {
			if (other.Turno_Mañana_Tarde != null)
				return false;
		} else if (!Turno_Mañana_Tarde.equals(other.Turno_Mañana_Tarde))
			return false;
		if (Visible == null) {
			if (other.Visible != null)
				return false;
		} else if (!Visible.equals(other.Visible))
			return false;
		if (asignaturasMatriculas == null) {
			if (other.asignaturasMatriculas != null)
				return false;
		} else if (!asignaturasMatriculas.equals(other.asignaturasMatriculas))
			return false;
		if (clases == null) {
			if (other.clases != null)
				return false;
		} else if (!clases.equals(other.clases))
			return false;
		if (grupos == null) {
			if (other.grupos != null)
				return false;
		} else if (!grupos.equals(other.grupos))
			return false;
		if (gruposPorAsig == null) {
			if (other.gruposPorAsig != null)
				return false;
		} else if (!gruposPorAsig.equals(other.gruposPorAsig))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Grupo [ID=" + ID + ", Curso=" + Curso + ", Letra=" + Letra + ", Turno_Mañana_Tarde="
				+ Turno_Mañana_Tarde + ", Ingles=" + Ingles + ", Visible=" + Visible + ", Asignar=" + Asignar
				+ ", Plazas=" + Plazas + ", TG=" + TG + ", asignaturasMatriculas=" + asignaturasMatriculas + ", grupos="
				+ grupos + ", gruposPorAsig=" + gruposPorAsig + ", GG=" + GG + ", clases=" + clases + "]";
	}	
   
}
