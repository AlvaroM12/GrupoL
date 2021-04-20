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
	
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";

	private InterfazAsignatura asig;
	
	

	@Before
	public void setUp() throws Exception {
		asig = (InterfazAsignatura) SuiteTest.ctx.lookup(Asignatura_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testImportarAsignatura() {
		fail("Not yet implemented");
	}

}
