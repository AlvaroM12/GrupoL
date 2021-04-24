package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.junit.Before;

import org.junit.Test;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Usuario;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.UsuarioException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.Interfaces.InterfazUsuario;
import es.uma.informatica.sii.anotaciones.Requisitos;

public class UsuarioT {
	
	private static final String Usuario_EJB="java:global/classes/UsuarioEJB";
	private static final String Alumno_EJB="java:global/classes/AlumnoEJB";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
	private InterfazUsuario usuario;
	private InterfazAlumno alumno;

	@Before
	public void setUp() throws Exception {
		usuario = (InterfazUsuario) SuiteTest.ctx.lookup(Usuario_EJB);
		alumno = (InterfazAlumno) SuiteTest.ctx.lookup(Alumno_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	@Requisitos({"RF13"})
	public void testCrearUsuario() {
		try {
			Usuario u1 = new Usuario ((long) 1, (long) 664184557, "18752");
			usuario.crearUsuario(u1);
			Usuario al = usuario.leerUsuario(u1.getID()); 
			if((long)1 != al.getID()) {
				fail("No debería lanzarse excepción");
			}
			
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Requisitos({"RF215"})
	public void testLeerUsuario() {
		try {
            Usuario u = usuario.leerUsuario((long) 9);
            if((long)9 != u.getID()) {
				fail("No debería lanzarse excepción");
			}

        }catch(UsuarioException e) {
            fail("No deberia lanzar una excepcion");
        }
	}
	
	@Test
	@Requisitos({"RF12"})
	public void testValidarAcceso() {
		try {
			Alumno a = alumno.leerAlumno((long) 9);
			usuario.validarAcceso(a.getEmail_Personal(),a.getContraseña());
		} catch (AlumnoException e) {
			fail("No debería lanzarse excepción");
		} catch (UsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	@Requisitos({"RF15"})
	public void testSolicitarRecuperarContraseña() {
		try {
			Alumno a = new Alumno ((long)41, (long)664184557, "njevpnev","45698712R", "Marta", "Molero", "Santiago", "mms@uma.es", "martams@gmail.com",
								   (long) 632547891, "calle margarita", "Torremolinos", "Málaga", (long)29620);
			usuario.solicitarRecuperarContraseña(a.getEmail_Personal());
			
		} catch (UsuarioException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	@Requisitos({"RF18"})
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
			Usuario u = new Usuario((long)9, (long)664184557, "njevpnev");
			usuario.generarNuevaContraseña(u, pass);
			Usuario u2=usuario.leerUsuario(u.getID());
			if(!encriptado.equals(u2.getContraseña())) {
				fail("No debería lanzarse excepción1");
			}		
		} catch (UsuarioException e) {
			fail("No debería lanzarse excepción2");
		}	
	}
}
