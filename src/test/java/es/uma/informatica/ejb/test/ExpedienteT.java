package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Matrícula;
import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Interfaces.InterfazExpediente;

public class ExpedienteT {
	
	
	private static final String Expediente_EJB="java:global/classes/ExpedienteEJB";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazExpediente expediente;
    

	@Before
	public void setUp() throws Exception {
		expediente = (InterfazExpediente) SuiteTest.ctx.lookup(Expediente_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}


	@Test
	public void testImportarExpediente() {
		try {
			expediente.importarExpediente();
			Expediente ex = expediente.leerExpediente((long) 104200001);
			assertEquals(1,ex);
		} catch (ExpedienteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerExpediente() {
		fail("Not implemented yet");
	}
}
