package es.uma.informatica.EJB;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Interfaces.InterfazExpediente;

/**
 * Session Bean implementation class Expediente
 */
@Stateless
public class ExpedienteEJB implements InterfazExpediente {

	@PersistenceContext(name="Grupo_L")
	private EntityManager em;
	
	private final static Logger LOGGER=Logger.getLogger(MatriculaEJB.class.getCanonicalName());

	@Override
	public void importarExpediente(File fichero) throws ExpedienteException {
		
		try {
			
			/*String directorio_de_ejecucion_de_la_aplicacion;
			directorio_de_ejecucion_de_la_aplicacion = new java.io.File( "." ).getCanonicalPath();
			String sFile = directorio_de_ejecucion_de_la_aplicacion + "/" +"Datos alumnadoFAKE.xlsx"; */
			Workbook wb = WorkbookFactory.create(fichero);	// El path ya te da el nombre incluido
	        Sheet sheet = wb.getSheet("Hoja1");
	        
	        
	        for(int fila=4; fila<5; fila++) {
	        	
	        	Expediente e = new Expediente();
		        Alumno a = new Alumno();
		        Titulacion t = new Titulacion();
	        	
	        	String alum = sheet.getRow(fila).getCell(0).getStringCellValue();
	        	Long id = (long)sheet.getRow(fila).getCell(25).getNumericCellValue();
	        	a.setID(id);
	        	a.setDNI(alum);	
	        	
	        	e.setAE(a);
	        	
	        	String Num_Expediente = sheet.getRow(fila).getCell(4).getStringCellValue();
	        	LOGGER.info(Num_Expediente);
	        	e.setNum_Expediente(Long.parseLong(Num_Expediente));
	        	
	        	String Nota_Media = sheet.getRow(fila).getCell(17).getStringCellValue();
	        	e.setNota_Media(Float.parseFloat(Nota_Media));
	        	
	        	e.setActivo("Si");
	        	
	        	String Creditos_Superados = sheet.getRow(fila).getCell(18).getStringCellValue();
	        	e.setCreditos_Superados(Double.parseDouble(Creditos_Superados));
	        	
	        	String Creditos_FB = sheet.getRow(fila).getCell(19).getStringCellValue();
	        	e.setCreditos_FB(Double.parseDouble(Creditos_FB));
	        	
	        	String Creditos_OB = sheet.getRow(fila).getCell(20).getStringCellValue();
	        	e.setCreditos_OB(Double.parseDouble(Creditos_OB));
	        	
	        	String Creditos_OP = sheet.getRow(fila).getCell(21).getStringCellValue();
	        	e.setCreditos_OP(Double.parseDouble(Creditos_OP));
	        	
	        	String Creditos_CF = sheet.getRow(fila).getCell(22).getStringCellValue();
	        	e.setCreditos_CF(Double.parseDouble(Creditos_CF));
	        	
	        	String Creditos_PE = sheet.getRow(fila).getCell(23).getStringCellValue();
	        	e.setCreditos_PE(Double.parseDouble(Creditos_PE));
	        	
	        	String Creditos_TF = sheet.getRow(fila).getCell(24).getStringCellValue();
	        	e.setCreditos_TF(Double.parseDouble(Creditos_TF));
	        	
	        	String tit = sheet.getRow(fila).getCell(26).getStringCellValue();
	        	t.setCodigo(Long.valueOf(tit));
	        	e.setTE(t);
	        	
	        	em.merge(e);
	        }
	      wb.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public Expediente leerExpediente(Long num) throws ExpedienteException {
		Expediente e = em.find(Expediente.class, num );
		if(e==null) {
			throw new ExpedienteException();
		}
		return e;
	}

	@Override
    public List<Expediente> leerExpedientes() throws ExpedienteException{
 
    	TypedQuery <Expediente> query = em.createQuery("SELECT a FROM Expediente a ", Expediente.class);
    	List<Expediente> list = query.getResultList();
		
		return list;    	
    }
}
