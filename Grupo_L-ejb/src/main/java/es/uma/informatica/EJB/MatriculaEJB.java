package es.uma.informatica.EJB;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazMatricula;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Matricula;

import es.uma.informatica.Entidades.Matricula.MatriculaId;

/**
 * Session Bean implementation class Matrícula
 */
@Stateless
public class MatriculaEJB implements InterfazMatricula {
	
	@PersistenceContext(name="Grupo_L")
	private EntityManager em;
	private final static Logger LOGGER=Logger.getLogger(MatriculaEJB.class.getCanonicalName());

	@Override
	public void importarMatricula(String fileName, String path){
		try {
			//String directorio_de_ejecucion_de_la_aplicacion = "/home/alumno/.cache/vmware/drag_and_drop/GCw5oe";
			//String sFile = path + "/" + fileName ; 
			LOGGER.info("PATH DEL ARCHIVO --------------------- " + path);
			
			
			Workbook wb = WorkbookFactory.create(new File(fileName));	// El path ya te da el nombre incluido
			//XSSFWorkbook workbook = new XSSFWorkbook(path);
	        Sheet sheet = wb.getSheet("Hoja1");
	        Row row = sheet.getRow(0);
	        //XSSFCell cell = null;
	        Matricula m = new Matricula();
	        Expediente e = new Expediente();
	        
	        for(int fila=4; fila<row.getRowNum(); fila++) {
	        	String nExp = sheet.getRow(4).getCell(4).getStringCellValue();
	        	long nE= Long.parseLong(nExp);
	        	e.setNum_Expediente(nE);
	        	m.setEM(e);
	        	Long Narchivo = (long) sheet.getRow(4).getCell(5).getNumericCellValue();
	        	m.setNum_Archivo(Narchivo);
	        	String fmat = sheet.getRow(4).getCell(14).getStringCellValue();
	        	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	        	Date date = null;
				try {
					date = (Date) formatter.parse(fmat);
				} catch (java.text.ParseException e1) {
					e1.printStackTrace();
				}
	        	m.setFecha_De_Matricula(date);
	        	String turnoPref = sheet.getRow(4).getCell(15).getStringCellValue();
	        	m.setTurno_Preferente(turnoPref);
	        	em.persist(m);;
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Matricula leerMatricula (MatriculaId ma) throws MatriculaException {
		Matricula m = em.find(Matricula.class, ma);
		if(m==null) {
			throw new MatriculaException();
		}
		return m;
	}
	
	@Override
    public List<Matricula> leerMatriculas() throws MatriculaException{
 
    	TypedQuery <Matricula> query = em.createQuery("SELECT a FROM Matricula a ", Matricula.class);
    	List<Matricula> list = query.getResultList();
		
		return list;    	
    }
}
