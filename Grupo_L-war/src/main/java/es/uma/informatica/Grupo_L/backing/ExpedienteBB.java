package es.uma.informatica.Grupo_L.backing;



import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignaturas_Matricula;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Matricula;
import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Interfaces.InterfazExpediente;


@Named
@RequestScoped
public class ExpedienteBB {
	
    @Inject
    private InterfazExpediente exejb;
    
    @Inject
	private InfoSesion infosesion;
    
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
    
    public List<Expediente> getExpediente()
    {
		List<Expediente> expedientes = new ArrayList<Expediente>();
        for (Expediente ex : infosesion.getAlumno().getExpedientes()) {
			expedientes.add(ex);			
		}
        return expedientes;
    }
    
  //METODO PARA LEER TODAS LAS EXPEDIENTES(S)
  	public  synchronized List<Expediente> getExpedientes(){
  		
  		try {
  			return exejb.leerExpedientes();
  		} catch (ExpedienteException e) {
  			e.printStackTrace();
  		}
  		return null;
  	}
  	//Leer expedientes de un alumno
  	/*public  synchronized List<Expediente> getExpediente(){
		List<Expediente> exp = new ArrayList<Expediente>();
		
        for (Expediente e : exp) {
			if(e.getNum_Expediente().equals(ex.getNum_Expediente())) {
				exp.add(e);
			}
		}
        return exp;
	}*/
   
}
