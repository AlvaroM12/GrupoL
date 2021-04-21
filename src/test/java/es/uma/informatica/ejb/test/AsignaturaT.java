package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Exception.AsignaturaException;
import es.uma.informatica.Interfaces.InterfazAsignatura;

public class AsignaturaT {
	
	@PersistenceContext(name="Grupo_L")
	private EntityManager em;
	
	private static final String Asignatura_EJB="java:global/classes/AsignaturaEJB";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";

	private InterfazAsignatura asignatura;
	
	@Before
	public void setUp() throws Exception {
		asignatura = (InterfazAsignatura) SuiteTest.ctx.lookup(Asignatura_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testImportarAsignatura() throws AsignaturaException {
		try {
			asignatura.importarAsignatura();
			Asignatura a = em.find(Asignatura.class, (long) 50658);
			assertEquals(1,a);
		} catch (AsignaturaException e) {
			fail("No debería lanzarse excepción");
		}
	}
}
