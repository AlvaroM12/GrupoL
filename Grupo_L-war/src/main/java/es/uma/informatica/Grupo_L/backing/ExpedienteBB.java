package es.uma.informatica.Grupo_L.backing;



import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Interfaces.InterfazExpediente;


@Named
@RequestScoped
public class ExpedienteBB {
	
    @Inject
    private InterfazExpediente exejb;
    
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
    
  //METODO PARA LEER TODAS LAS ASIG_MATRICULAS(S)
  	public  synchronized List<Expediente> getExpedientes(){
  		
  		try {
  			return exejb.leerExpedientes();
  		} catch (ExpedienteException e) {
  			e.printStackTrace();
  		}
  		return null;
  	}
    
   
}
