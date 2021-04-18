package es.uma.informatica.EJB;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Titulacion;
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
			String sFile = directorio_de_ejecucion_de_la_aplicacion + "/" +"Datos alumnadoFAKE.xlsx"; 
			XSSFWorkbook workbook = new XSSFWorkbook(sFile);
			XSSFSheet sheet = workbook.getSheet("Hoja1");
	        XSSFRow row = sheet.getRow(0);
	        XSSFCell cell = null;
	        
	        Expediente e = new Expediente();
	        Alumno a = new Alumno();
	        
	        for(int fila=1; fila<row.getRowNum(); fila++) {
	        	
	        	Long alum = (long) sheet.getRow(fila).getCell(0).getNumericCellValue();
	        	a = em.find(Alumno.class, alum);
	        	e.setAE(a);
	        	
	        	String Num_Expediente = sheet.getRow(fila).getCell(4).getStringCellValue();
	        	e.setNum_Expediente(Num_Expediente);
	        	
	        	String Nota_Media = sheet.getRow(fila).getCell(17).getStringCellValue();
	        	e.setNota_Media(Nota_Media);
	        	
	        	String Creditos_Superados = sheet.getRow(fila).getCell(18).getStringCellValue();
	        	e.setCreditos_Superados(Creditos_Superados);
	        	
	        	String Creditos_FB = sheet.getRow(fila).getCell(19).getStringCellValue();
	        	e.setCreditos_FB(Creditos_FB);
	        	
	        	String Creditos_OB = sheet.getRow(fila).getCell(20).getStringCellValue();
	        	e.setCreditos_OB(Creditos_OB);
	        	
	        	String Creditos_OP = sheet.getRow(fila).getCell(21).getStringCellValue();
	        	e.setCreditos_OP(Creditos_OP);
	        	
	        	String Creditos_CF = sheet.getRow(fila).getCell(22).getStringCellValue();
	        	e.setCreditos_CF(Creditos_CF);
	        	
	        	String Creditos_PE = sheet.getRow(fila).getCell(23).getStringCellValue();
	        	e.setCreditos_PE(Creditos_PE);
	        	
	        	String Creditos_TF = sheet.getRow(fila).getCell(24).getStringCellValue();
	        	e.setCreditos_TF(Creditos_TF);
	        }
		
		
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
