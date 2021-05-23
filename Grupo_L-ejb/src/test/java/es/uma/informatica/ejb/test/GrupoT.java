package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Asignaturas_Matricula;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Entidades.Matricula;
import es.uma.informatica.Entidades.Matricula.MatriculaId;
import es.uma.informatica.Entidades.Asignaturas_Matricula.Asignaturas_MatriculaId;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.GrupoExistenteException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Interfaces.InterfazGrupo;
import es.uma.informatica.sii.anotaciones.Requisitos;


public class GrupoT {
	private static final String Grupos_EJB = "java:global/classes/GrupoEJB";
	private static final String Alumno_EJB = "java:global/classes/AlumnoEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazAlumno alumno;
	private InterfazGrupo grupo;

	@Before
	public void setUp() throws Exception {
		grupo = (InterfazGrupo) SuiteTest.ctx.lookup(Grupos_EJB);
		alumno = (InterfazAlumno) SuiteTest.ctx.lookup(Alumno_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	@Requisitos({"RF5"})
	public void testCrearGrupo(){
		try {
			Grupo g = new Grupo((long) 13, (long) 5, "F", "tarde", "no", (long) 5, (long) 6, (long) 30);
			grupo.crearGrupo(g);
			Grupo gr = grupo.leerGrupo(g.getID());
			if((long)13 != gr.getID()) {
				fail("No debería lanzarse excepción");
			}
		}catch(GrupoExistenteException e) {
			fail("Los valores no son validos");
		}catch(GrupoException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	@Requisitos({"RF5"})
	public void testLeerGrupo(){
		try {
            Grupo g = grupo.leerGrupo((long) 1);
            assertEquals("A",g.getLetra());

        }catch(GrupoException g) {
            fail("No deberia lanzar una excepcion");
        }
	}
	
	@Test
	@Requisitos({"RF5"})
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
	@Ignore
	@Requisitos({"RF5"})
	public void testEliminarGrupo() {
		try {
			Grupo gr = grupo.leerGrupo((long)78);
			grupo.eliminarGrupo(gr);
			
			//MatriculaId m = new MatriculaId("Primero", (long) 33);
			//Asignaturas_MatriculaId a = new Asignaturas_MatriculaId ((long) 1, m);
			//Asignaturas_Matrícula gr3 = grupo.leerGrupoAsignatura(a);
			assertEquals(null,gr.getID());
			
		} catch (GrupoException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	
	@Test
	@Requisitos({"RF9"})
	public void testSolicitarCambioGrupo() {
		try {
			Grupo A = grupo.leerGrupo((long)1);
			Alumno Juan = alumno.leerAlumno((long)9);	
			Asignatura Calculo = new Asignatura((long) 89, (long) 123, (long) 5, (long) 1, (long) 6, "Sí", "Cálculo", (long) 1, "50", "Primer Cuatrimestre", "Español");
			grupo.solicitarCambioGrupo("Hola", A, Juan, Calculo);
			
		}catch(GrupoException e) {
			fail("No debería lanzarse excepción");
		} catch (AlumnoException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	@Requisitos({"RF10"})
	public void testSolicitarGrupo() {
		try {
			Grupo A = new Grupo((long) 1, (long) 1, "A", "tarde", "si", (long) 8, (long) 75, (long) 80);
			Alumno Juan = alumno.leerAlumno((long)9);			
			grupo.solicitarGrupo(A,Juan);
			
		}catch(GrupoException e) {
			fail("No debería lanzarse excepción");
		} catch (AlumnoException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	@Requisitos({"RF11"})
	public void testAsignarGrupo() {
		try {
			Alumno Juan = alumno.leerAlumno((long)9);
			grupo.asignarGrupo(Juan);
			Expediente e = Juan.getExpedientes().get(0);
			Matricula m = e.getMatriculas().get(0);
			Asignaturas_Matricula asigM = m.getAsigMatricula().get(0);
			Grupo g = asigM.getG_AM();
			assertNotEquals(g,null);
		} catch (GrupoException e) {
			fail("No debería lanzarse excepción");
		} catch (AlumnoException e1) {
			fail("No debería lanzarse excepción");
		}
		
		/*try {
			Grupo A = new Grupo((long) 1, (long) 1, "A", "tarde", "si", (long) 8, (long) 75, (long) 80);
			Expediente e1 = new Expediente ( (long) 12, "activo", (float)8.75, (long) 120, (long) 60, (long) 60, (long) 0, (long) 0, (long) 0, (long)0);
			Matrícula m1 = new Matrícula ("Primero", "activo", (long) 5, "tarde", new Date(14/03/2020), "si", La , e1);
			
			grupo.asignarGrupo(A, m1);
			Grupo B = grupo.leerGrupo(A.getID());
			List<Asignaturas_Matrícula> l1 = B.getAsignaturasMatriculas();
			Matrícula m = matricula.leerMatricula(m1.getCurso_Academico());
			List<Asignaturas_Matrícula> l2 = m.getAsigMatricula();
			if(!l1.equals(l2)) {
				fail("No debería lanzarse excepción");
			}
		}catch(GrupoException e) {
			fail("No debería lanzarse excepción");
		} catch (MatriculaException e) {
			e.printStackTrace();
		}*/
	}
	
	@Test
	@Requisitos({"RF21"})
	public void testLeerAsignaturaMatricula(){
		try {
			//Expediente e1 = new Expediente ( (long) 12, "activo", (float)8.75, (long) 120, (long) 60, (long) 60, (long) 0, (long) 0, (long) 0, (long)0);
			//Matrícula m1 = new Matrícula ("Primero", "activo", (long) 5, "tarde", new Date(14/03/2020), "si", "Cálculo, Matemáticas Discretas, Álgebra", e1);
			//Asignatura Calculo = new Asignatura((long) 1, (long) 123, (long) 5, (long) 1, (long) 6, "Sí", "Cálculo", (long) 1, "50", "Primer Cuatrimestre", "Español");
			MatriculaId m = new MatriculaId("Primero", (long) 33);
			Asignaturas_MatriculaId a = new Asignaturas_MatriculaId ((long) 1, m);
			Asignaturas_Matricula am = grupo.leerGrupoAsignatura(a);
            if(am==null) {
            	fail("No deberia lanzar una excepcion");
            }

        }catch(GrupoException g) {
            fail("No deberia lanzar una excepcion2");
        }
	}
}
