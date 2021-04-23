package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;


import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Asignaturas_Matrícula;
import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Entidades.Matrícula;
import es.uma.informatica.Entidades.Matrícula.MatriculaId;
import es.uma.informatica.Entidades.Asignaturas_Matrícula.Asignaturas_MatriculaId;
import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Exception.GrupoErrorException;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.GrupoExistenteException;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazEncuesta;
import es.uma.informatica.Interfaces.InterfazGrupo;
import es.uma.informatica.Interfaces.InterfazMatricula;


public class GrupoT {
	
	
	
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
			Grupo g = new Grupo((long) 13, (long) 3, "A", "tarde", "no", (long) 5, (long) 6, (long) 30);
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
		try {
			Grupo gr = grupo.leerGrupo((long)1);
			grupo.eliminarGrupo(gr);
			Grupo gr2 = grupo.leerGrupo((long)1);
			//MatriculaId m = new MatriculaId("Primero", (long) 33);
			//Asignaturas_MatriculaId a = new Asignaturas_MatriculaId ((long) 1, m);
			//Asignaturas_Matrícula gr3 = grupo.leerGrupoAsignatura(a);
			if(gr2==null) {
            	fail("No deberia lanzar una excepcion2");
            }
			
		} catch (GrupoException e) {
			fail("No debería lanzarse excepción");
		}
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
			Matrícula m = matricula.leerMatricula(m1.getCurso_Academico());
			List<Asignaturas_Matrícula> l2 = m.getAsigMatricula();
			if(!l1.equals(l2)) {
				fail("No debería lanzarse excepción");
			}
		}catch(GrupoException e) {
			fail("No debería lanzarse excepción");
		} catch (MatriculaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLeerAsignaturaMatricula(){
		try {
			//Expediente e1 = new Expediente ( (long) 12, "activo", (float)8.75, (long) 120, (long) 60, (long) 60, (long) 0, (long) 0, (long) 0, (long)0);
			//Matrícula m1 = new Matrícula ("Primero", "activo", (long) 5, "tarde", new Date(14/03/2020), "si", "Cálculo, Matemáticas Discretas, Álgebra", e1);
			//Asignatura Calculo = new Asignatura((long) 1, (long) 123, (long) 5, (long) 1, (long) 6, "Sí", "Cálculo", (long) 1, "50", "Primer Cuatrimestre", "Español");
			MatriculaId m = new MatriculaId("Primero", (long) 33);
			Asignaturas_MatriculaId a = new Asignaturas_MatriculaId ((long) 1, m);
			Asignaturas_Matrícula am = grupo.leerGrupoAsignatura(a);
            if(am==null) {
            	fail("No deberia lanzar una excepcion");
            }

        }catch(GrupoException g) {
            fail("No deberia lanzar una excepcion2");
        }
	}
}
