package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.Name;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Interfaces.InterfazAsignatura;

public class AsignaturaTest {
	private static final String Asignatura_EJB="java:global/classes/AsignaturaEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
    private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	private static EJBContainer ejbContainer;
	private static Context ctx;
	private InterfazAsignatura asig;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}

	@Before
	public void setUp() throws Exception {
		asig = (InterfazAsignatura) ctx.lookup(Asignatura_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testImportarAsignatura() {
		fail("Not yet implemented");
	}

}
