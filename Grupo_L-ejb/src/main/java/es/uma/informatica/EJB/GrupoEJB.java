package es.uma.informatica.EJB;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Exception.GrupoAsigErrorException;
import es.uma.informatica.Exception.GrupoErrorException;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.GrupoExistenteException;
import es.uma.informatica.Exception.GrupoNullException;
import es.uma.informatica.Exception.TitulacionException;
import es.uma.informatica.Interfaces.InterfazGrupo;
import es.uma.informatica.Interfaces.InterfazTitulacion;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Asignaturas_Matricula;
import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Entidades.Asignaturas_Matricula.Asignaturas_MatriculaId;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Entidades.GruposPorAsignatura;
import es.uma.informatica.Entidades.Matricula;
import es.uma.informatica.Entidades.Titulacion;

/**
 * Session Bean implementation class Grupo
 */
@Stateless
public class GrupoEJB implements InterfazGrupo {
	
	@PersistenceContext(name="Grupo_L")
	private EntityManager em;
	
	private InterfazTitulacion tit;

	@Override
	public void crearGrupo(Grupo g) throws GrupoException {
		Grupo grupoB = em.find(Grupo.class, g.getID());
		if(grupoB!=null) {
			//El grupo ya existe
			throw new GrupoExistenteException();
		}
		em.persist(g);		
	}

	@Override
	public Grupo leerGrupo(Long ID) throws GrupoException {
		Grupo gr=em.find(Grupo.class,  ID);
		if(gr==null) {
			throw new GrupoErrorException();
		}
		return gr;
	}

	@Override
	public void actualizarGrupo(Grupo g) throws GrupoException {
		Grupo g1 = leerGrupo(g.getID());
		g1.setCurso(g.getCurso());
		g1.setLetra(g.getLetra());
		g1.setTurno_Maniana_Tarde(g.getTurno_Maniana_Tarde());
		g1.setIngles(g.getIngles());
		g1.setVisible(g.getVisible());
		g1.setAsignar(g.getAsignar());
		g1.setPlazas(g.getPlazas());
		em.merge(g1);		
	}

	@Override
	public void eliminarGrupo(Grupo g) throws GrupoException {
		Grupo gr = em.find(Grupo.class, g.getID());
		if(gr==null) {
			throw new GrupoNullException();
		}
		
		
		em.remove(gr);
			/*for(Iterator<Asignaturas_Matrícula>iterator = gr.getAsignaturasMatriculas().iterator();iterator.hasNext();) {
				Asignaturas_Matrícula am = iterator.next();
				em.remove(am);
			}*/
	}

	@Override
    public void solicitarCambioGrupo(String causa,Grupo g, Alumno al, Asignatura a) throws GrupoException{
		
		if(causa == null) {
            throw new GrupoNullException();
        }
		
        if(causa.length() < 3){
            throw new GrupoErrorException();
        }
        if(g == null) {
            throw new GrupoNullException();
        }
        if(al == null) {
            throw new GrupoNullException();
        }
        if(a == null) {
            throw new GrupoNullException();
        }
        List<GruposPorAsignatura> ga = g.getGruposPorAsig();
        for (GruposPorAsignatura GPA : ga) {
        	if(GPA.getCurso_Academico()== 1 ) {
        		if(a.getCodigo()/100!=((long)1)) {
        			throw new GrupoAsigErrorException();
        		}
            }
        	else if(GPA.getCurso_Academico()== 2 ) {
        		if(a.getCodigo()/100!= ((long)2)){
        			throw new GrupoAsigErrorException();
        		}
        	}
        	else if(GPA.getCurso_Academico()== 3 ) {
        		if(a.getCodigo()/100!= ((long)3)){
        			throw new GrupoAsigErrorException();
        		}
        	}
        	else if(GPA.getCurso_Academico()== 4) {
        		if(a.getCodigo()/100!= ((long)4)){
        			throw new GrupoAsigErrorException();
        		}
        	}
        	else if(GPA.getCurso_Academico()== 3 || GPA.getCurso_Academico()== 4) {
        		if(a.getCodigo()/100!= ((long)8)){
        			throw new GrupoAsigErrorException();
        		}
        	}
		}
    }

    @Override
    public void solicitarGrupo(Grupo g, Alumno a) throws GrupoException {

    	if(g==null) {
			throw new GrupoNullException();
		}
    	Grupo grupoPref = em.find(Grupo.class, g.getID());
    	if(grupoPref==null) {
    		throw new GrupoNullException();
    	}
    	asignarGrupo(a);
    }

    @Override
    public void asignarGrupo(Alumno a) throws GrupoException{
    	List<Expediente> e = a.getExpedientes();
    	int contador = 0;
    	for (Expediente expediente : e) {
			if(expediente.getActivo().equalsIgnoreCase("activo")) {
				List<Matricula> m = expediente.getMatriculas();
				for (Matricula matricula : m) {
					if(matricula.getEstado().equalsIgnoreCase("activo")) {
						List<Asignatura> asig = matricula.getA();
						for (Asignatura asignatura : asig) {
							if(asignatura.getIdioma_de_imparticion().equalsIgnoreCase("Español")) {
								List<Asignaturas_Matricula> asigM = asignatura.getAsignaturasMatricula();
								Grupo grupo = asigM.get(contador).getG_AM();
								while(grupo.getIngles().equalsIgnoreCase("si") || grupo.getPlazas()==0) {
									contador++;
								}
								asigM.get(contador).setG_AM(grupo);
							}else {
								List<Asignaturas_Matricula> asigM = asignatura.getAsignaturasMatricula();
								Grupo grupo = asigM.get(contador).getG_AM();
								while(grupo.getIngles().equalsIgnoreCase("no") || grupo.getPlazas()==0) {
									contador++;
								}
								asigM.get(contador).setG_AM(grupo);
							}
							break;
						}
					}
					break;
				}
				break;
			}
		}      
    }

    //BUSCA UN GRUPO POR ASIG PASANDOLE SU ID
    @Override
    public Asignaturas_Matricula leerGrupoAsignatura(Asignaturas_MatriculaId a) throws GrupoException{
    	Asignaturas_Matricula am = em.find(Asignaturas_Matricula.class, a);
		if(am==null) {
			throw new GrupoException();
		}
		return am;
    }
    
    //LEE TODAS LAS ASIG_MATRICULAS DE LA BD
    @Override
    public List<Asignaturas_Matricula> leerAsignaturasMatricula() throws GrupoException{
    	
    	TypedQuery <Asignaturas_Matricula> query = em.createQuery("SELECT a FROM Asignaturas_Matricula a ", Asignaturas_Matricula.class);
    	List<Asignaturas_Matricula> list = query.getResultList();
		
		return list;    	
    }
    
    //METODO PARA LEER LAS ASIG_MATRICULA DE UN ALUMNO
    @Override
    public List<Asignaturas_Matricula> leerAsigMatriculaAlumno(Alumno al) throws GrupoException{
    	
    	TypedQuery <Expediente> query = em.createQuery("SELECT e FROM Expediente e " + "WHERE e.AE LIKE : alumno", Expediente.class);
    	query.setParameter("alumno", al);
    	List<Expediente> listExpediente = query.getResultList();
    	List<Asignaturas_Matricula> listAsigMatricula = new ArrayList <Asignaturas_Matricula>();
    	List<Asignaturas_Matricula> listAsigMatricula2 = new ArrayList <Asignaturas_Matricula>();
    	
    	for (Expediente expediente : listExpediente) {
    		TypedQuery <Asignaturas_Matricula> query3 = em.createQuery("SELECT en FROM Asignaturas_Matricula en " + "WHERE en.EM LIKE : ex", Asignaturas_Matricula.class);
	    	query3.setParameter("ex", expediente.getNum_Expediente());
	    	listAsigMatricula = query3.getResultList();	
	    	for (Asignaturas_Matricula asignaturas_Matricula : listAsigMatricula) {
	    		listAsigMatricula2.add(asignaturas_Matricula);
			}
		}		
		return listAsigMatricula2;    	
    }
    
    //LEE TODOS LOS GRUPOS QUE HAY EN LA BD
    @Override
    public List<Grupo> leerGrupos() throws GrupoException{
    	
    	TypedQuery <Grupo> query = em.createQuery("SELECT a FROM Grupo a ", Grupo.class);
    	List<Grupo> list = query.getResultList();
		
		return list;    	
    }
    
    //LEE TODOS LOS GRUPOS QUE HAY EN LA BD
    @Override
    public List<Long> leerCursosTitulacion(Titulacion t) throws GrupoException{
    	
    	TypedQuery <Grupo> query = em.createQuery("SELECT a FROM Grupo a "+ "WHERE a.TG LIKE : titulacion", Grupo.class);
    	query.setParameter("titulacion", t);
    	List<Grupo> list = query.getResultList();
    	List<Long> cursos = new ArrayList<Long>();
    	for (Grupo g : list) {
    		if(!cursos.contains(g.getCurso())) {
			cursos.add(g.getCurso());
    		}
		}
		
		return cursos;    	
    }
    
    //LEER LETRA PARA VISTA ASIG_MATRICULA
    @Override
    public List<String> leerLetraGrupo(Long curso, Titulacion t) throws GrupoException{
   	    	
    	TypedQuery <Grupo> query = em.createQuery("SELECT g FROM Grupo g " + "WHERE g.Curso LIKE : curs AND g.TG LIKE : titulacion", Grupo.class);
    	query.setParameter("curs", curso);
    	query.setParameter("titulacion", t);
    	List<Grupo> listGrupos = query.getResultList();
    	List<String> listLetras = new ArrayList <String>();
    	
    	for (Grupo gr : listGrupos) {
    		listLetras.add(gr.getLetra());
		}
    	
		return listLetras;    	
    } 
    
  //METODO PARA ASIGNAR 
    @Override
    public void asignaGrupo(Alumno al, Grupo g, Asignatura a, Titulacion t) throws GrupoException{
    	
    	TypedQuery <Expediente> query = em.createQuery("SELECT e FROM Expediente e " + "WHERE e.AE LIKE : alumno AND e.TE LIKE : titula", Expediente.class);
    	query.setParameter("alumno", al);
    	query.setParameter("titula", t);
    	List<Expediente> listExpediente = query.getResultList();
    	//List<Asignaturas_Matricula> listAsigMatricula = new ArrayList <Asignaturas_Matricula>();
    	
    	for (Expediente expediente : listExpediente) {
    		Asignaturas_Matricula am=new Asignaturas_Matricula();
    		am.setAsignatura(a);
    		am.setG_AM(g);
    		Matricula m=em.find(Matricula.class, expediente.getNum_Expediente());
    		am.setMatricula(m);
    		em.merge(am);
    		/*TypedQuery <Asignaturas_Matricula> query3 = em.createQuery("SELECT en FROM Asignaturas_Matricula en " + "WHERE en.EM LIKE : ex", Asignaturas_Matricula.class);
	    	query3.setParameter("ex", expediente.getNum_Expediente());
	    	listAsigMatricula = query3.getResultList();	
	    	for (Asignaturas_Matricula asignaturas_Matricula : listAsigMatricula) {
	    		if(asignaturas_Matricula.getAsignatura().equals(a)) {
	    			asignaturas_Matricula.setG_AM(g);
	    		}
			}*/
		}		
		   	
    }
}
