package es.uma.informatica.Grupo_L.backing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named
@RequestScoped
public class FileDownloadView {
	private StreamedContent file;
    
    private final static Logger LOGGER=Logger.getLogger(FileDownloadView.class.getCanonicalName());
    public FileDownloadView() {
    	LOGGER.info("Hola");
        file = DefaultStreamedContent.builder()
                .name("Exportacion.xls")
                .contentType("application/vnd.ms-excel")
                .stream(() -> {
					try {
						return new FileInputStream("/opt/jboss/wildfly/docs/Exportacion.xls");
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