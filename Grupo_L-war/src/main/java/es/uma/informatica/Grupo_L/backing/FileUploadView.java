package es.uma.informatica.Grupo_L.backing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.util.IOUtils;
import org.primefaces.model.file.UploadedFile;

import es.uma.informatica.EJB.MatriculaEJB;
import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazExpediente;
import es.uma.informatica.Interfaces.InterfazMatricula;

@Named
@RequestScoped
public class FileUploadView {

    private UploadedFile file;
    
    @Inject
    private InterfazMatricula matricula;
    @Inject
    private InterfazExpediente expediente;
    
    private final static Logger LOGGER=Logger.getLogger(MatriculaEJB.class.getCanonicalName());

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void uploadMatricula() throws MatriculaException, IOException, ParseException{
    	 if (file != null) {
             Path path = Files.createTempFile("Matricula_", ".xlsx");
             File file_name = new File(path.toString());
             OutputStream output = new FileOutputStream(file_name);
             IOUtils.copy(file.getInputStream(), output);
             matricula.importarMatricula(path.toString());
              
             
             FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
             FacesContext.getCurrentInstance().addMessage(null, message);
    	 }
    }

    
}