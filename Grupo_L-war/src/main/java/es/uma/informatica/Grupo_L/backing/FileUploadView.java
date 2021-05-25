package es.uma.informatica.Grupo_L.backing;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazMatricula;

@Named
@RequestScoped
public class FileUploadView {

    private UploadedFile file;
    private InterfazMatricula matricula;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload() throws MatriculaException{
    	 if (file != null) {
             FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
             FacesContext.getCurrentInstance().addMessage(null, message);
             matricula.importarMatricula(file.getFileName());
         }
    }

    public void handleFileUpload(FileUploadEvent event) throws MatriculaException{
        FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        matricula.importarMatricula(event.getFile().getFileName());
    }
}