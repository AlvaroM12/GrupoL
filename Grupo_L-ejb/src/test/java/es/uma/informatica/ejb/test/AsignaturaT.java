package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Exception.AsignaturaException;
import es.uma.informatica.Interfaces.InterfazAsignatura;
import es.uma.informatica.sii.anotaciones.Requisitos;

public class AsignaturaT {
	
	
	
	private static final String Asignatura_EJB="java:global/classes/AsignaturaEJB";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";

	private InterfazAsignatura asignatura;
	
	@Before
	public void setUp() throws Exception {
		asignatura = (InterfazAsignatura) SuiteTest.ctx.lookup(Asignatura_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Test
	@Requisitos({"RF2"})
	public void testImportarAsignatura() throws AsignaturaException {
		try {
			asignatura.importarAsignatura();
			Asignatura a = asignatura.leerAsignatura((long)50658);
			if((long)50658 != a.getReferencia()) {
				fail("No coinciden las referencias");
			}
		} catch (AsignaturaException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	@Requisitos({"RF26"})
	public void testLeerAsignatura() throws AsignaturaException {
		try {
			Asignatura asig = asignatura.leerAsignatura((long) 1);
			assertEquals("Cálculo", asig.getNombre());
		} catch (AsignaturaException e) {
			fail("No deberia lanzar excepcion");
		}
	}
	
}
