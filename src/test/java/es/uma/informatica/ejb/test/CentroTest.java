package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.Entidades.Centro;
import es.uma.informatica.Exception.CentroException;
import es.uma.informatica.Interfaces.InterfazCentro;

public class CentroTest {
	private static final String Centro_EJB="java:global/classes/CentroEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
    private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	private static EJBContainer ejbContainer;
	private static Context ctx;
	private InterfazCentro centro;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}

	@Before
	public void setUp() throws Exception {
		centro = (InterfazCentro) ctx.lookup(Centro_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testConsultarCentro() {
		try {
			Centro c = centro.ConsultarCentro((long) 1);
			assertEquals(1,c);
		} catch (CentroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
