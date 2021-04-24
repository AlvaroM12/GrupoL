package es.uma.informatica.ejb.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.Entidades.Titulacion;
import es.uma.informatica.Exception.DatosException;
import es.uma.informatica.Interfaces.InterfazDatos;
import es.uma.informatica.sii.anotaciones.Requisitos;

public class DatosT{
	
	private static final String Datos_EJB="java:global/classes/DatosEJB";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazDatos dato;
	
	@Before
	public void setUp() throws Exception {
		dato = (InterfazDatos) SuiteTest.ctx.lookup(Datos_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	@Requisitos({"RF19"})
	public void testExportarDatos() throws DatosException, IOException {
		Titulacion GII = new Titulacion((long)1, "Grado de Ingeniería Informática", (long) 240);
		//Titulacion GIS = new Titulacion((long)52, "Grado de Ingeniería del Software", (long) 240);
		dato.exportarDatos(GII);
	}
}
