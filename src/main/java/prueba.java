import java.io.IOException;
import org.apache.poi.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.charts.XSSFScatterChartData;

import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Titulacion;

public class prueba {

	public static void main(String[] args) throws IOException {
		String directorio_de_ejecucion_de_la_aplicacion = new java.io.File( "." ).getCanonicalPath();
        System.out.println("Real path " + directorio_de_ejecucion_de_la_aplicacion);
        String sFile = directorio_de_ejecucion_de_la_aplicacion + "/" +"Oferta asignaturas.xlsx";  
        XSSFWorkbook workbook = new XSSFWorkbook(sFile);
        XSSFSheet sheet = workbook.getSheet("GII");
        Asignatura a = new Asignatura();
        Titulacion t = new Titulacion();
        XSSFRow row = sheet.getRow(0);
        
        	Long tit = (long) sheet.getRow(1).getCell(0).getNumericCellValue();
        	t.setCódigo(tit);
        	a.setTA(t);
        	String ofertada = sheet.getRow(1).getCell(1).getStringCellValue();
        	a.setOfertada(ofertada);
        	Long cod = (long) sheet.getRow(1).getCell(2).getNumericCellValue();
        	a.setCodigo(cod);
        	Long ref = (long) sheet.getRow(1).getCell(3).getNumericCellValue();
        	a.setReferencia(ref);
        	String nombre = sheet.getRow(1).getCell(4).getStringCellValue();
        	a.setNombre(nombre);
        	Long curso = (long) sheet.getRow(1).getCell(5).getNumericCellValue();
        	a.setCurso(curso);
        	Long credt = (long) sheet.getRow(1).getCell(6).getNumericCellValue();
        	a.setCréditos_Teoricos(credt);
        	Long credp = (long) sheet.getRow(1).getCell(7).getNumericCellValue();
        	a.setCréditos_Practicos(credp);
        	Long cred = (long) sheet.getRow(1).getCell(8).getNumericCellValue();
        	a.setTotal_Créditos(cred);
        	String cuatri = sheet.getRow(1).getCell(9).getStringCellValue();
        	a.setCuatrimestre(cuatri);
        	String plazas = sheet.getRow(1).getCell(10).getStringCellValue();
        	a.setPlazas(plazas);
        	String idioma = sheet.getRow(1).getCell(11).getStringCellValue();
        	a.setIdioma_de_imparticion(idioma);  
        	System.out.println(a);
        
	}

}
