package es.uma.informatica.Grupo_L.backing;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.EJB.CentroEJB;
import es.uma.informatica.EJB.GrupoEJB;
import es.uma.informatica.EJB.TitulacionEJB;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Centro;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.TitulacionException;

@Named(value = "titulacion")
@RequestScoped
public class TitulacionBB {

    @Inject
    private TitulacionEJB titejb;
    
    private Titulacion tit;
    private Centro centro;
    
    private List<Titulacion> ListaTit = new ArrayList<Titulacion>();
    public TitulacionBB() {
        tit = new Titulacion();
        
    }

    public List<Titulacion> ListaTitulacion() throws TitulacionException{
    	ListaTit=centro.getTC();;
		return ListaTit;
    	
    }
    public Titulacion leerTitulacion(Titulacion t) {
        try {
            tit =  titejb.consultarTitulacion(t.getCódigo());
        } catch (TitulacionException e) {
            e.printStackTrace();
        }
        return tit;
    }
}