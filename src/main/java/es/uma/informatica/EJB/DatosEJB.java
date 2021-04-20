package es.uma.informatica.EJB;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uma.informatica.Entidades.Asignaturas_Matrícula;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Entidades.GruposPorAsignatura;
import es.uma.informatica.Exception.DatosException;

/**
 * Session Bean implementation class DatosEJB
 */
@Stateless
public class DatosEJB {
	
	@PersistenceContext(name="Datos")
	private EntityManager em;

	public void exportarDatos() throws DatosException, IOException {

        try{
        	// Creacion archivo
			XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Hoja1");
	        
	        System.out.println("Creando headers");
	        String[] headers = new String[]{
	                "Curso",
	                "Letra",
	                "Turno",
	                "Ingles",
	                "Plazas",
	                "Alumno",
	                "Asignatura",
	                "Titulación"
	        };
	        CellStyle headerStyle = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        headerStyle.setFont(font);
	        
	        // Rellenar con los datos
	    
	        XSSFRow headerRow = sheet.createRow(0);
	        for (int i = 0; i < headers.length; ++i) {
	            String header = headers[i];
	            XSSFCell cell = headerRow.createCell(i);
	            cell.setCellStyle(headerStyle);
	            cell.setCellValue(header);
	        }
	        
	        TypedQuery<Asignaturas_Matrícula> query2 = em.createQuery("select * from Asignaturas_Matricula ;", Asignaturas_Matrícula.class);
	        List<Asignaturas_Matrícula> am = query2.getResultList();
	        
	        
	        int fila = 0;
	        for (Asignaturas_Matrícula a : am) {
	        	XSSFRow dataRow = sheet.createRow(fila + 1);
	        	dataRow.createCell(fila).setCellValue(a.getG_AM().getCurso());
	        	dataRow.createCell(fila).setCellValue(a.getG_AM().getLetra());
	        	dataRow.createCell(fila).setCellValue(a.getG_AM().getTurno_Mañana_Tarde());
	        	dataRow.createCell(fila).setCellValue(a.getG_AM().getIngles());
	        	dataRow.createCell(fila).setCellValue(a.getG_AM().getPlazas());
	        	dataRow.createCell(fila).setCellValue(a.getMatricula().getEM().getAE().getDNI());
	        	dataRow.createCell(fila).setCellValue(a.getAsignatura().getReferencia());
	        	dataRow.createCell(fila).setCellValue(a.getAsignatura().getTA().getCódigo());
	        	fila++;
			}
	        
	        // Exportacion archivo
	        System.out.println("Exportando Archivo");
			try (FileOutputStream file = new FileOutputStream("DatosGrupos.xls")){
				workbook.write(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}   
			
        }catch (NullPointerException n) {
        	n.printStackTrace();
        }
	}
}