package es.uma.informatica.EJB;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	        

	        for(int fila=1; fila<83; fila++) {
	        	
	        	Clase c = new Clase();
		        Asignatura a = new Asignatura();
		        Grupo g = new Grupo();
	        	
	        	Long ref = (long) sheet.getRow(fila).getCell(3).getNumericCellValue();
	        	a.setReferencia(ref);
	        	c.setAC(a);
	        	
	        	String dia = sheet.getRow(fila).getCell(12).getStringCellValue();
	        	c.setDia(dia);
	        	
	        	String hini = sheet.getRow(fila).getCell(22).getStringCellValue();    	
	        	c.setHoraInicio(hini);
	        	
	        	String hfin = sheet.getRow(fila).getCell(23).getStringCellValue();
	        	c.setHoraFin(hfin);
	        	em.persist(c);
	        	
	        	String dia2 = sheet.getRow(fila).getCell(15).getStringCellValue();
	        	c.setDia(dia2);
	        	
	        	String hini2 = sheet.getRow(fila).getCell(24).getStringCellValue();
	        	c.setHoraInicio(hini2);
	        	
	        	String hfin2 = sheet.getRow(fila).getCell(25).getStringCellValue();
	        	c.setHoraFin(hfin2);
	        	em.persist(c);
	        	
	        	String dia3 = sheet.getRow(fila).getCell(18).getStringCellValue();
	        	c.setDia(dia3);
	        	
	        	String hini3 = sheet.getRow(fila).getCell(26).getStringCellValue();
	        	c.setHoraInicio(hini3);
	        	
	        	String hfin3 = sheet.getRow(fila).getCell(27).getStringCellValue();
	        	c.setHoraFin(hfin3);
	        	
	        	Long idGrupo = (long)sheet.getRow(fila).getCell(21).getNumericCellValue();
	        	g.setID(idGrupo);
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
