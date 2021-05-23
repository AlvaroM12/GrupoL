package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import es.uma.informatica.Entidades.Centro;
import es.uma.informatica.Exception.CentroException;
import es.uma.informatica.Interfaces.InterfazCentro;
import es.uma.informatica.sii.anotaciones.Requisitos;

public class CentroT {
	
	private static final String Centro_EJB="java:global/classes/CentroEJB";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazCentro centro;

	@Before
	public void setUp() throws Exception {
		centro = (InterfazCentro) SuiteTest.ctx.lookup(Centro_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	@Requisitos({"RF16"})
	public void testConsultarCentro() {
		try {
			Centro c = centro.ConsultarCentro((long) 1);
			if((long)1 != c.getID()) {
				fail("No coinciden los ID");
			}
		} catch (CentroException e) {
			fail("No debería lanzarse excepción");
		}		
	}
}
