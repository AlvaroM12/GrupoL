package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.Entidades.Asignaturas_Matrícula;
import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Entidades.Matrícula;
import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.GrupoExistenteException;
import es.uma.informatica.Interfaces.InterfazEncuesta;
import es.uma.informatica.Interfaces.InterfazGrupo;
import es.uma.informatica.Interfaces.InterfazMatricula;


public class GrupoT {
	
	@PersistenceContext(name="Grupo_L")
	private EntityManager em;
	
	private static final String Grupos_EJB = "java:global/classes/GrupoEJB";
	private static final String Matricula_EJB = "java:global/classes/MatriculaEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazMatricula matricula;
	private InterfazGrupo grupo;
	private InterfazEncuesta encuesta;

	@Before
	public void setUp() throws Exception {
		grupo = (InterfazGrupo) SuiteTest.ctx.lookup(Grupos_EJB);
		matricula = (InterfazMatricula) SuiteTest.ctx.lookup(Matricula_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testCrearGrupo(){
		try {
			Grupo g = new Grupo((long) 78, (long) 4, "B", "mañana", "no", (long) 8, (long) 0, (long) 50);
			grupo.crearGrupo(g);
			Grupo gr = grupo.leerGrupo(g.getID());
			assertEquals(1,gr);
			
		}catch(GrupoExistenteException e) {
			fail("Los valores para encuestaID no son validos");
		}catch(GrupoException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerGrupo(){
		try {
            Grupo g = grupo.leerGrupo((long) 1);
            assertEquals("A",g.getLetra());

        }catch(GrupoException g) {
            fail("No deberia lanzar una excepcion");
        }
	}
	
	@Test
	public void testActualizarGrupo(){
		try {
			Grupo g1 = new Grupo ((long) 1, (long) 1, "A", "tarde", "si", (long) 8, (long) 75, (long) 80);
            grupo.actualizarGrupo(g1);;
            Grupo g2 = grupo.leerGrupo(g1.getID());
            if(!g2.getID().equals(g1.getID())) {
            	fail("Error al actualizar");
            }
        }catch(GrupoException g) {
            fail("Lanza excepcion al actualizar");
        }
	}
	
	@Test
	public void testEliminarGrupo() {
		/*try {
			/*Grupo gr = grupo.leerGrupo(1);
			grupo.eliminarGrupo(g, a);
			Alumno alumno2 = alumno.leerAlumno(al.getDNI());
            assertEquals(null,alumno2.getID());
			
		} catch (AlumnoNullException e) {
			fail("No debería lanzarse excepción");
		}
	}*/
	}
	
	@Test
	public void testSolicitarCambioDeGrupo() {
		try {
			 
			Encuesta en=new Encuesta((long)14);
			String causa="Coincide con otra asignatura";
			encuesta.responderEncuesta(causa, en);
			
			
		} catch (EncuestaException e) {
			
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testSolicitarGrupo() {
		try {
			Grupo A = new Grupo((long) 1, (long) 1, "A", "tarde", "si", (long) 8, (long) 75, (long) 80);
			Expediente e1 = new Expediente ( (long) 12, "activo", (float)8.75, (long) 120, (long) 60, (long) 60, (long) 0, (long) 0, (long) 0, (long)0);
			Matrícula m1 = new Matrícula ("Primero", "activo", (long) 5, "tarde", new Date(14/03/2020), "si", "Cálculo, Matemáticas Discretas, Álgebra",e1);
			
			grupo.solicitarGrupo(A, m1);
			
		}catch(GrupoException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testAsignarGrupo() {
		try {
			Grupo A = new Grupo((long) 1, (long) 1, "A", "tarde", "si", (long) 8, (long) 75, (long) 80);
			Expediente e1 = new Expediente ( (long) 12, "activo", (float)8.75, (long) 120, (long) 60, (long) 60, (long) 0, (long) 0, (long) 0, (long)0);
			Matrícula m1 = new Matrícula ("Primero", "activo", (long) 5, "tarde", new Date(14/03/2020), "si", "Cálculo, Matemáticas Discretas, Álgebra", e1);
			
			grupo.asignarGrupo(A, m1);
			Grupo B = grupo.leerGrupo(A.getID());
			List<Asignaturas_Matrícula> l1 = B.getAsignaturasMatriculas();
			Matrícula m = em.find(Matrícula.class, m1.getEM());
			List<Asignaturas_Matrícula> l2 = m.getAsigMatricula();
			if(!l1.equals(l2)) {
				fail("No debería lanzarse excepción");
			}
		}catch(GrupoException e) {
			fail("No debería lanzarse excepción");
		}
	}
}
