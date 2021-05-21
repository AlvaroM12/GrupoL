package es.uma.informatica.Grupo_L.backing;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.EJB.AlumnoEJB;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Exception.AlumnoException;

@Named(value = "alumnos")
@RequestScoped
public class AlumnoBB {
	
    @Inject
    private AlumnoEJB alejb;
    
    private List<Alumno> listaAl = new ArrayList<Alumno>();
    private Alumno al;
    
    public AlumnoBB() {
        al = new Alumno();
    }
	
    public String eliminar(Alumno a) {
        try {
            alejb.eliminarAlumno(a.getID());
            
        }catch (AlumnoException e) {
            return "IndexAlumno.xhtml";
        }
        return null;
    }
    
    public String modificar(Alumno a) {
        al = a;
        //setModo(Modo.MODIFICAR);
        return "edicionAlumno.xhtml";
    }
    
    public List<Alumno> listaAlumno() {
    	try {
    		listaAl =  alejb.listaAlumno();
    		
		} catch (AlumnoException e) {
			e.printStackTrace();
		}
		return listaAl;
    }
}
