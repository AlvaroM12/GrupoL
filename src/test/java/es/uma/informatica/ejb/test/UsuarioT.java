package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Entidades.Usuario;
import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Exception.UsuarioException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Interfaces.InterfazUsuario;

public class UsuarioT {
	
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
		try {
			String pass="Hola";
			byte[] newPassword = null;
		    try {
		        newPassword = MessageDigest.getInstance("SHA").digest(pass.getBytes("UTF-8"));
		    } catch (NoSuchAlgorithmException e) {
		        e.printStackTrace();
		    } catch (UnsupportedEncodingException e) {
		        e.printStackTrace();
		    }
		    String encriptado = Base64.getEncoder().encodeToString(newPassword);
			Usuario u = new Usuario((long)7987, (long)664184557, "erfeghrweeg");
			usuario.generarNuevaContraseña(u, pass);
			Usuario u2=usuario.leerUsuario(u.getID());
			if(!encriptado.equals(u2.getContraseña())) {
				fail("No debería lanzarse excepción");
			}		
		} catch (UsuarioException e) {
			fail("No debería lanzarse excepción");
		}	
	}
	
	@Test
	public void testSolicitarRecuperarContraseña() {
		try {
			Alumno a = new Alumno ("45698712R", "Marta", "Molero", "Santiago", "mms@uma.es", "martams@gmail.com",
								   (long) 632547891, "calle margarita", "Torremolinos", "Málaga", (long)29620);
			usuario.solicitarRecuperarContraseña(a.getEmail_Personal());
			
		} catch (UsuarioException e) {
			fail("No debería lanzarse excepción");
		}
	}
}