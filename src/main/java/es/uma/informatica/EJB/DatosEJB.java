package es.uma.informatica.EJB;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.metamodel.EntityType;

import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Asignaturas_Matrícula;
import es.uma.informatica.Entidades.Asignaturas_Matrícula.Asignaturas_MatriculaId;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Entidades.GruposPorAsignatura;
import es.uma.informatica.Entidades.Matrícula;
import es.uma.informatica.Entidades.Matrícula.MatriculaId;
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

	public void exportarDatos(Titulacion t) throws DatosException, IOException{
		try{
        	// Sacando datos de la bd
        	Asignatura a = em.find(Asignatura.class, (long)1);
        	
        	Query queryAsig = em.createQuery("SELECT a FROM Asignatura a");
        	List<Asignatura> asigList = queryAsig.getResultList();
        	
        	t.getAsignaturas();
        	// Creacion archivo
			XSSFWorkbook workbook = new XSSFWorkbook();
	        
			// Creacion subcategorías por hojas 
			// (Se crean todas las asignaturas por un fallo en la lista de asignaturas, me devuelve una asignatura repetida)
			if(asigList.get(0).getTA().getCódigo().equals(t.getCódigo())) {
				creacionHojasExcel(workbook, t,  asigList.get(0));
			}else if(asigList.get(1).getTA().getCódigo().equals(t.getCódigo())) {
				creacionHojasExcel(workbook, t,  asigList.get(1));
			}else if(asigList.get(2).getTA().getCódigo().equals(t.getCódigo())) {
				creacionHojasExcel(workbook, t,  asigList.get(2));
			}else {
				creacionHojasExcel(workbook, t,  asigList.get(3));
			}
			
	        // Exportacion archivo
	        System.out.println("Exportando Archivo");
			try (FileOutputStream file = new FileOutputStream("/home/alumno/eclipse-workspace/Grupo_L/ExportarDatos/" + t.getNombre() + ".xls")){
				workbook.write(file);
			} catch (FileNotFoundException f) {
				f.printStackTrace();
			}   
			workbook.close();
        }catch (NullPointerException n) {
        	n.printStackTrace();
        }
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