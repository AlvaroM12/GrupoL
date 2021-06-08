package es.uma.informatica.Grupo_L.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazGrupo;
import es.uma.informatica.Interfaces.InterfazTitulacion;

@Named(value = "mgBB")
@RequestScoped
public class ModificarGrupoBB {
	
	@Inject
	private InterfazGrupo interfazGrupo;
	
	@Inject
	private InterfazTitulacion interfazTitulacion;
	
	private Grupo g;
	
	private Long t;
	
	public ModificarGrupoBB() {
		g = new Grupo();
	}

	public Grupo getG() {
		return g;
	}

	public void setG(Grupo g) {
		this.g = g;
	}	
	
	
	public Long getT() {
		return t;
	}

	public void setT(Long t) {
		this.t = t;
	}
	

	public List<Titulacion> getTodasTitulaciones(){
		try {
			return interfazTitulacion.leerTitulaciones();
		} catch (TitulacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String modificar() {
		try {
			interfazGrupo.actualizarGrupo(g);
		} catch (GrupoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "LeerGrupo.xhtml";
	}
	
	public Long autoID() {
		Long id = (long)0;
		try {
			List<Grupo> grupos = interfazGrupo.leerGrupos();			
			for (Grupo g : grupos) {
				if(g.getID()>id) {
					id=g.getID();
				}
			}
		} catch (GrupoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id + (long)1;
	}
	
	public String crear() {
		try {
			g.setID(autoID());
			g.setTG(interfazTitulacion.leerTitulacion(t));
			interfazGrupo.crearGrupo(g);
		} catch (GrupoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TitulacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "LeerGrupo.xhtml";
	}
	

}
