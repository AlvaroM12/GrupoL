package es.uma.informatica.Grupo_L.backing;



import java.io.IOException;

import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.DatosException;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazDatos;
import es.uma.informatica.Interfaces.InterfazTitulacion;

@Named(value = "exportar")
@RequestScoped
public class ExportarDatosBB {
	
	
	private String name;
    @Inject
    private InterfazDatos datosejb;
    @Inject
    private InterfazTitulacion titulacion;
    private String selectedOption;
    
    @Inject
    private FileDownloadView descargar;
    
    
    
    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }
    
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void exDatos() throws DatosException, IOException, TitulacionException {
    	long codigo=Long.parseLong(selectedOption);
    	Titulacion t=titulacion.consultarTitulacion(codigo);
    	name=t.getNombre();
    	datosejb.exportarDatos(t);
					
    }  
   
}
