package es.uma.informatica.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.Exception.GrupoAsigErrorException;
import es.uma.informatica.Exception.GrupoErrorException;
import es.uma.informatica.Exception.GrupoException;
import es.uma.informatica.Exception.GrupoExistenteException;
import es.uma.informatica.Exception.GrupoNullException;
import es.uma.informatica.Exception.PlazasException;
import es.uma.informatica.Interfaces.InterfazGrupo;
import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Asignatura;
import es.uma.informatica.Entidades.Grupo;
import es.uma.informatica.Entidades.GruposPorAsignatura;

/**
 * Session Bean implementation class Grupo
 */
@Stateless
public class GrupoEJB implements InterfazGrupo {
	
	@PersistenceContext(name="Grupo")
	private EntityManager em;

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
		g1.setTurno_Mañana_Tarde(g.getTurno_Mañana_Tarde());
		g1.setIngles(g.getIngles());
		g1.setVisible(g.getVisible());
		g1.setAsignar(g.getAsignar());
		g1.setPlazas(g.getPlazas());
		em.merge(g1);		
	}

	@Override
	public void eliminarGrupo(Grupo g, Alumno a) throws GrupoException {
		leerGrupo(g.getID());
		//Alumno alumno = em.find(Alumno.class, a.getID());

		if(g.getPlazas()==g.getAsignar()) {
			throw new GrupoErrorException();
		}
		em.remove(em.merge(g));	
	}

	@Override
    public void solicitarCambioGrupo(String causa,Grupo g, Alumno al, Asignatura a) throws GrupoException{
		
		if(causa == null) {
            throw new GrupoNullException();
        }
		
        if(causa.length() < 75){
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
    	//Asignar directamente al alumno al grupo que elige
    	asignarGrupo(g,a);
    }

    @Override
    public void asignarGrupo(Grupo g, Alumno a) throws GrupoException{
    	Grupo grupoPref = em.find(Grupo.class, g.getID());

        if(grupoPref.getAsignar()==0){
            throw new PlazasException();
        }
        //asignar el grupo a un alumno ¿crear relacion?
        grupoPref.setAsignar(grupoPref.getAsignar()-1);
        actualizarGrupo(grupoPref);
    }

	
}
