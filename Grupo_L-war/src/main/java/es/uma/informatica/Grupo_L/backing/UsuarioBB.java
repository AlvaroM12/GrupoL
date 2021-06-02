package es.uma.informatica.Grupo_L.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.Exception.UsuarioException;
import es.uma.informatica.Interfaces.InterfazUsuario;


@Named()
@RequestScoped
public class UsuarioBB {
	
	@Inject
    private InterfazUsuario usuario;
    
    private String email;
    private String passwd;
    private String passwd2;
    
    public UsuarioBB() {
    }
    
    public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getPasswd2() {
		return passwd2;
	}


	public void setPasswd2(String passwd2) {
		this.passwd2 = passwd2;
	}


	public String validar() {
        try{
        	if(passwd.equals(passwd2)){
        		usuario.solicitarRecuperarContrasenia(email);
        		usuario.generarNuevaContrasenia(usuario.encontrarUsuarioCorreo(email), passwd);
        	}
        }catch (UsuarioException e) {
            e.printStackTrace();
        }
        return "Login.xhtml";
    } 
}
