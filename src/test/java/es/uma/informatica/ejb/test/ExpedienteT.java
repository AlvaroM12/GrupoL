package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Matrícula;
import es.uma.informatica.Exception.AsignaturaException;
import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazAlumno;
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
	@Requisitos({"RF6"})
	public void testImportarExpediente() {
		try {
			expediente.importarExpediente();
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
