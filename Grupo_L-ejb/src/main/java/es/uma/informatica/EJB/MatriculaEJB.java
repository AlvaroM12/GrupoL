package es.uma.informatica.EJB;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.sql.Date;
import java.text.ParseException;
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
import es.uma.informatica.Entidades.Usuario;
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
	public void importarMatricula(String path) throws ParseException{
		try {
			LOGGER.info("PATH DEL ARCHIVO --------------------- " + path);
			
			File f = new File(path);
			LOGGER.info("--------------------- FILE CREADA");
		    InputStream inp = new FileInputStream(f);
		    Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheet("Hoja1");
	        
	        Matricula m = new Matricula();
	        Expediente e = new Expediente();
	       
	        LOGGER.info("--------------------- ANTES DEL FOR");
	        for(int fila=4; fila<sheet.getLastRowNum(); fila++) {
	        	LOGGER.info("--------------------- dentro DEL FOR");
	        	String nExp = sheet.getRow(fila).getCell(4).getStringCellValue();
	        	long nE= Long.parseLong(nExp);
	        	e.setNum_Expediente(nE);
	        	m.setEM(e);
	        	LOGGER.info("--------------------- exp");
	        	Long Narchivo = (long) sheet.getRow(fila).getCell(5).getNumericCellValue();
	        	m.setNum_Archivo(Narchivo);
	        	LOGGER.info("--------------------- num arch");
	        	
	        	
	        	String fmat = sheet.getRow(fila).getCell(14).getStringCellValue();
	        	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	        	Date parsed = (Date) formatter.parse(fmat);
	        	java.sql.Date sql = new java.sql.Date(parsed.getTime());
	        	m.setFecha_De_Matricula(sql);
	        	
	        	
	        	
	        	LOGGER.info("--------------------- date");
	        	String turnoPref = sheet.getRow(fila).getCell(15).getStringCellValue();
	        	m.setTurno_Preferente(turnoPref);
	        	LOGGER.info("--------------------- FILA LEIDA");
	        	em.persist(m);
	        	LOGGER.info("--------------------- FILA IMPORTADA");
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
	
	@Override
    public List<Matricula> buscarMatriculas(Expediente Exp) throws MatriculaException{
 
    	TypedQuery <Matricula> query = em.createQuery("SELECT a FROM Matricula a "
    			+ "WHERE a.EM LIKE : expediente", Matricula.class);
    	query.setParameter("expediente", Exp);
    	List<Matricula> list = query.getResultList();
		
		return list;    	
    }
}
