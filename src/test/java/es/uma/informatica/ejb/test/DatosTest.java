package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.Interfaces.InterfazDatos;

public class DatosTest {
	
	private static final String Datos_EJB="java:global/classes/DatosEJB";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazDatos dato;
	
	@Before
	public void setUp() throws Exception {
		dato = (InterfazDatos) SuiteTest.ctx.lookup(Datos_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testExportarDatos() {
		fail("Not yet implemented");
	}

}
