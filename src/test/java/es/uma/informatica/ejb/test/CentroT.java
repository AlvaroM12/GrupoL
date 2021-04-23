package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Properties;



import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import es.uma.informatica.Entidades.Centro;
import es.uma.informatica.Exception.CentroException;
import es.uma.informatica.Interfaces.InterfazCentro;

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
	public void testConsultarCentro() {
		try {
			Centro c = centro.ConsultarCentro((long) 1);
			assertEquals(1,c);
		} catch (CentroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
