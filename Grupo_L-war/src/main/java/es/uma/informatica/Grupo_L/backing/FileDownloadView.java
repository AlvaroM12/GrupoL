package es.uma.informatica.Grupo_L.backing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import es.uma.informatica.EJB.MatriculaEJB;
@Named
@RequestScoped
public class FileDownloadView {
	@Inject
	private ExportarDatosBB expD;
	
    private StreamedContent file;
    
    private final static Logger LOGGER=Logger.getLogger(FileDownloadView.class.getCanonicalName());
    public FileDownloadView() {
    	LOGGER.info("Hola");
        file = DefaultStreamedContent.builder()
                .name("Informatica.xls")
                .contentType("application/vnd.ms-excel")
                .stream(() -> {
					try {
						return new FileInputStream("/opt/jboss/wildfly/docs/Informatica.xls");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				})
                .build();
        LOGGER.info("Adios");
    }

    public StreamedContent getFile() {
        return file;
    }
}