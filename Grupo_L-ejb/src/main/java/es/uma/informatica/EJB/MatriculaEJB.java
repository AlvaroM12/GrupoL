package es.uma.informatica.EJB;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazMatricula;
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Asignaturas_Matricula;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.GruposPorAsignatura;
import es.uma.informatica.Entidades.Matricula;
import es.uma.informatica.Entidades.Titulacion;
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
	public void importarMatricula(File file) throws ParseException{
		try {
		    Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheet("Hoja1");
			
	        for(int fila=4; fila<5; fila++) {
	        	Matricula m = new Matricula();
		        Expediente e = new Expediente();
		        Asignaturas_Matricula am = new Asignaturas_Matricula();
		        Titulacion t = new Titulacion();
		        
	        	String curso = sheet.getRow(0).getCell(1).getStringCellValue();
	        	m.setCurso_Academico(curso);
	        	
	        	String Num_Expediente = sheet.getRow(fila).getCell(4).getStringCellValue();
	        	LOGGER.info(Num_Expediente);
	        	e.setNum_Expediente(Long.parseLong(Num_Expediente));
	        	m.setEM(e);
	        	
	        	Long Narchivo = (long) sheet.getRow(fila).getCell(5).getNumericCellValue();
	        	m.setNum_Archivo(Narchivo);
	        	
	        	String fecha = sheet.getRow(fila).getCell(14).getStringCellValue();
	        	DateFormat formatter = new SimpleDateFormat("DD/MM/YYYY hh:mm", Locale.ENGLISH);
	        	java.util.Date parsed = formatter.parse(fecha);
	        	m.setFecha_De_Matricula(parsed);
	        	
	        	String turnoPref = sheet.getRow(fila).getCell(15).getStringCellValue();
	        	m.setTurno_Preferente(turnoPref);
	        	
	        	
	        	String grupoAsig = sheet.getRow(fila).getCell(16).getStringCellValue();
	        	List<Asignatura> asig = new ArrayList<Asignatura>();
	        	
	        	Long tit = Long.valueOf(Num_Expediente.substring(0, 4));
	        	t.setCodigo(tit);
	        	
        		String[] parts = grupoAsig.split(",");
	        	for (String s : parts) {
	        		Asignatura a = new Asignatura();
	        		a.setReferencia(Long.valueOf(s));
	        		a.setTA(t);
	        		
	        		asig.add(a);
				}
	        	m.setA(asig);
	        	em.merge(m);
	        	
	        	for (Asignatura asignatura : asig) {
	        		List<GruposPorAsignatura> gpalist = new ArrayList<GruposPorAsignatura>();
	        		TypedQuery <GruposPorAsignatura> query = em.createQuery("SELECT g FROM GruposPorAsignatura g " + "WHERE g.A_GPA LIKE :as", GruposPorAsignatura.class);
	            	query.setParameter("as", asignatura);
	        		gpalist = query.getResultList();
	        		
	        		for (GruposPorAsignatura gpa : gpalist) {
						am.setMatricula(m);
						am.setAsignatura(asignatura);
						am.setG_AM(gpa.getG_GPA());
						em.merge(am);
					}
				}
	        }
	        wb.close();
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
	
	//METODO PARA LEER LAS MATRICULAS DESDE SECRETARIA
	@Override
    public List<Matricula> leerMatriculasSecretaria() throws MatriculaException{
 
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
