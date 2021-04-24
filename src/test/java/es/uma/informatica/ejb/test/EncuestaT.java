package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Entidades.Encuesta.EncuestaId;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.AlumnoExistenteException;
import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Interfaces.InterfazEncuesta;

public class EncuestaT {
	
	private static final String Encuesta_EJB="java:global/classes/EncuestaEJB";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazEncuesta encuesta;

	@Before
	public void setUp() throws Exception {
		encuesta = (InterfazEncuesta) SuiteTest.ctx.lookup(Encuesta_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testResponderEncuesta() {
		try {
			
			EncuestaId id = new EncuestaId((long) 12,(long)14);
			Encuesta EleccionGrupo = encuesta.leerEncuesta(id);
			String texto = "Hola";
			encuesta.responderEncuesta(texto, EleccionGrupo);
		}catch(EncuestaException e){
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test	
	public void testLeerEncuesta() {
		try {
			EncuestaId id = new EncuestaId((long) 12,(long)14);
			Encuesta EleccionGrupo = encuesta.leerEncuesta(id);
            if((long)14 != EleccionGrupo.getFecha_De_Envío()) {
            	fail("No esta");
            }
		} catch (EncuestaException e) {
			fail("No debería lanzarse excepción");
		}
	}
}
