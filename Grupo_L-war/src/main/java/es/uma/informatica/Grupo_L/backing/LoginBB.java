package es.uma.informatica.Grupo_L.backing;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.EJB.UsuarioEJB;
import es.uma.informatica.Entidades.Usuario;
import es.uma.informatica.Exception.UsuarioErrorException;
import es.uma.informatica.Exception.UsuarioException;
import es.uma.informatica.Exception.UsuarioExistenteException;

@Named
@RequestScoped
public class LoginBB {
	
	
    @Inject
    private InfoSesion sesion;

    private Usuario usuario;
    
    @Inject
    private UsuarioEJB usuEJB;

    /**
     * Creates a new instance of login
     */
    public LoginBB() {
        usuario = new Usuario();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String entrar() {
        try {
        	String rol = usuEJB.validarAcceso(usuario.getEmail_Institucional(), usuario.getContraseña());
            if(rol.equalsIgnoreCase("ALUMNO")){
            	sesion.setAlumno(usuEJB.loginAlumno(usuario.getEmail_Institucional(), usuario.getContraseña()));
            }
            if(rol.equalsIgnoreCase("SECRETARIO")){
            	sesion.setPersonal(usuEJB.loginPersonal(usuario.getEmail_Institucional(), usuario.getContraseña()));
            }
            

        } catch (UsuarioExistenteException e) {
            FacesMessage fm = new FacesMessage("Email no introducido");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (UsuarioErrorException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        } catch (UsuarioException e) {
            FacesMessage fm = new FacesMessage("Error");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        }
        return "Principal.xhtml";
    }
}
