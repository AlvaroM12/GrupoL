package es.uma.informatica.ejb.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.AlumnoExistenteException;
import es.uma.informatica.Interfaces.InterfazAlumno;


public class AlumnoT {
	
	private static final String Alumnos_EJB="java:global/classes/AlumnosEJB";
    private static final String UNIDAD_PERSITENCIA_PRUEBAS = "SecretariaTest";
	
    private InterfazAlumno alumno;
    
	@Before
	public void setUp() throws Exception {
		alumno = (InterfazAlumno) SuiteTest.ctx.lookup(Alumnos_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}

	@Test
	public void testCrearAlumno() {
		try {
			Alumno a = new Alumno("22222222M", "Bruno", "Martin", "Gonzalez", "bruno@uma.es", "brunito@gmail.com", 
					(long) 666666666, "Calle Florencia", "Torremolinos", "Malaga", (long) 29620);
			alumno.crearAlumno(a);
			Alumno al = alumno.leerAlumno("22222222M");
			assertEquals(1,al);
			
		}catch(AlumnoExistenteException e) {
			fail("Los valores para encuestaID no son validos");
		}catch(AlumnoException e) {
			fail("No debería lanzarse excepción");
		}
	}
	
	@Test
	public void testLeerAlumno() {
		try {
            Alumno a = alumno.leerAlumno("78456235Q");
            assertEquals("Juan",a.getNombre());

        }catch(AlumnoException e) {
            fail("No deberia lanzar una excepcion");
        }
	}
	
	@Test
	public void testActualizarAlumno() {
		try {
			Alumno a1 = new Alumno ("78456235Q", "Juan", "Caba", "Merino", "jsm@uma.es", "juansm@gmail.com", (long) 654789123, "calle rio duero", "Benalmádena", "Málaga", (long)29561);
            alumno.actualizarAlumno(a1);
            Alumno a =alumno.leerAlumno("78456235Q");
            if(!a.getApellido1().equalsIgnoreCase(a1.getApellido1())) {
            	fail("Error al actualizar");
            }
        }catch(AlumnoException e) {
            fail("Lanza excepcion al actualizar");
        }
	}
	
	@Test
	public void testEliminarAlumno() {
		try {
			Alumno al = alumno.leerAlumno("78456235Q");
			alumno.eliminarAlumno(al);
			Alumno alumno2 = alumno.leerAlumno(al.getDNI());
            assertEquals(null,alumno2.getID());
			
		} catch (AlumnoException e) {
			fail("No debería lanzarse excepción");
		}
	}
}