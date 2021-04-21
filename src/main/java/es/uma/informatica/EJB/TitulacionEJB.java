package es.uma.informatica.EJB;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Exception.TitulacionNullException;
import es.uma.informatica.Interfaces.InterfazTitulacion;

/**
 * Session Bean implementation class Titulacion
 */
@Stateless
public class TitulacionEJB implements InterfazTitulacion{

	@PersistenceContext(name="Grupo_L")
	private EntityManager em;

	@Override
	public Titulacion consultarTitulacion(Long codigo) throws TitulacionException {
		Titulacion ti=em.find(Titulacion.class,  codigo);
		if(ti==null) {
			throw new TitulacionNullException();
		}
		return ti;
	}

	@Override
	public void importarTitulacion() throws TitulacionException {		
		try {
			String directorio_de_ejecucion_de_la_aplicacion = new java.io.File( "." ).getCanonicalPath();
			String sFile = directorio_de_ejecucion_de_la_aplicacion + "/" +"Titulacion.xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook(sFile);
	        XSSFSheet sheet = workbook.getSheet("Hoja1");
	        XSSFRow row = sheet.getRow(0);
	        XSSFCell cell = null;
	        Titulacion t = new Titulacion();
	        
	        for(int fila=1; fila<row.getRowNum(); fila++) {
	        	Long codigo = (long) sheet.getRow(fila).getCell(0).getNumericCellValue();
	        	t.setCódigo(codigo);
	        	String nombre =  sheet.getRow(fila).getCell(1).getStringCellValue();
	        	t.setNombre(nombre);
	        	Long creditos = (long) sheet.getRow(fila).getCell(2).getNumericCellValue();
	        	t.setCréditos(creditos);
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
