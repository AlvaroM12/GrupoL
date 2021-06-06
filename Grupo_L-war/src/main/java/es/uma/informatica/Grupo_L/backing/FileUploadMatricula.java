package es.uma.informatica.Grupo_L.backing;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazMatricula;

@Named (value="uploadMatricula")
@RequestScoped
public class FileUploadMatricula {
	@Inject
    private InterfazMatricula matricula;
    
    
    private UploadedFile file;   

   
    public void handleFileUpload(FileUploadEvent event) throws ParseException {
        this.file = null;
       
        UploadedFile file = event.getFile();
        if(file != null && file.getContent() != null && file.getContent().length > 0 && file.getFileName() != null) {
            this.file = file;
            FacesMessage msg = new FacesMessage(this.file.getFileName() + " cargado corectamente.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
            	 InputStream input = file.getInputStream();
            	 Path folder = Paths.get("wildfly/docs/");
            	 String filename = FilenameUtils.getBaseName(file.getFileName()); 
            	 String extension = FilenameUtils.getExtension(file.getFileName());
            	 Path fileupload = Files.createTempFile(folder, filename + "-", "." + extension);
            	 Files.copy(input, fileupload, StandardCopyOption.REPLACE_EXISTING);
            	 msg = new FacesMessage(this.file.getFileName() + " se ha subido correctamente.");
                 FacesContext.getCurrentInstance().addMessage(null, msg);
            	
            	 matricula.importarMatricula(new File("wildfly/docs/"+fileupload.getFileName()));
				 Path p = Paths.get("wildfly/docs/"+fileupload.getFileName());
				 Files.delete(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
}