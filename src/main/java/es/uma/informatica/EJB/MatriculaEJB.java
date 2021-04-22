package es.uma.informatica.EJB;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.tools.example.debug.expr.ParseException;

import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.AlumnoExistenteException;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazMatricula;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Matrícula;

/**
 * Session Bean implementation class Matrícula
 */
@Stateless
public class MatriculaEJB implements InterfazMatricula {
	
	@PersistenceContext(name="Grupo_L")
	private EntityManager em;

	@Override
	public void importarMatricula() throws MatriculaException {
		try {
			String directorio_de_ejecucion_de_la_aplicacion = new java.io.File( "." ).getCanonicalPath();
			String sFile = directorio_de_ejecucion_de_la_aplicacion + "/" +"Datos alumnadoFAKE.xlsx"; 
			XSSFWorkbook workbook = new XSSFWorkbook(sFile);
	        XSSFSheet sheet = workbook.getSheet("Hoja1");
	        XSSFRow row = sheet.getRow(0);
	        XSSFCell cell = null;
	        Matrícula m = new Matrícula();
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	m.setFecha_De_Matrícula(date);
	        	String turnoPref = sheet.getRow(4).getCell(15).getStringCellValue();
	        	m.setTurno_Preferente(turnoPref);
	        	em.persist(m);;
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Matrícula leerMatricula (String Curso_Academico) throws MatriculaException {
		Matrícula m = em.find(Matrícula.class, Curso_Academico );
		if(m==null) {
			throw new MatriculaException();
		}
		return m;
	}
}
