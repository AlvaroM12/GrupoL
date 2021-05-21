package es.uma.informatica.Grupo_L.backing;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.EJB.TitulacionEJB;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.TitulacionException;

@Named(value = "titulacion")
@RequestScoped
public class TitulacionBB {

    @Inject
    private TitulacionEJB titejb;

    private Titulacion tit;

    public TitulacionBB() {
        tit = new Titulacion();
    }


    public String leerTitulacion(Titulacion t) {
        try {
            tit =  titejb.consultarTitulacion(t.getCódigo());
        } catch (TitulacionException e) {
            e.printStackTrace();
        }
        return null;
    }
}