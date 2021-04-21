package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.ExpedienteException;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Interfaces.InterfazTitulacion;

public class TitulacionT {
	
	@PersistenceContext(name="Grupo_L")
	private EntityManager em;
	
	private static final String Titulacion_EJB="java:global/classes/TitulacionEJB";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazTitulacion titulacion;
    
	@Before
	public void setUp() throws Exception {
		titulacion = (InterfazTitulacion) SuiteTest.ctx.lookup(Titulacion_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testConsultarTitulacion() {
		try {
			Titulacion t = titulacion.consultarTitulacion((long) 1);
			assertEquals("Grado de Ingeniería Informática", t.getNombre());
		} catch (TitulacionException e) {
			fail("No deberia lanzar una excepcion");
		}		
	}
	

	@Test
	public void testImportarTitulacion() {
		try {
			titulacion.importarTitulacion();
			Titulacion t = em.find(Titulacion.class, (long) 1041);
			assertEquals(1,t);
		} catch (TitulacionException e) {
			fail("No debería lanzarse excepción");
		}
	}
}
