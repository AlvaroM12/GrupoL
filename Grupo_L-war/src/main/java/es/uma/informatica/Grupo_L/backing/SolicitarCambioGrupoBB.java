package es.uma.informatica.Grupo_L.backing;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Interfaces.InterfazGrupo;

@Named
@RequestScoped
public class SolicitarCambioGrupoBB {

	    private Grupo grupo;
	    private List<Long> listGrupoCurso; 

	    @Inject
	    private InterfazGrupo iGrupo;

	    @PostConstruct
	    public void init() {
	    	try {
				for (Grupo g : iGrupo.leerGrupos()) {
					listGrupoCurso.add(g.getCurso());
				}
			} catch (GrupoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	
}
