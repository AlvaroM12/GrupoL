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
import es.uma.informatica.Entidades.Matrícula;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Interfaces.InterfazMatricula;

public class MatriculaTest {
	@PersistenceContext(name="Matricula")
	private EntityManager em;
	private static final String Matricula_EJB="java:global/classes/MatriculaEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
    private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	private static EJBContainer ejbContainer;
	private static Context ctx;
	private InterfazMatricula matricula;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}

	@Before
	public void setUp() throws Exception {
		matricula = (InterfazMatricula) ctx.lookup(Matricula_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testImportarMatricula() {
		try {
			matricula.importarMatricula();
			Matrícula m=em.find(Matrícula.class, (long) 104200001);
			assertEquals(1,m);
		} catch (MatriculaException e) {
			
			fail("No debería lanzarse excepción");
		}
		
		
	}

}
