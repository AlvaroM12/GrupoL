package es.uma.informatica.Grupo_L.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.EJB.UsuarioEJB;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Usuario;
import es.uma.informatica.Exception.AlumnoException;


@Named(value = "usuario")
@RequestScoped
public class UsuarioBB {
	
	@Inject
    private UsuarioEJB usuejb;
    
    private Usuario usu;
    
    public UsuarioBB() {
    	usu = new Usuario();
    }

    /*
     * public String validar(Usuario u) {
        try{
            usuejb.validarAcceso(email, u.getContraseña());
            
        }catch (AlumnoException e) {
            return "IndexAlumno.xhtml";
        }
        return null;
    }
     */
}
