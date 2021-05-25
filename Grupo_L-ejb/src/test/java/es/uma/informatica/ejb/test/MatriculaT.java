package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import es.uma.informatica.Entidades.Matricula;
import es.uma.informatica.Entidades.Matricula.MatriculaId;
import es.uma.informatica.Exception.MatriculaException;
import es.uma.informatica.Interfaces.InterfazMatricula;
import es.uma.informatica.sii.anotaciones.Requisitos;

public class MatriculaT {
	private static final String Matricula_EJB="java:global/classes/MatriculaEJB";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazMatricula matricula;

	@Before
	public void setUp() throws Exception {
		matricula = (InterfazMatricula) SuiteTest.ctx.lookup(Matricula_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	/*
	 * @Test
	 * 
	 * @Requisitos({"RF3"}) public void testImportarMatricula() { try {
	 * matricula.importarMatricula(); MatriculaId matricula1 = new
	 * MatriculaId("Primero",(long)33); Matricula m=
	 * matricula.leerMatricula(matricula1);
	 * assertEquals("Primero",m.getCurso_Academico()); } catch (MatriculaException
	 * e) { fail("No debería lanzarse excepción"); } }
	 */
	
	@Test
	@Requisitos({"RF22"})
	public void testLeerMatricula() {
		try {
			MatriculaId matricula1 = new MatriculaId("Primero",(long)33);
			Matricula ma = matricula.leerMatricula(matricula1);
			if(((long)33 != ma.getEM().getNum_Expediente())){
				fail("No deberia lanzar excepcion");
			}
		}catch(MatriculaException m){
			fail("No deberia lanzar excepcion");
		}
	}
}
