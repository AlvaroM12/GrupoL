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
import es.uma.informatica.Exception.ClaseException;
import es.uma.informatica.Interfaces.InterfazClase;

@Named (value="uploadHorario")
@RequestScoped
public class FileUploadHorario {
	@Inject
    private InterfazClase horario;
    
    
    private UploadedFile HorarioFile;   

   
    public void handleFileUpload(FileUploadEvent event) {
        this.HorarioFile = null;
       
        UploadedFile file = event.getFile();
        if(file != null && file.getContent() != null && file.getContent().length > 0 && file.getFileName() != null) {
            this.HorarioFile = file;
            FacesMessage msg = new FacesMessage(this.HorarioFile.getFileName() + " cargado corectamente.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
            	 InputStream input = HorarioFile.getInputStream();
            	 Path folder = Paths.get("wildfly/docs/");
            	 String filename = FilenameUtils.getBaseName(HorarioFile.getFileName()); 
            	 String extension = FilenameUtils.getExtension(HorarioFile.getFileName());
            	 Path fileupload = Files.createTempFile(folder, filename + "-", "." + extension);
            	 Files.copy(input, fileupload, StandardCopyOption.REPLACE_EXISTING);
            	 msg = new FacesMessage(this.HorarioFile.getFileName() + " se ha subido correctamente.");
                 FacesContext.getCurrentInstance().addMessage(null, msg);
            	
        	 
        		 
    			 try {
					 horario.Importar_Horario(new File("wildfly/docs/"+fileupload.getFileName()));
				 } catch (ClaseException e) {
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
