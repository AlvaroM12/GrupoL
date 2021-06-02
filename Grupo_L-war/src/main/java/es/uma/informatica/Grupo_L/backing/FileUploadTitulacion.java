package es.uma.informatica.Grupo_L.backing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.util.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

import es.uma.informatica.EJB.MatriculaEJB;
import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazExpediente;
import es.uma.informatica.Interfaces.InterfazMatricula;
import es.uma.informatica.Interfaces.InterfazTitulacion;

@Named (value="upload")
@RequestScoped
public class FileUploadTitulacion {
    
    @Inject
    private InterfazTitulacion titulacion;
    
    
    private UploadedFile titulacionFile;   

   
    public void handleFileUpload(FileUploadEvent event) {
        this.titulacionFile = null;
       
        UploadedFile file = event.getFile();
        if(file != null && file.getContent() != null && file.getContent().length > 0 && file.getFileName() != null) {
            this.titulacionFile = file;
            FacesMessage msg = new FacesMessage(this.titulacionFile.getFileName() + " cargado corectamente.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
            	 InputStream input = titulacionFile.getInputStream();
            	 Path folder = Paths.get("wildfly/docs/");
            	 String filename = FilenameUtils.getBaseName(titulacionFile.getFileName()); 
            	 String extension = FilenameUtils.getExtension(titulacionFile.getFileName());
            	 Path fileupload = Files.createTempFile(folder, filename + "-", "." + extension);
            	 Files.copy(input, fileupload, StandardCopyOption.REPLACE_EXISTING);
            	 msg = new FacesMessage(this.titulacionFile.getFileName() + " se ha subido correctamente.");
                 FacesContext.getCurrentInstance().addMessage(null, msg);
            	
                 try {
					titulacion.importarTitulacion(new File("wildfly/docs/"+fileupload.getFileName()));
				} catch (TitulacionException e) {
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