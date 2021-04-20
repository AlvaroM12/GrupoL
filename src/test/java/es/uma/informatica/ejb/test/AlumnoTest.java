package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Interfaces.InterfazAlumno;


public class AlumnoTest {
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
	
	public void testeliminarAlumno() {
		try {
			Alumno a=new Alumno();
			a.setID((long)1);
			
			Alumno al = alumno.leerAlumno(a);
			
			alumno.eliminarAlumno(al);
			//revisar
			alumno.leerAlumno(al);
			
		} catch (AlumnoException e) {
			fail("No debería lanzarse excepción");
		}
		
	}

}
