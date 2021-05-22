package es.uma.informatica.Grupo_L.backing;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import es.uma.informatica.EJB.CentroEJB;
import es.uma.informatica.EJB.GrupoEJB;
import es.uma.informatica.EJB.TitulacionEJB;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignaturas_Matrícula;
import es.uma.informatica.Entidades.Centro;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazTitulacion;

@Named(value = "titulacion")
@RequestScoped
public class TitulacionBB {

    @Inject
    private InterfazTitulacion titulacion;
    
    private Titulacion tit;
    private Centro centro;
    
    public TitulacionBB() {
        
        
    }

    
    
    public Titulacion gettit() {
    	return tit;
    }
    
public  synchronized List<Titulacion> getTitulaciones(){
		
		try {
			return titulacion.leerTitulaciones();
		} catch (TitulacionException e) {
			e.printStackTrace();
		}
		return null;
	}
    
    public Titulacion leerTitulacion(Titulacion t) {
        try {
            tit =  titulacion.consultarTitulacion(t.getCódigo());
        } catch (TitulacionException e) {
            e.printStackTrace();
        }
        return tit;
    }
}