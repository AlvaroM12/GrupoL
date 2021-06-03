package es.uma.informatica.Grupo_L.backing;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazExpediente;
import es.uma.informatica.Interfaces.InterfazTitulacion;

@Named (value="uploadExpediente")
@RequestScoped
public class FileUploadExpediente {
    
    @Inject
    private InterfazExpediente expediente;
    
    
    private UploadedFile expedienteFile;   

   
    public void handleFileUpload(FileUploadEvent event) {
        this.expedienteFile = null;
       
        UploadedFile file = event.getFile();
        if(file != null && file.getContent() != null && file.getContent().length > 0 && file.getFileName() != null) {
            this.expedienteFile = file;
            FacesMessage msg = new FacesMessage(this.expedienteFile.getFileName() + " cargado corectamente.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
            	 InputStream input = expedienteFile.getInputStream();
            	 Path folder = Paths.get("wildfly/docs/");
            	 String filename = FilenameUtils.getBaseName(expedienteFile.getFileName()); 
            	 String extension = FilenameUtils.getExtension(expedienteFile.getFileName());
            	 Path fileupload = Files.createTempFile(folder, filename + "-", "." + extension);
            	 Files.copy(input, fileupload, StandardCopyOption.REPLACE_EXISTING);
            	 msg = new FacesMessage(this.expedienteFile.getFileName() + " se ha subido correctamente.");
                 FacesContext.getCurrentInstance().addMessage(null, msg);
            	
            	 try {
					expediente.importarExpediente(new File("wildfly/docs/"+fileupload.getFileName()));
					Path p = Paths.get("wildfly/docs/"+fileupload.getFileName());
					Files.delete(p);
				 } catch (ExpedienteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }


    
    }
}
