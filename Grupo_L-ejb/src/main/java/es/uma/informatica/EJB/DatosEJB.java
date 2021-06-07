package es.uma.informatica.EJB;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.GruposPorAsignatura;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.DatosException;
import es.uma.informatica.Interfaces.InterfazDatos;

/**
 * Session Bean implementation class DatosEJB
 */
@Stateless
public class DatosEJB implements InterfazDatos{
	
	@PersistenceContext(name="Grupo_L")
	private EntityManager em;
	
	private final static Logger LOGGER=Logger.getLogger(DatosEJB.class.getCanonicalName());

	public void exportarDatos(Titulacion t) throws DatosException, IOException{
		try{
        	// Sacando datos de la bd
			
        	TypedQuery <Asignatura> query = em.createQuery("SELECT a FROM Asignatura a "+ "WHERE a.TA LIKE : titula", Asignatura.class);
    		query.setParameter("titula", t);
        	List<Asignatura> asigList = query.getResultList();
			
        	// Creacion archivo
			XSSFWorkbook workbook = new XSSFWorkbook();
	        
			// Creacion subcategorías por hojas 
			for (Asignatura a : asigList) {
				LOGGER.info("Asignatura "+ a);
				creacionHojasExcel(workbook, t,  a);
			}
			
	        // Exportacion archivo
	        System.out.println("Exportando Archivo");
			try (FileOutputStream file = new FileOutputStream("/opt/jboss/wildfly/docs/Exportacion.xls")){
				workbook.write(file);
			}   
			workbook.close();
			
        }catch (NullPointerException n) {
        	n.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
		Path origenPath = FileSystems.getDefault().getPath("/opt/jboss/wildfly/docs/Exportacion.xls");
		File f = origenPath.toFile();
		LOGGER.info("fichero existe" + f.exists()) ;
	}
	

	private void creacionHojasExcel(XSSFWorkbook workbook, Titulacion t, Asignatura asig) throws DatosException, IOException {
		XSSFSheet sheet = workbook.createSheet(asig.getNombre());
		
        CellStyle headerStyle = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);
        
        XSSFRow titulacionHeader = sheet.createRow(0);
        XSSFCell titulacionCell = titulacionHeader.createCell(0);
        titulacionCell.setCellStyle(headerStyle);
        titulacionCell.setCellValue("Titulación: " + t.getNombre());
        
     // Rellenar con los grupos correspondientes
        List<GruposPorAsignatura> gpaList = asig.getGruposPorAsignatura();
        XSSFRow headerRow = sheet.createRow(2);
        int i=0;
        for (GruposPorAsignatura gr : gpaList) {
            if(gr.getA_GPA().getCodigo().equals(asig.getCodigo())) {
            	XSSFCell cell = headerRow.createCell(i);
                cell.setCellStyle(headerStyle);
                cell.setCellValue("Grupo " + gr.getG_GPA().getLetra());
            }
            i++;
        }
        
        // Rellenar con los datos de los alumnos correspondientes
	    int fila = 2;
        for (GruposPorAsignatura gr : gpaList) {
        	List<Expediente> eList = gr.getG_GPA().getTG().getExpedientes();
        	for (Expediente e : eList) {
            	XSSFRow dataRow = sheet.createRow(fila + 1);
            	dataRow.createCell(0).setCellValue(e.getAE().getDNI());
    			fila++;
    		}
        }
	}
}