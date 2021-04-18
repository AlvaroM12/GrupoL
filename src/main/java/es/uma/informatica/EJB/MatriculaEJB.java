package es.uma.informatica.EJB;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazMatricula;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Matrícula;

/**
 * Session Bean implementation class Matrícula
 */
@Stateless
public class MatriculaEJB implements InterfazMatricula {
	
	@PersistenceContext(name="Matricula")
	private EntityManager em;

	@Override
	public void Importar_Matricula() throws MatriculaException {
		try {
			String directorio_de_ejecucion_de_la_aplicacion = new java.io.File( "." ).getCanonicalPath();
			String sFile = directorio_de_ejecucion_de_la_aplicacion + "/" +"Datos alumnadoFAKE.xlsx"; 
			XSSFWorkbook workbook = new XSSFWorkbook(sFile);
	        XSSFSheet sheet = workbook.getSheet("Hoja1");
	        XSSFRow row = sheet.getRow(0);
	        XSSFCell cell = null;
	        Matrícula m = new Matrícula();
	        Expediente e = new Expediente();
	        for(int fila=4; fila<row.getRowNum(); fila++) {
	        	String nExp = sheet.getRow(fila).getCell(4).getStringCellValue();	        	
	        	e = em.find(Expediente.class, e);
	        	m.setEM(e);
	        	Long nºarchivo = (long) sheet.getRow(fila).getCell(5).getNumericCellValue();
	        	m.setNum_Archivo(nºarchivo);
	        	String fmat = sheet.getRow(fila).getCell(14).getStringCellValue();
	        	m.setFecha_De_Matrícula(fmat);
	        	String turnoPref = sheet.getRow(fila).getCell(15).getStringCellValue();
	        	m.setTurno_Preferente(turnoPref);
	        	System.out.println(m);
	        	          
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
