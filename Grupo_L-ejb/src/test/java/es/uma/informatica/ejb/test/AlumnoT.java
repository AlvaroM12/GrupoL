package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.junit.Ignore;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.AlumnoExistenteException;
import es.uma.informatica.Interfaces.InterfazAlumno;
import es.uma.informatica.sii.anotaciones.Requisitos;


public class AlumnoT {
	
	private static final String Alumnos_EJB="java:global/classes/AlumnoEJB";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
    private InterfazAlumno alumno;
    
	@Before
	public void setUp() throws Exception {
		alumno = (InterfazAlumno) SuiteTest.ctx.lookup(Alumnos_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	@Requisitos({"RF1"})
	public void testCrearAlumno() {
		try {
			Alumno a = new Alumno((long)4, (long)664184557, "njevpnev","22222222M", "Bruno", "Martin", "Gonzalez", "bruno@uma.es", "brunito@gmail.com", 
					 (long) 666666666, "Calle Florencia", "Torremolinos", "Malaga", (long) 29620);
			alumno.crearAlumno(a);
			Alumno al = alumno.leerAlumno(a.getID());
			if((long)4 != al.getID()) {
				fail("No debería lanzarse excepción");
			}
			
		}catch(AlumnoExistenteException e) {
			fail("Los valores no son validos");
		}catch(AlumnoException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	@Requisitos({"RF1"})
	public void testLeerAlumno() {
		try {
            Alumno a = alumno.leerAlumno((long)9);
            assertEquals("78456235Q",a.getDNI());

        }catch(AlumnoExistenteException e) {
            fail("No deberia lanzar una excepcion");
        } catch (AlumnoException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Requisitos({"RF1"})
	public void testActualizarAlumno() {
		try {
			Alumno a1 = new Alumno ((long)9, (long)664184557, "njevpnev","78456235Q", "Juan", "Caba", "Merino", "jsm@uma.es", "juansm@gmail.com", (long) 654789123, "calle rio duero", "Benalmádena", "Málaga", (long)29561);
            alumno.actualizarAlumno(a1);
            Alumno a =alumno.leerAlumno(a1.getID());
            if(!a.getApellido1().equalsIgnoreCase(a1.getApellido1())) {
            	fail("Error al actualizar");
            }
        }catch(AlumnoException e) {
            fail("Lanza excepcion al actualizar");
        }
	}
	
	
	@Test
	@Ignore
	@Requisitos({"RF1"})
	public void testEliminarAlumno() {
		
			final Long id = (long) 9;
			try {
				alumno.eliminarAlumno(id);
			
			assertThrows(AlumnoExistenteException.class, ()->alumno.leerAlumno(id));
			} catch (AlumnoException e) {
				fail("Lanza excepcion al actualizar");
			}
		 
	}
}
