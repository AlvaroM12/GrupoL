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
	
	private Asignatura asig;
	private Alumno alum;
	
	private UploadedFile file;
    
    private final static Logger LOGGER=Logger.getLogger(MatriculaEJB.class.getCanonicalName());

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
	
	public AsignaturaBB(){
	}
	
	public Asignatura getAs() {
		return asig;
	}

	public void setAs(Asignatura as) {
		this.asig = as;
	}
	
	public Alumno getAlum() {
		return alum;
	}

	public void setAlum(Alumno alum) {
		this.alum = alum;
	}
	
	//METODO PARA LEER UNA ASIGNATURA
	public  synchronized List<Asignatura> getAsignaturaAlumno(){
		List<Asignatura> asigalum = new ArrayList<Asignatura>();
		
        for (Expediente ex : alum.getExpedientes()) {
        	
			for (Asignatura a : ex.getTE().getAsignaturas()) {
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
	
	public void upload() throws IOException, TitulacionException, AsignaturaException{
	   	 if (file != null) {
	            Path path = Files.createTempFile("Asignatura_", ".xlsx");
	            File file_name = new File(path.toString());
	            OutputStream output = new FileOutputStream(file_name);
	            IOUtils.copy(file.getInputStream(), output);
	            asignatura.importarAsignatura(path.toString());
	             
	            
	            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	   	 }
	   }
}
