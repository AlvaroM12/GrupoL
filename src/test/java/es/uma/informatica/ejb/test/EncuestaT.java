package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.Entidades.Encuesta;
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
			Encuesta EleccionGrupo = new Encuesta ((long) 14);
			String texto = "Hola";
			encuesta.responderEncuesta(texto,EleccionGrupo);
		}catch(EncuestaException e){
			fail("Not yet implemented");
		}
	}
}
