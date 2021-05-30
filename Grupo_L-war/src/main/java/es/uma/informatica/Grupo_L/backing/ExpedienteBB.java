package es.uma.informatica.Grupo_L.backing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.util.IOUtils;
import org.primefaces.model.file.UploadedFile;

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
    private UploadedFile file;
    
    
    public ExpedienteBB() {
        ex = new Expediente(); 
    }
    
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
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
    
    public void uploadExpediente() throws IOException, ParseException, ExpedienteException{
      	 if (file != null) {
               Path path = Files.createTempFile("Expedientes_", ".xlsx");
               File file_name = new File(path.toString());
               OutputStream output = new FileOutputStream(file_name);
               IOUtils.copy(file.getInputStream(), output);
               exejb.importarExpediente(path.toString());
               
               FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
               FacesContext.getCurrentInstance().addMessage(null, message);
      	 }
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
