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
import es.uma.informatica.sii.ejb.practica.BaseDatos;
import es.uma.informatica.sii.ejb.practica.ejb.GestionLotes;
import es.uma.informatica.sii.ejb.practica.ejb.GestionProductos;
import es.uma.informatica.sii.ejb.practica.ejb.exceptions.TrazabilidadException;
import es.uma.informatica.sii.ejb.practica.entidades.Lote;

public class AlumnoTest {
	private static final String Alumnos_EJB="java:global/classes/AlumnosEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
    private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	private static EJBContainer ejbContainer;
	private static Context ctx;
	private Alumno alumno;
    
    @BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}

	@Before
	public void setUp() throws Exception {
		alumno = (Alumno) ctx.lookup(Alumnos_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	
	public void eliminarAlumno() {
		/*try {
			
			List<Alumno>  lotes = alumno.obtenerLotesDeProducto(nombreProducto);
			
			Alumno al = al.get(0);
			
			gestionLotes.eliminarLote(nombreProducto, lote1);
			
			lotes = alumno.;
			assertEquals(1, lotes.size());
			
		} catch (AlumnoException e) {
			fail("No debería lanzarse excepción");
		}
		*/
	}

}
