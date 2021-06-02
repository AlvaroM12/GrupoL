package es.uma.informatica.EJB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import es.uma.informatica.Entidades.Alumno;
import es.uma.informatica.Entidades.Encuesta;
import es.uma.informatica.Entidades.Encuesta.EncuestaId;
import es.uma.informatica.Entidades.Expediente;
import es.uma.informatica.Exception.EncuestaException;
import es.uma.informatica.Exception.EncuestaExistenteException;
import es.uma.informatica.Interfaces.InterfazEncuesta;

/**
 * Session Bean implementation class Encuesta
 */
@Stateless
public class EncuestaEJB implements InterfazEncuesta {

	@PersistenceContext(name="Grupo_L")
	private EntityManager em;

	@Override

	public void responderEncuesta(String campos, Encuesta e) throws EncuestaException {
		
		Date Fecha= e.getFecha_De_Envio();
		Long ne=e.getEE().getNum_Expediente();
		EncuestaId ei = new EncuestaId(ne, Fecha);
		Encuesta en = em.find(Encuesta.class, ei);		
		if(en == null){
			throw new EncuestaExistenteException("No existe ninguna encuesta");
		}
	}
	
	public Encuesta leerEncuesta(EncuestaId id) throws EncuestaException {
		Encuesta e = em.find(Encuesta.class, id );
		if(e==null) {
			throw new EncuestaException();
		}
		return e;
		
	}
	
	 @Override
	    public List<Encuesta> leerEncuestas() throws EncuestaException{
	    	
	    	TypedQuery <Encuesta> query = em.createQuery("SELECT a FROM Encuesta a ", Encuesta.class);
	    	List<Encuesta> list = query.getResultList();
			
			return list;    	
	    }
	
	 //METODO PARA DEVOLVER LAS ENCUESTAS DE UN ALUMNO
	 @Override
	    public List<Encuesta> leerEncuestasAlumno(Alumno al) throws EncuestaException{
	    	
	    	TypedQuery <Expediente> query = em.createQuery("SELECT e FROM Expediente e " + "WHERE e.AE LIKE : alumno", Expediente.class);
	    	query.setParameter("alumno", al);
	    	List<Expediente> listExpediente = query.getResultList();
	    	List<Encuesta> listEncuesta = new ArrayList <Encuesta>();
	    	
	    	for (Expediente expediente : listExpediente) {
	    		TypedQuery <Encuesta> query2 = em.createQuery("SELECT en FROM Encuesta en " + "WHERE en.EE LIKE : expediente", Encuesta.class);
		    	query2.setParameter("expediente", expediente);
		    	List<Encuesta> listEncuesta2 = query2.getResultList();
		    	for (Encuesta encuesta : listEncuesta2) {
					listEncuesta.add(encuesta);
				}
			}
			
			return listEncuesta;    	
	    }
}