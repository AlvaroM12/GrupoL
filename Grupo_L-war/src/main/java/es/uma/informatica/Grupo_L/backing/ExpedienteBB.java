package es.uma.informatica.Grupo_L.backing;



import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import es.uma.informatica.EJB.ExpedienteEJB;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Expediente;

import es.uma.informatica.Exception.ExpedienteException;


@Named(value = "expediente")
@RequestScoped
public class ExpedienteBB {
	
    @Inject
    private ExpedienteEJB exejb;
    
    private Alumno al;
    private Expediente ex;
    
    
    
    public ExpedienteBB() {
        ex = new Expediente();
        
    }
	
    public String leerExpediente(Expediente ex) {
        try {
            ex =  exejb.leerExpediente(ex.getNum_Expediente());
        } catch (ExpedienteException e) {
            e.printStackTrace();
        }
        return null;
    }
    
   
}
