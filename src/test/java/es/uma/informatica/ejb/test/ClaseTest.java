package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.Interfaces.InterfazClase;

public class ClaseTest {
	private static final String Clase_EJB="java:global/classes/ClaseEJB";
	
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazClase clase;
	

	@Before
	public void setUp() throws Exception {
		clase = (InterfazClase) SuiteTest.ctx.lookup(Clase_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
