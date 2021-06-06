package es.uma.informatica.Grupo_L.backing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.util.IOUtils;
import org.primefaces.model.file.UploadedFile;

import es.uma.informatica.EJB.MatriculaEJB;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.AsignaturaException;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazAsignatura;
import es.uma.informatica.Interfaces.InterfazMatricula;
import es.uma.informatica.Interfaces.InterfazTitulacion;

@Named
@RequestScoped
public class AsignaturaBB {
	
	@Inject
	private InterfazAsignatura asignatura;
	
	@Inject
	private InfoSesion infosesion;
	
	private Asignatura asig;
    
    private final static Logger LOGGER=Logger.getLogger(MatriculaEJB.class.getCanonicalName());

	public AsignaturaBB(){
	}
	
	public Asignatura getAs() {
		return asig;
	}

	public void setAs(Asignatura as) {
		this.asig = as;
	}
	
	//METODO PARA LEER UNA ASIGNATURA
	public  synchronized List<Asignatura> getAsignaturaAlumno(){
		List<Asignatura> asigalum = new ArrayList<Asignatura>();
		
        for (Expediente ex : infosesion.getAlumno().getExpedientes()) {
			Titulacion ti = ex.getTE();
			List<Asignatura> asigtit = asignatura.leerAsignaturasTitulacion(ti);
			for (Asignatura a : asigalum) {
				asigalum.add(a);
			}
		}
        return asigalum;
	}

	//METODO PARA LEER TODAS LAS ASIGNATURAS
	public  synchronized List<Asignatura> getAsignaturas(){
		return asignatura.leerAsignaturas();
	}
	
	public  synchronized String getEliminar(Long ref){
		try {
			asignatura.eliminarAsignatura(ref);
		} catch (AsignaturaException e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
