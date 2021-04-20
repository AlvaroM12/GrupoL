package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Usuario;
import es.uma.informatica.Exception.UsuarioException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Interfaces.InterfazUsuario;

public class UsuarioTest {
	
	private static final String Usuario_EJB="java:global/classes/UsuarioEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazUsuario usuario;

	@Before
	public void setUp() throws Exception {
		usuario = (InterfazUsuario) SuiteTest.ctx.lookup(Usuario_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testCrearUsuario() {
		try {
			Usuario u1 = new Usuario ((long) 11, (long) 664184557, "18752");
			usuario.crearUsuario(u1);
			Usuario al = usuario.leerUsuario(u1.getID()); 
			assertEquals(1,al);
			
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGenerarNuevaContraseña() {
		
	}
	
	@Test
	public void testSolicitarRecuperarContraseña() {
		
	}
}
