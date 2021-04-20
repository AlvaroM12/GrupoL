package es.uma.informatica.EJB;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Clase;
import es.uma.informatica.Exception.ClaseException;
import es.uma.informatica.Interfaces.InterfazClase;

/**
 * Session Bean implementation class Clase
 */
@Stateless
public class ClaseEJB implements InterfazClase{

	@PersistenceContext(name="Clase")
	private EntityManager em;
	
	@Override
	public void Importar_Horario(Date horario) throws ClaseException {
		try {
			String directorio_de_ejecucion_de_la_aplicacion;
			directorio_de_ejecucion_de_la_aplicacion = new java.io.File( "." ).getCanonicalPath();
			String sFile = directorio_de_ejecucion_de_la_aplicacion + "/" +"Oferta asignaturas.xlsx"; 
			XSSFWorkbook workbook = new XSSFWorkbook(sFile);
			XSSFSheet sheet = workbook.getSheet("GII");
	        XSSFRow row = sheet.getRow(0);
	        XSSFCell cell = null;
	        
	        Clase c = new Clase();
	        Asignatura a = new Asignatura();
	        
	        for(int fila=1; fila<row.getRowNum(); fila++) {
	        	Long ref = (long) sheet.getRow(fila).getCell(3).getNumericCellValue();
	        	a = em.find(Asignatura.class, ref);
	        	c.setAC(a);
	        	String dia = sheet.getRow(fila).getCell(12).getStringCellValue();
	        	c.setDia(dia);
	        	LocalDateTime hini = sheet.getRow(fila).getCell(13).getLocalDateTimeCellValue();    	
	        	c.setHoraInicio(hini.getHour() + ":" + hini.getMinute());
	        	LocalDateTime hfin = sheet.getRow(fila).getCell(14).getLocalDateTimeCellValue();
	        	c.setHoraFin(hfin.getHour() + ":" + hfin.getMinute());
	        	em.persist(c);
	        	String dia2 = sheet.getRow(fila).getCell(15).getStringCellValue();
	        	c.setDia(dia2);
	        	LocalDateTime hini2 = sheet.getRow(fila).getCell(16).getLocalDateTimeCellValue();
	        	c.setHoraInicio(hini2.getHour() + ":" + hini2.getMinute());
	        	LocalDateTime hfin2 = sheet.getRow(fila).getCell(17).getLocalDateTimeCellValue();
	        	c.setHoraFin(hfin2.getHour() + ":" + hfin2.getMinute());
	        	em.persist(c);
	        	String dia3 = sheet.getRow(fila).getCell(18).getStringCellValue();
	        	c.setDia(dia3);
	        	LocalDateTime hini3 = sheet.getRow(fila).getCell(19).getLocalDateTimeCellValue();
	        	c.setHoraInicio(hini3.getHour() + ":" + hini3.getMinute());
	        	LocalDateTime hfin3 = sheet.getRow(fila).getCell(20).getLocalDateTimeCellValue();
	        	c.setHoraFin(hfin3.getHour() + ":" + hfin3.getMinute());
	        	em.persist(c);
	        }
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
