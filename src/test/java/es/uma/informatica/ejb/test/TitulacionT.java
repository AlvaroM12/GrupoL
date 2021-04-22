package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;



import org.junit.Before;

import org.junit.Ignore;
import org.junit.Test;


import es.uma.informatica.Entidades.Titulacion;

import es.uma.informatica.Exception.TitulacionException;

import es.uma.informatica.Interfaces.InterfazTitulacion;

public class TitulacionT {
	
	
	
	private static final String Titulacion_EJB="java:global/classes/TitulacionEJB";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazTitulacion titulacion;
    
	@Before
	public void setUp() throws Exception {
		titulacion = (InterfazTitulacion) SuiteTest.ctx.lookup(Titulacion_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	@Ignore
	public void testConsultarTitulacion() {
		try {
			Titulacion t = titulacion.consultarTitulacion((long) 1);
			assertEquals("Grado de Ingeniería Informática", t.getNombre());
		} catch (TitulacionException e) {
			fail("No deberia lanzar una excepcion");
		}		
	}
	

	@Test
	@Ignore
	public void testImportarTitulacion() {
		try {
			titulacion.importarTitulacion();
			Titulacion t = titulacion.leerTitulacion((long) 1041);
			assertEquals(1,t);
		} catch (TitulacionException e) {
			fail("No debería lanzarse excepción");
		}
	}
}
