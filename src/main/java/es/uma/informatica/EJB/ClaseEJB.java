package es.uma.informatica.EJB;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Clase;
import es.uma.informatica.Entidades.Clase.ClaseId;
import es.uma.informatica.Entidades.Grupo;
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
	public void Importar_Horario() throws ClaseException {
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
	        Grupo g = new Grupo();
	        
	        for(int fila=1; fila<row.getRowNum(); fila++) {
	        	
	        	Long ref = (long) sheet.getRow(fila).getCell(3).getNumericCellValue();
	        	a = em.find(Asignatura.class, ref);
	        	c.setAC(a);
	        	
	        	String dia = sheet.getRow(fila).getCell(12).getStringCellValue();
	        	c.setDia(dia);
	        	
	        	String hini = sheet.getRow(fila).getCell(13).getStringCellValue();    	
	        	c.setHoraInicio(hini);
	        	
	        	String hfin = sheet.getRow(fila).getCell(14).getStringCellValue();
	        	c.setHoraFin(hfin);
	        	em.persist(c);
	        	
	        	String dia2 = sheet.getRow(fila).getCell(15).getStringCellValue();
	        	c.setDia(dia2);
	        	
	        	String hini2 = sheet.getRow(fila).getCell(16).getStringCellValue();
	        	c.setHoraInicio(hini2);
	        	
	        	String hfin2 = sheet.getRow(fila).getCell(17).getStringCellValue();
	        	c.setHoraFin(hfin2);
	        	em.persist(c);
	        	
	        	String dia3 = sheet.getRow(fila).getCell(18).getStringCellValue();
	        	c.setDia(dia3);
	        	
	        	String hini3 = sheet.getRow(fila).getCell(19).getStringCellValue();
	        	c.setHoraInicio(hini3);
	        	
	        	String hfin3 = sheet.getRow(fila).getCell(20).getStringCellValue();
	        	c.setHoraFin(hfin3);
	        	
	        	Long idGrupo = (long)sheet.getRow(fila).getCell(21).getNumericCellValue();
	        	g = em.find(Grupo.class, idGrupo);
	        	c.setGC(g);
	        	em.persist(c);
	        }
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public Clase leerClase(ClaseId cl) throws ClaseException {
		Clase c = em.find(Clase.class, cl );
		if(c==null) {
			throw new ClaseException();
		}
		return c;
	}

	
}
