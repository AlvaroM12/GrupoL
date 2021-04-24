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
import es.uma.informatica.Exception.AlumnoExistenteException;
import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Interfaces.InterfazExpediente;

/**
 * Session Bean implementation class Expediente
 */
@Stateless
public class ExpedienteEJB implements InterfazExpediente {

	@PersistenceContext(name="Grupo_L")
	private EntityManager em;

	@Override
	public void importarExpediente() throws ExpedienteException {
		
		try {
			String directorio_de_ejecucion_de_la_aplicacion;
			directorio_de_ejecucion_de_la_aplicacion = new java.io.File( "." ).getCanonicalPath();
			String sFile = directorio_de_ejecucion_de_la_aplicacion + "/" +"Datos alumnadoFAKE.xlsx"; 
			XSSFWorkbook workbook = new XSSFWorkbook(sFile);
			XSSFSheet sheet = workbook.getSheet("Hoja1");
	        
	        
	        for(int fila=4; fila<1512; fila++) {
	        	
	        	Expediente e = new Expediente();
		        Alumno a = new Alumno();
	        	
	        	String alum = sheet.getRow(fila).getCell(0).getStringCellValue();
	        	Long id = (long)sheet.getRow(fila).getCell(25).getNumericCellValue();
	        	a.setID(id);
	        	a.setDNI(alum);	        	
	        	e.setAE(a);
	        	
	        	String Num_Expediente = sheet.getRow(fila).getCell(4).getStringCellValue();
	        	e.setNum_Expediente(Long.parseLong(Num_Expediente));
	        	
	        	String Nota_Media = sheet.getRow(fila).getCell(17).getStringCellValue();
	        	e.setNota_Media(Float.parseFloat(Nota_Media));
	        	
	        	String Creditos_Superados = sheet.getRow(fila).getCell(18).getStringCellValue();
	        	e.setCreditos_Superados(Double.parseDouble(Creditos_Superados));
	        	
	        	String Creditos_FB = sheet.getRow(fila).getCell(19).getStringCellValue();
	        	e.setCreditos_FB(Double.parseDouble(Creditos_FB));
	        	
	        	String Creditos_OB = sheet.getRow(fila).getCell(20).getStringCellValue();
	        	e.setCreditos_OB(Double.parseDouble(Creditos_OB));
	        	
	        	String Creditos_OP = sheet.getRow(fila).getCell(21).getStringCellValue();
	        	e.setCreditos_OP(Double.parseDouble(Creditos_OP));
	        	
	        	String Creditos_CF = sheet.getRow(fila).getCell(22).getStringCellValue();
	        	e.setCreditos_CF(Double.parseDouble(Creditos_CF));
	        	
	        	String Creditos_PE = sheet.getRow(fila).getCell(23).getStringCellValue();
	        	e.setCreditos_PE(Double.parseDouble(Creditos_PE));
	        	
	        	String Creditos_TF = sheet.getRow(fila).getCell(24).getStringCellValue();

	        	e.setCreditos_TF(Double.parseDouble(Creditos_TF));
	        	em.persist(e);
	        }
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public Expediente leerExpediente(Long num) throws ExpedienteException {
		Expediente e = em.find(Expediente.class, num );
		if(e==null) {
			throw new ExpedienteException();
		}
		return e;
	}
}
