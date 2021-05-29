package es.uma.informatica.Grupo_L.backing;


import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Entidades.Centro;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazTitulacion;

@Named(value = "titulacion")
@RequestScoped
public class TitulacionBB {
	@Inject
	private InfoSesion infosesion;
    @Inject
    private InterfazTitulacion titulacion;
    
    private Titulacion tit;
    
    
    public TitulacionBB() {
        
        
    }    
    
       public Titulacion getTit() {
		return tit;
	}

	public void setTit(Titulacion tit) {
		this.tit = tit;
	}
	
	//Leer expedientes de un alumno (FUNCIONA)
	public List<Titulacion> getTitulacion()
    {
		List<Titulacion> titula = new ArrayList<Titulacion>();
        for (Expediente e : infosesion.getAlumno().getExpedientes()) {			
				titula.add(e.getTE());					
		}
        return titula;
    }
    
	//Leer todas las titulaciones (FUNCIONA)
    public  List<Titulacion> getTitulaciones(){
		
		try {
			return titulacion.leerTitulaciones();
		} catch (TitulacionException e) {
			e.printStackTrace();
		}
		return null;
	}
    
    //Metodo para consultar una titulacion por su codigo
    public Titulacion leerTitulacion(Titulacion t) {
        try {
            tit =  titulacion.consultarTitulacion(t.getCodigo());
        } catch (TitulacionException e) {
            e.printStackTrace();
        }
        return tit;
    }
}