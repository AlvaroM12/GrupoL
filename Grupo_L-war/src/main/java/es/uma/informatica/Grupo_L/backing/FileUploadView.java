package es.uma.informatica.Grupo_L.backing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.util.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import es.uma.informatica.EJB.MatriculaEJB;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazMatricula;
import es.uma.informatica.Interfaces.InterfazTitulacion;

@Named
@RequestScoped
public class FileUploadView {

    private UploadedFile file;
    @Inject
    private InterfazMatricula matricula;
    
    @Inject
    private InterfazTitulacion tit;
    
    private final static Logger LOGGER=Logger.getLogger(MatriculaEJB.class.getCanonicalName());

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload() throws MatriculaException, IOException, TitulacionException{
    	 if (file != null) {
             
         
             LOGGER.info("Antes de llamar al metodo importar ejb");
             File file_name = new File(file.getFileName());
             
             //matricula.importarMatricula(file.getFileName(), file_name.toString());	// Sale el mensaje de exito pero da error en la terminal wildfly
             //tit.importarTitulacion(file_name.toString());								// sale ifual q matricula
    	 
    	  
    	 // COPIAR ARCHIVO A OTRO DIRECTORIO
        
          	 //File path_name = new File("/home/alumno/Temporal_Primefaces/" + file.getFileName());
             //OutputStream output = new FileOutputStream(path_name);			// Se pilla aqui, no se copia el archivo.
            // IOUtils.copy(file.getInputStream(), output);
             Path temp = Files.createTempFile(file_name.getName(), ".xlsx");
             matricula.importarMatricula(file.getFileName(), temp);
              
             
             FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
             FacesContext.getCurrentInstance().addMessage(null, message);
    	 }
    }

    public void getHandleFileUpload(FileUploadEvent event) throws MatriculaException{
        FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        File file_name = new File(event.getFile().getFileName());
        Path temp;
		try {
			temp = Files.createTempFile(file_name.getName(), ".xlsx");
			matricula.importarMatricula(file_name.getName(), temp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}