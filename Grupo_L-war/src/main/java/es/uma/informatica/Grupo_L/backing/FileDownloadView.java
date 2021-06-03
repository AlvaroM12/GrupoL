package es.uma.informatica.Grupo_L.backing;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
@Named
@RequestScoped
public class FileDownloadView {
	@Inject
	private ExportarDatosBB expD;
	
    private StreamedContent file;
    
    public FileDownloadView() {
    	
    	
		
        file = DefaultStreamedContent.builder()
                .name("Informatica.xls")
                .contentType("application/vnd.ms-excel")
                .stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/opt/jboss/wildfly/docs/"+expD.getName()+".xls"))
                .build();
    }

    public StreamedContent getFile() {
        return file;
    }
}