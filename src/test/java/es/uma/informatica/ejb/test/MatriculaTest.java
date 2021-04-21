package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.Entidades.Matrícula;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazMatricula;

public class MatriculaTest {
	
	@PersistenceContext(name="Grupo_L")
	private EntityManager em;
	
	private static final String Matricula_EJB="java:global/classes/MatriculaEJB";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazMatricula matricula;

	@Before
	public void setUp() throws Exception {
		matricula = (InterfazMatricula) SuiteTest.ctx.lookup(Matricula_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testImportarMatricula() {
		try {
			matricula.importarMatricula();
			Matrícula m=em.find(Matrícula.class, (long) 104200001);
			assertEquals(1,m);
		} catch (MatriculaException e) {
			fail("No debería lanzarse excepción");
		}
	}
}
