import java.io.IOException;
import org.apache.poi.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.charts.XSSFScatterChartData;

import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Clase;
import es.uma.informatica.Entidades.Titulacion;

public class prueba {

	public static void main(String[] args) throws IOException {
		String directorio_de_ejecucion_de_la_aplicacion = new java.io.File( "." ).getCanonicalPath();
        System.out.println("Real path " + directorio_de_ejecucion_de_la_aplicacion);
        String sFile = directorio_de_ejecucion_de_la_aplicacion + "/" +"Oferta asignaturas.xlsx";  
        XSSFWorkbook workbook = new XSSFWorkbook(sFile);
        XSSFSheet sheet = workbook.getSheet("GII");
        Clase c = new Clase();
        Asignatura a = new Asignatura();
        XSSFRow row = sheet.getRow(0);
        
        Long ref = (long) sheet.getRow(1).getCell(3).getNumericCellValue();
        a.setReferencia(ref);
    	c.setAC(a);
    	String dia = sheet.getRow(1).getCell(12).getStringCellValue();
    	c.setDia(dia);
    	String hini = sheet.getRow(1).getCell(13).getStringCellValue();
    	c.setDia(hini);
    	String hfin = sheet.getRow(1).getCell(14).getStringCellValue();
    	c.setDia(hfin);
    	System.out.println(c);
    	String dia2 = sheet.getRow(1).getCell(15).getStringCellValue();
    	c.setDia(dia2);
    	String hini2 = sheet.getRow(1).getCell(16).getStringCellValue();
    	c.setDia(hini2);
    	String hfin2 = sheet.getRow(1).getCell(17).getStringCellValue();
    	c.setDia(hfin2);
    	System.out.println(c);
    	String dia3 = sheet.getRow(1).getCell(18).getStringCellValue();
    	c.setDia(dia3);
    	String hini3 = sheet.getRow(1).getCell(19).getStringCellValue();
    	c.setDia(hini3);
    	String hfin3 = sheet.getRow(1).getCell(20).getStringCellValue();
    	c.setDia(hfin3);
    	System.out.println(c);
        
	}

}
