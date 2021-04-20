package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.AlumnoNullException;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.GrupoExistenteException;
import es.uma.informatica.Interfaces.InterfazGrupo;


public class GrupoTest {
	
	private static final String Grupos_EJB = "java:global/classes/GrupoEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazGrupo grupo;

	@Before
	public void setUp() throws Exception {
		grupo = (InterfazGrupo) SuiteTest.ctx.lookup(Grupos_EJB);
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
}
