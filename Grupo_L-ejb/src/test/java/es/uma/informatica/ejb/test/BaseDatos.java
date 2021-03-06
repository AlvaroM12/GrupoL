package es.uma.informatica.ejb.test;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Asignaturas_Matricula;
import es.uma.informatica.Entidades.Centro;
import es.uma.informatica.Entidades.Clase;
import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Entidades.GruposPorAsignatura;
import es.uma.informatica.Entidades.Matricula;
import es.uma.informatica.Entidades.Optativa;
import es.uma.informatica.Entidades.Personal_de_secretaria;
import es.uma.informatica.Entidades.Titulacion;

public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Centro ETSII = new Centro ((long) 1, "Escula Técnica Superior de Ingeniería Informática", "calle Bulevar Louis Pasteur, 35", (long) 952132700);
		Centro EII = new Centro ((long) 2, "Escula de Ingenierías Industriales", "calle  Arquitecto Francisco Peñalosa, 6", (long) 951952350);
		Centro FD = new Centro ((long) 3, "Facultad de Derecho", "calle Bulevar Louis Pasteur, 26", (long) 952132101);
		Centro FFL = new Centro ((long) 4, "Facultad de Filosofía y Letras", "calle Bulevar Louis Pasteur, 27", (long) 952131688);

		
		Titulacion GII = new Titulacion((long)1, "Grado de Ingeniería Informática", (long) 240);
		Titulacion GIS = new Titulacion((long)52, "Grado de Ingeniería del Software", (long) 240);
		Titulacion GISa = new Titulacion((long)20, "Grado de Ingeniería de la Salud", (long) 240);
		Titulacion GIC = new Titulacion((long)30, "Grado de Ingeniería de Computadores", (long) 240);
		
		ETSII.setTC(Stream.of(GII, GIS, GISa, GIC).collect(Collectors.toList()));
		
		GII.setCentros(Stream.of(ETSII).collect(Collectors.toList()));
		GIS.setCentros(Stream.of(ETSII).collect(Collectors.toList()));
		GISa.setCentros(Stream.of(ETSII).collect(Collectors.toList()));
		GIC.setCentros(Stream.of(ETSII).collect(Collectors.toList()));
		
		for (Centro centro : new Centro [] { ETSII, EII, FD, FFL}) {
			em.persist(centro);
		}
		
		for (Titulacion titulacion : new Titulacion [] {GII, GIS, GISa, GIC}) {
			em.persist(titulacion);
		}


		Grupo A = new Grupo((long) 1, (long) 1, "A", "tarde", "si", (long) 8, (long) 75, (long) 80);
		Grupo B = new Grupo((long) 78, (long) 4, "B", "mañana", "no", (long) 8, (long) 0, (long) 50);
		Grupo C = new Grupo((long) 85, (long) 2, "C", "tarde", "si", (long) 8, (long) 1, (long) 45);
		Grupo D = new Grupo((long) 32, (long) 3, "D", "mañana", "no", (long) 8, (long) 3, (long) 55);

		A.setTG(GII);
		B.setTG(GISa);
		C.setTG(GIC);
		D.setTG(GIS);
		
		A.setGrupos(Stream.of(B).collect(Collectors.toList()));
		B.setGrupos(Stream.of(C).collect(Collectors.toList()));
		C.setGrupos(Stream.of(D).collect(Collectors.toList()));
		
		
		for (Grupo grupo: new Grupo [] {A,B,C,D}) {
			em.persist(grupo);
		}
		em.getTransaction().commit();
		em.getTransaction().begin();
		
		
		Alumno Juan = new Alumno ((long)9, (long)664184557, "njevpnev","78456235Q", "Juan", "Sanchez", "Merino", "jsm@uma.es", "juansm@gmail.com", (long) 654789123, "calle rio duero", "Benalmádena", "Málaga", (long)29561);
		Alumno Marta = new Alumno ((long)16, (long)664184557, "njevpnev","45698712R", "Marta", "Molero", "Santiago", "mms@uma.es", "martams@gmail.com", (long) 632547891, "calle margarita", "Torremolinos", "Málaga", (long)29620);
		Alumno Pedro = new Alumno ((long)15, (long)664184557, "njevpnev","78453692P", "Pedro", "Molina", "Caba", "pmc@uma.es", "pedromc@gmail.com", (long) 678945123, "calle san juan", "Fuengirola", "Málaga", (long)29568);
		Alumno Rocío = new Alumno ((long)7, (long)664184557, "njevpnev","12398754W", "Rocío", "Martín", "Carrasco", "rsm@uma.es", "rociomc@gmail.com", (long) 654789123, "calle ancha", "Álora", "Málaga", (long)29501);

		for (Alumno alumno : new Alumno [] {Juan, Marta, Pedro, Rocío}) {
			em.persist(alumno);
		}
		
		
		Asignatura Calculo = new Asignatura((long) 1, (long) 123, (long) 5, (long) 1, (long) 6, "Sí", "Cálculo", (long) 1, "50", "Primer Cuatrimestre", "Español");
		Asignatura PL = new Asignatura((long) 25, (long) 353, (long) 3, (long) 3, (long) 6, "Sí", "Procesadores de Lenguaje", (long) 3, "70", "Primer Cuatrimestre", "Ingles");
		Asignatura IIS = new Asignatura((long) 30, (long) 289, (long) 1, (long) 5, (long) 6, "No", "Introducción a Ingeniería del Software", (long) 2, "40", "Segundo Cuatrimestre", "Español");
		Asignatura Algebra = new Asignatura((long) 40, (long) 170, (long) 4, (long) 2, (long) 6, "No", "Álgebra", (long) 1, "90", "Segundo Cuatrimestre", "Ingles");

		Calculo.setTA(GIC);
		PL.setTA(GISa);
		IIS.setTA(GIS);
		Algebra.setTA(GII);
		
		for (Asignatura asignatura : new Asignatura [] {Calculo, PL, IIS, Algebra}) {
			em.persist(asignatura);
		}
		
		
		Clase Primera = new Clase ("Lunes","8:45","10:30");
		Clase Segunda = new Clase ("Martes","10:45","12:30");
		Clase Tercera = new Clase ("Jueves","12:45","14:30");
		
		Primera.setAC(Algebra);
		Segunda.setAC(IIS);
		Tercera.setAC(PL);
		
		Primera.setGC(C);
		Segunda.setGC(D);
		Tercera.setGC(B);
		
		for (Clase clase : new Clase [] {Primera, Segunda, Tercera}) {
			em.persist(clase);
		}
		
		
		
		
	
		Expediente e1 = new Expediente ( (long) 12, "activo", (float)8.75, (double) 120, (double) 60, (double) 60, (double) 0, (double) 0, (double) 0, (double)0);
		Expediente e2 = new Expediente ( (long) 80, "inactivo", (float)4.75, (double) 360, (double) 120, (double) 60, (double) 60, (double) 60, (double) 60, (double)0);
		Expediente e3 = new Expediente ( (long) 2, "activo", (float)5.32, (double) 240, (double) 120, (double) 60, (double) 60, (double) 0, (double) 0, (double)0);
		Expediente e4 = new Expediente ( (long) 33, "inactivo", (float)7.01, (double) 300, (double) 120, (double) 60, (double) 60, (double) 60, (double) 0, (double)0);
		
		
		Encuesta EleccionGrupo = new Encuesta (new Date(14/02/21));
		Encuesta EleccionCurso = new Encuesta ( new Date(15/02/21));
		Encuesta EleccionTurno = new Encuesta ( new Date(16/02/21));
		Encuesta EleccionClase = new Encuesta ( new Date(18/02/21));
		
		
		e1.setAE(Rocío);
		e2.setAE(Pedro);
		e3.setAE(Marta);
		e4.setAE(Juan);
		
		e1.setTE(GIC);
		e2.setTE(GISa);
		e3.setTE(GIS);
		e4.setTE(GII);
		
		for (Expediente expediente : new Expediente [] {e1, e2, e3, e4}) {
			em.persist(expediente);
		}
		List<Asignatura> La = Stream.of(Calculo, PL, IIS).collect(Collectors.toList());
		
		Matricula m1 = new Matricula ("Primero", "activo", (long) 5, "tarde", new Date(14/03/2020), "si", La, e1);
		Matricula m2 = new Matricula ("Segundo", "inactivo", (long) 54, "mañana", new Date(11/12/2019), "no", La, e2);
		Matricula m3 = new Matricula ("Tercero", "activo", (long) 14, "tarde", new Date(22/11/2018), "si", La, e3);
		Matricula m4 = new Matricula ("Primero", "inactivo", (long) 60, "mañana", new Date(13/04/2021), "no", La, e4);

		m1.setEM(e4);
		m2.setEM(e3);
		m3.setEM(e2);
		m4.setEM(e1);
		
		for (Matricula matricula : new Matricula [] {m1, m2, m3, m4}) {
			em.persist(matricula);
		}
		
		
		Optativa O1 = new Optativa ((long) 78, (long) 123, (long) 5, (long) 1, (long) 6, "Sí", "Cálculo", (long) 1, "50", "Primer Cuatrimestre", "Español","TIC");
		Optativa O2 = new Optativa ((long) 79, (long) 123, (long) 5, (long) 1, (long) 6, "Sí", "Cálculo", (long) 1, "50", "Primer Cuatrimestre", "Español","C");
		Optativa O3 = new Optativa ((long) 80, (long) 123, (long) 5, (long) 1, (long) 6, "Sí", "Cálculo", (long) 1, "50", "Primer Cuatrimestre", "Español","SI");
		Optativa O4 = new Optativa ((long) 81, (long) 123, (long) 5, (long) 1, (long) 6, "Sí", "Cálculo", (long) 1, "50", "Primer Cuatrimestre", "Español","S");
		
		for (Optativa optativa : new Optativa [] {O1, O2, O3, O4}) {
			em.persist(optativa);
		}
		

		Personal_de_secretaria p1 = new Personal_de_secretaria((long) 150, (long) 621748359, "alvaro@uma.es" , "18752","secretarío");
		Personal_de_secretaria p2 = new Personal_de_secretaria((long) 151, (long) 621748359, "rocio@uma.es", "18752","ejecutivo");
		Personal_de_secretaria p3 = new Personal_de_secretaria((long) 153, (long) 621748359, "agazapao@uma.es", "18752","técnico");
		Personal_de_secretaria p4 = new Personal_de_secretaria((long) 154, (long) 621748359,"marta@uma.es", "18752","comercial");
		
		for (Personal_de_secretaria ps : new Personal_de_secretaria [] {p1, p2, p3, p4}) {
			em.persist(ps);
		}
		
		
		
		
		
		Asignaturas_Matricula am = new Asignaturas_Matricula (m1,Calculo);
		Asignaturas_Matricula am2 = new Asignaturas_Matricula (m2,PL);
		Asignaturas_Matricula am3 = new Asignaturas_Matricula (m3,IIS);
		Asignaturas_Matricula am4 = new Asignaturas_Matricula (m4,Algebra);
		
		am.setAsignatura(Calculo);
		am2.setAsignatura(PL);
		am3.setAsignatura(IIS);
		am4.setAsignatura(Algebra);
		
		am.setMatricula(m1);
		am2.setMatricula(m2);
		am3.setMatricula(m3);
		am4.setMatricula(m4);
		
		am.setG_AM(A);
		am2.setG_AM(B);
		am3.setG_AM(C);
		am4.setG_AM(D);
		
		for(Asignaturas_Matricula asigm: new Asignaturas_Matricula [] {am, am2, am3, am4}) {
			em.persist(asigm);
		}
		
		
		GruposPorAsignatura ga = new GruposPorAsignatura( (long) 1, (long) 8);
		GruposPorAsignatura ga2 = new GruposPorAsignatura( (long) 2, (long) 0);
		GruposPorAsignatura ga3 = new GruposPorAsignatura( (long) 3, (long) 10);
		GruposPorAsignatura ga4 = new GruposPorAsignatura( (long) 4, (long) 1);
		
		ga.setA_GPA(Algebra);
		ga2.setA_GPA(IIS);
		ga3.setA_GPA(PL);
		ga4.setA_GPA(Calculo);
		
		ga.setE_GPA(Stream.of(EleccionGrupo, EleccionCurso, EleccionClase, EleccionTurno).collect(Collectors.toList()));
		
		ga.setG_GPA(A);
		ga2.setG_GPA(B);
		ga3.setG_GPA(C);
		ga4.setG_GPA(D);
		
		for(GruposPorAsignatura gpa: new GruposPorAsignatura [] {ga, ga2, ga3, ga4}) {
			em.persist(gpa);
		}
		
		
		EleccionGrupo.setGruposPorAsignaturas(Stream.of(ga, ga2, ga3, ga4).collect(Collectors.toList()));
		EleccionCurso.setGruposPorAsignaturas(Stream.of(ga, ga2, ga3, ga4).collect(Collectors.toList()));
		EleccionClase.setGruposPorAsignaturas(Stream.of(ga, ga2, ga3, ga4).collect(Collectors.toList()));
		EleccionTurno.setGruposPorAsignaturas(Stream.of(ga, ga2, ga3, ga4).collect(Collectors.toList()));
		
		EleccionGrupo.setEE(e1);
		EleccionCurso.setEE(e2);
		EleccionClase.setEE(e3);
		EleccionTurno.setEE(e4);
		
		for (Encuesta encuesta : new Encuesta [] {EleccionGrupo, EleccionCurso, EleccionTurno, EleccionClase}) {
			em.persist(encuesta);
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}
} 
