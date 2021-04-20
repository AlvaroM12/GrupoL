package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Interfaces.InterfazEncuesta;

public class EncuestaTest {
	private static final String Encuesta_EJB="java:global/classes/EncuestaEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
    private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	private static EJBContainer ejbContainer;
	private static Context ctx;
	private InterfazEncuesta encuesta;
    
    @BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}

	@Before
	public void setUp() throws Exception {
		encuesta = (InterfazEncuesta) ctx.lookup(Encuesta_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}


	@Test
	public void testResponderEncuesta() {
		try {
			Encuesta EleccionGrupo = new Encuesta ((long) 14);
			String texto = "Hola";
			encuesta.responderEncuesta(texto,EleccionGrupo);
		}catch(EncuestaException e){
			fail("Not yet implemented");
		}
	}
}
