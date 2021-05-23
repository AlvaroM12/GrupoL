package es.uma.informatica.EJB;

import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Matrícula;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.AlumnoNullException;
import es.uma.informatica.Exception.AsignaturaException;
import es.uma.informatica.Interfaces.InterfazAsignatura;

/**
 * Session Bean implementation class Asignatura
 */
@Stateless
public class AsignaturaEJB implements InterfazAsignatura {

	@PersistenceContext(name="Grupo_L")
	private EntityManager em;

	@Override
	public void importarAsignatura() throws AsignaturaException {
		try {
			String directorio_de_ejecucion_de_la_aplicacion;
			directorio_de_ejecucion_de_la_aplicacion = new java.io.File( "." ).getCanonicalPath();
			String sFile = directorio_de_ejecucion_de_la_aplicacion + "/" +"Oferta asignaturas.xlsx"; 
			XSSFWorkbook workbook = new XSSFWorkbook(sFile);
	        XSSFSheet sheet = workbook.getSheet("GII");
	       	        
	    	for(int fila=1; fila<83; fila++) {
	        	
	        	Asignatura a = new Asignatura();
	 	        Titulacion t = new Titulacion();
	        	
	        	Long tit = (long) sheet.getRow(fila).getCell(0).getNumericCellValue();
	        	t = em.find(Titulacion.class, tit);
	        	a.setTA(t);
	        	
	        	String ofertada = sheet.getRow(fila).getCell(1).getStringCellValue();
	        	a.setOfertada(ofertada);
	        	
	        	Long cod = (long) sheet.getRow(fila).getCell(2).getNumericCellValue();
	        	a.setCodigo(cod);
	        	
	        	Long ref = (long) sheet.getRow(fila).getCell(3).getNumericCellValue();
	        	a.setReferencia(ref);
	        	
	        	String nombre = sheet.getRow(fila).getCell(4).getStringCellValue();
	        	a.setNombre(nombre);
	        	
	        	Long curso = (long) sheet.getRow(fila).getCell(5).getNumericCellValue();
	        	a.setCurso(curso);
	        	
	        	Long credt = (long) sheet.getRow(fila).getCell(6).getNumericCellValue();
	        	a.setCréditos_Teoricos(credt);
	        	
	        	Long credp = (long) sheet.getRow(fila).getCell(7).getNumericCellValue();
	        	a.setCréditos_Practicos(credp);
	        	
	        	Long cred = (long) sheet.getRow(fila).getCell(8).getNumericCellValue();
	        	a.setTotal_Créditos(cred);
	        	
	        	String cuatri = sheet.getRow(fila).getCell(9).getStringCellValue();
	        	a.setCuatrimestre(cuatri);
	        	
	        	String plazas = sheet.getRow(fila).getCell(10).getStringCellValue();
	        	a.setPlazas(plazas);
	        	
	        	String idioma = sheet.getRow(fila).getCell(11).getStringCellValue();
	        	a.setIdioma_de_imparticion(idioma);
	        	em.persist(a);        
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Asignatura leerAsignatura(Long ref) throws AsignaturaException {
		Asignatura a = em.find(Asignatura.class, ref );
		if(a==null) {
			throw new AsignaturaException();
		}
		return a;
		
	}

	@Override
	public List<Asignatura> leerAsignaturas() {
		TypedQuery <Asignatura> query = em.createQuery("SELECT a FROM Asignatura a ", Asignatura.class);
    	List<Asignatura> list = query.getResultList();
		return list;
	}
	
	@Override
	public void eliminarAsignatura(Long ref) throws AsignaturaException{
		Asignatura a = leerAsignatura(ref);
		if(a == null) {
			throw new NullPointerException();
		}
		em.remove(a);		
	}
}
