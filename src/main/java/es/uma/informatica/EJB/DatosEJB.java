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

import es.uma.informatica.Entidades.GruposPorAsignatura;
import es.uma.informatica.Exception.DatosException;
import es.uma.informatica.jpa.demo.Customer;

/**
 * Session Bean implementation class DatosEJB
 */
@Stateless
public class DatosEJB {
	
	@PersistenceContext(name="Datos")
	private EntityManager em;

	public void exportarDatos(GruposPorAsignatura gpa) throws DatosException, IOException {

        GruposPorAsignatura gpa_aux = em.find(GruposPorAsignatura.class, gpa.getClass());
        
        em.getTransaction().begin();
        
        // Hacer una consulta
        TypedQuery<GruposPorAsignatura> query = em.createQuery("select c from Customer c", GruposPorAsignatura.class);
        List<GruposPorAsignatura> resultado = query.getResultList();
        
        for (GruposPorAsignatura c : resultado) {
			System.out.println(c);
		}
        
/*         
        Address a = new Address();
        a.setCountry("Spain");
        a.setState("Andalucía");
        a.setStreet1("Calle");
        a.setZipcode("29071");
        a.setCity("Málaga");
        
        em.persist(a);
        
        Customer c = em.find(Customer.class, 1L);
        c.setAddress(a);	// Hacer una relación		*/
        
        
        try{
        	
        	// Creacion archivo
			XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Hoja1");
	        
	        String[] headers = new String[]{
	                "Curso Academico",
	                "Oferta",
	                "Asignatura",
	                "Grupo"               
	        };
	        CellStyle headerStyle = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        headerStyle.setFont(font);
	        
	        // Rellenar con los datos
	        
	        // cell.setCellValue("Hola esto es una prueba");
	        
	        XSSFRow headerRow = sheet.createRow(0);
	        for (int i = 0; i < headers.length; ++i) {
	            String header = headers[i];
	            XSSFCell cell = headerRow.createCell(i);
	            cell.setCellStyle(headerStyle);
	            cell.setCellValue(header);
	        }
	        
	        for (int i = 0; i < headers.length; ++i) {
	            XSSFRow dataRow = sheet.createRow(i + 1);
	
	            
	            Long curso = (long) gpa_aux.getCurso_Academico();
	            Long oferta = (long) gpa_aux.getOferta();
	            //Long asig = (long) gpa_aux.getA_GPA();
	            //Long grupo = (long) gpa_aux.getG_GPA();
	            if(curso == null || oferta == null) {
	            	dataRow.createCell(0).setCellValue("null");
	                dataRow.createCell(1).setCellValue("null");
	            }
	            else {
	            	dataRow.createCell(0).setCellValue(curso);
	            	dataRow.createCell(1).setCellValue(oferta);
	            }
            
	        }
	        
	        // Exportacion archivo
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