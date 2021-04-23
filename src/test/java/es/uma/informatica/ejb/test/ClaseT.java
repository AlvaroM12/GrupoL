package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Clase;
import es.uma.informatica.Entidades.Clase.ClaseId;
import es.uma.informatica.Exception.AsignaturaException;
import es.uma.informatica.Exception.ClaseException;
import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Interfaces.InterfazClase;

public class ClaseT {
	
	
	
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
			clase.Importar_Horario();
			ClaseId clase1 = new ClaseId("Lunes","08:45:00",(long)1);
			Clase c = clase.leerClase(clase1);
			assertEquals("Lunes",c.getDia());
		} catch (ClaseException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerClase() throws ClaseException {
		
		try {
			ClaseId clase1 = new ClaseId("Lunes","08:45:00",(long)1);
			Clase cl = clase.leerClase(clase1);
			if(cl == null) {
				fail("No deberia lanzar excepcion");
			} 
		} catch (ClaseException e) {
				fail("No deberia lanzar excepcion2");
		}
	}
}
