package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import es.uma.informatica.Entidades.Clase;
import es.uma.informatica.Exception.ClaseException;
import es.uma.informatica.Interfaces.InterfazClase;

public class ClaseT {
	
	
	
	private static final String Clase_EJB="java:global/classes/ClaseEJB";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazClase clase;

	@Before
	public void setUp() throws Exception {
		clase = (InterfazClase) SuiteTest.ctx.lookup(Clase_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testImportarHorario() throws ClaseException {
		try {
			clase.Importar_Horario();
			Clase c = clase.leerClase("lunes");
			assertEquals("lunes",c.getDia());
		} catch (ClaseException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerClase() throws ClaseException {
		fail("Not implemented yet");
	}
}
