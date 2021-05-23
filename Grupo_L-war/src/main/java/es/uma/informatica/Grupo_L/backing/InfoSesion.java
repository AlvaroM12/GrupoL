/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uma.informatica.Grupo_L.backing;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Personal_de_secretaria;


@Named(value = "infoSesion")
@SessionScoped
public class InfoSesion implements Serializable {

    
    private Alumno alumno;
    private Personal_de_secretaria personal;
    
    /**
     * Creates a new instance of InfoSesion
     */
    public InfoSesion() {
    }

    public synchronized void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public synchronized Alumno getAlumno() {
        return alumno;
    }
    
    public synchronized void setPersonal(Personal_de_secretaria personal) {
        this.personal = personal;
    }
    
    public synchronized Personal_de_secretaria getPersonal() {
        return personal;
    }
    
    public synchronized String invalidarSesion()
    {
        if (alumno != null)
        {
            alumno = null;
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
        if (personal != null)
        {
            personal = null;
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
        return "Login.xhtml";
    }
    
}
