package es.uma.informatica.EJB;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Asignaturas_Matricula;
import es.uma.informatica.Entidades.Clase;
import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Clase.ClaseId;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Entidades.Matricula;
import es.uma.informatica.Exception.ClaseException;
import es.uma.informatica.Interfaces.InterfazClase;

/**
 * Session Bean implementation class Clase
 */
@Stateless
public class ClaseEJB implements InterfazClase{

	@PersistenceContext(name="Clase")
	private EntityManager em;
	
	private final static Logger LOGGER=Logger.getLogger(ClaseEJB.class.getCanonicalName());

	
	@Override
	public void Importar_Horario(File fichero) throws ClaseException {
		try {
			Workbook wb = WorkbookFactory.create(fichero);
	        Sheet sheet = wb.getSheet("GII");
	        
	        for(int fila=1; fila<5; fila++) {
	        	
	        	Clase c = new Clase();
		        Asignatura a = new Asignatura();
		        Grupo g = new Grupo();
		        
		        Long idGrupo = (long)sheet.getRow(fila).getCell(21).getNumericCellValue();
	        	g.setID(idGrupo);
	        	
	        	Long ref = (long) sheet.getRow(fila).getCell(3).getNumericCellValue();
	        	a.setReferencia(ref);
	        	c.setAC(a);
	        	
	        	String dia = sheet.getRow(fila).getCell(12).getStringCellValue();
	        	c.setDia(dia);
	        	
	        	String hini = sheet.getRow(fila).getCell(22).getStringCellValue();    	
	        	c.setHoraInicio(hini);
	        	
	        	String hfin = sheet.getRow(fila).getCell(23).getStringCellValue();
	        	c.setHoraFin(hfin);
	        	c.setGC(g);
	        	em.merge(c);
	        	c.setAC(a);
	        	
	        	String dia2 = sheet.getRow(fila).getCell(15).getStringCellValue();
	        	c.setDia(dia2);
	        	
	        	String hini2 = sheet.getRow(fila).getCell(24).getStringCellValue();
	        	c.setHoraInicio(hini2);
	        	
	        	String hfin2 = sheet.getRow(fila).getCell(25).getStringCellValue();
	        	c.setHoraFin(hfin2);
	        	c.setGC(g);
	        	em.merge(c);
	        	c.setAC(a);
	        	
	        	String dia3 = sheet.getRow(fila).getCell(18).getStringCellValue();
	        	c.setDia(dia3);
	        	
	        	String hini3 = sheet.getRow(fila).getCell(26).getStringCellValue();
	        	c.setHoraInicio(hini3);
	        	
	        	String hfin3 = sheet.getRow(fila).getCell(27).getStringCellValue();
	        	c.setHoraFin(hfin3);
	        	
	        	
	        	c.setGC(g);
	        	em.merge(c);
	        }
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public Clase leerClase(ClaseId cl) throws ClaseException {
		Clase c = em.find(Clase.class, cl );
		if(c==null) {
			throw new ClaseException();
		}
		return c;
	}
	
	
	@Override
	public List<Clase> leerClasesAlumno(Alumno al) throws ClaseException {
						  	      
	
		TypedQuery <Expediente> query = em.createQuery("SELECT e FROM Expediente e " + "WHERE e.AE LIKE : alumno", Expediente.class);
        query.setParameter("alumno", al);
        List<Expediente> listExpediente = query.getResultList();
        List<Asignaturas_Matricula> listAsigMatricula = new ArrayList <Asignaturas_Matricula>();
		List<Clase> listClase = new ArrayList <Clase>();
		
    	
		for(Expediente expediente : listExpediente) {
			TypedQuery <Asignaturas_Matricula> query3 = em.createQuery("SELECT en FROM Asignaturas_Matricula en " + "WHERE en.EM LIKE : ex", Asignaturas_Matricula.class);
            query3.setParameter("ex", expediente.getNum_Expediente());
            listAsigMatricula = query3.getResultList();
	    
				for (Asignaturas_Matricula asigmatricula : listAsigMatricula) {
					TypedQuery <Asignatura> query4 = em.createQuery("SELECT a FROM Asignatura a " + "WHERE a.Referencia LIKE : asigmatricula", Asignatura.class);
			    	query4.setParameter("asigmatricula", asigmatricula.getAsignatura().getReferencia());
			    	List<Asignatura> listAsignaturas = query4.getResultList();
			    	
			    	
					for (Asignatura asignatura : listAsignaturas) {
						TypedQuery <Clase> query5 = em.createQuery("SELECT a FROM Clase a " + "WHERE a.AC LIKE : asignatura", Clase.class);
				    	query5.setParameter("asignatura", asignatura);
				    	List<Clase> listClase2 = query5.getResultList();
				    	
						for (Clase clase : listClase2) {
							listClase.add(clase);
						}
					}
				}
			}
		
		
    	
    	return listClase;	
	}

	
}
