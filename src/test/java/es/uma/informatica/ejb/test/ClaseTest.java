package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.Entidades.Clase;
import es.uma.informatica.Exception.ClaseException;
import es.uma.informatica.Interfaces.InterfazClase;

public class ClaseTest {
	
	@PersistenceContext(name="Clase")
	private EntityManager em;
	
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
			clase.Importar_Horario(null); 	// qué se le pone por parámetro como date
			Clase c = em.find(Clase.class, (long) 50658); 	// que se le pone como parametro
			assertEquals(1,c);
		} catch (ClaseException e) {
			fail("No debería lanzarse excepción");
		}
	}
}
