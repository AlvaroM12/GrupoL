package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.EJB.AlumnoEJB;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.AlumnoExistenteException;
import es.uma.informatica.Interfaces.InterfazAlumno;


public class AlumnoTest {
	
	@PersistenceContext(name="Alumno")
    private EntityManager em;
	
	private static final String Alumnos_EJB="java:global/classes/AlumnosEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
    private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	private static EJBContainer ejbContainer;
	private static Context ctx;
	private InterfazAlumno alumno;
    
    @BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}

	@Before
	public void setUp() throws Exception {
		alumno = (InterfazAlumno) ctx.lookup(Alumnos_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testCrearAlumno() {
		try {
			Alumno a = new Alumno("22222222M", "Bruno", "Martin", "Gonzalez", "bruno@uma.es", "brunito@gmail.com", 
					(long) 666666666, "Calle Florencia", "Torremolinos", "Malaga", (long) 29620);
			alumno.crearAlumno(a);
			Alumno al = alumno.leerAlumno("22222222M");
			
		}catch(AlumnoExistenteException e) {
			fail("Los valores para encuestaID no son validos");
		}catch(AlumnoException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerAlumno() {
		try {
            Alumno a = alumno.leerAlumno("78456235Q");
            assertEquals("Juan",a.getNombre());

        }catch(AlumnoException e) {
            fail("No deberia lanzar una excepcion");

        }
	}
	
	@Test
	public void testActualizarAlumno() {
		try {
			Alumno a1 = new Alumno ("78456235Q", "Juan", "Caba", "Merino", "jsm@uma.es", "juansm@gmail.com", (long) 654789123, "calle rio duero", "Benalmádena", "Málaga", (long)29561);
            alumno.actualizarAlumno(a1);
            Alumno a = em.find(Alumno.class, "78456235Q");
            if(!a.getApellido1().equalsIgnoreCase(a1.getApellido1())) {
            	fail("Error al actualizar");
            }
        }catch(AlumnoException e) {
            fail("Lanza excepcion al actualizar");
        }
	}
	
	@Test
	public void testEliminarAlumno() {
		try {
			Alumno al = alumno.leerAlumno("78456235Q");
			alumno.eliminarAlumno(al);
			Alumno alumno2 = alumno.leerAlumno(al.getDNI());
            assertEquals(null,alumno2.getID());
			
		} catch (AlumnoException e) {
			fail("No debería lanzarse excepción");
		}
		
	}
	@AfterClass
	public static void tearDownClass() {
		if(ejbContainer != null) {
			ejbContainer.close();
		}
	}
}
