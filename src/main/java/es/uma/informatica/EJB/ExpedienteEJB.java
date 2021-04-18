package es.uma.informatica.EJB;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Interfaces.InterfazExpediente;

/**
 * Session Bean implementation class Expediente
 */
@Stateless
public class ExpedienteEJB implements InterfazExpediente {

	@PersistenceContext(name="Expediente")
	private EntityManager em;

	@Override
	public void Importar_Expediente(ExpedienteEJB exp) throws ExpedienteException {
		
		try {
			String directorio_de_ejecucion_de_la_aplicacion;
			directorio_de_ejecucion_de_la_aplicacion = new java.io.File( "." ).getCanonicalPath();
			System.out.println("Real path " + directorio_de_ejecucion_de_la_aplicacion);
			String sFile = directorio_de_ejecucion_de_la_aplicacion + "/" +"Oferta asignaturas.xlsx"; 
			XSSFWorkbook workbook = new XSSFWorkbook(sFile);
			XSSFSheet sheet = workbook.getSheet("GII");
	        XSSFRow row = sheet.getRow(0);
	        XSSFCell cell = null;
	        
	        for(int fila=1; fila<row.getRowNum(); fila++) {
	        	
	        }
		
		
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		Expediente e = new Expediente();
		
		
		
	}

}
