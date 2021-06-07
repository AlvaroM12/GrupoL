package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Interfaces.InterfazExpediente;
import es.uma.informatica.sii.anotaciones.Requisitos;

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
	@Ignore
	@Requisitos({"RF6"})
	public void testImportarExpediente() throws IOException {
		try {
			String directorio_de_ejecucion_de_la_aplicacion; 
			directorio_de_ejecucion_de_la_aplicacion = new java.io.File( "." ).getCanonicalPath();
			String sFile = directorio_de_ejecucion_de_la_aplicacion + "/" +"Datos alumnadoFAKE.xlsx";
			expediente.importarExpediente(new File(sFile));
			Expediente ex = expediente.leerExpediente((long) 104200001);
			if((long)104200001 != ex.getNum_Expediente()) {
				fail("No deberia lanzar excepcion1");
			}
		} catch (ExpedienteException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	@Requisitos({"RF28"})
	public void testLeerExpediente() {
		try {
			Expediente exp = expediente.leerExpediente((long) 12);
			if((long)12 != exp.getNum_Expediente()) {
				fail("No deberia lanzar excepcion1");
			}
		
		} catch (ExpedienteException e) {
			fail("No deberia lanzar excepcion2");
		}
	}
}
