package es.uma.informatica.EJB;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import es.uma.informatica.Exception.UsuarioErrorException;
import es.uma.informatica.Exception.UsuarioException;
import es.uma.informatica.Exception.UsuarioExistenteException;
import es.uma.informatica.Exception.UsuarioNullException;
import es.uma.informatica.Interfaces.InterfazUsuario;
import es.uma.informatica.Entidades.*;

/**
 * Session Bean implementation class Usuario
 */
@Stateless
public class UsuarioEJB implements InterfazUsuario{

	@PersistenceContext(name="Grupo_L")
	private EntityManager em;

	@Override
	public void crearUsuario(Usuario u) throws UsuarioException {
		Usuario user = em.find(Usuario.class, u.getID());
		if(user != null) {
			throw new UsuarioExistenteException();
		}		
		em.persist(u);		
	}
	
	@Override
	public Usuario leerUsuario(Long num) throws UsuarioException {
		Usuario u=em.find(Usuario.class, num );
		if(u==null) {
			throw new UsuarioExistenteException();
		}
		return u;
	}

	@Override
	public String validarAcceso(String email, String pass) throws UsuarioException{
		String rol=null;
		
        if( email== null) {
            throw new UsuarioExistenteException();
        }
        
        TypedQuery <Alumno> query = em.createQuery("SELECT a FROM Alumno a "
	            + "WHERE a.Email_Institucional LIKE :correo", Alumno.class);
        TypedQuery <Personal_de_secretaria> query2 = em.createQuery("SELECT p FROM Personal_de_secretaria p "
	            + "WHERE p.Email_Institucional LIKE :correo", Personal_de_secretaria.class);
        
		query.setParameter("correo", email);
		query2.setParameter("correo", email);
		
		if(query.getResultList().size()==1) {
			
			Alumno a = query.getSingleResult();
			
			if(!a.getContrasenia().equalsIgnoreCase(pass)) {
			throw new UsuarioErrorException();
			}else {
				rol="ALUMNO";
			}
		}
		
		if(query2.getResultList().size()==1){
			Personal_de_secretaria p = query2.getSingleResult();
			
			if(!p.getContrasenia().equalsIgnoreCase(pass)) {
				throw new UsuarioErrorException();
			}else {
				rol="SECRETARIO";
			}
		}
	
		return rol;        
	}
	@Override
	public Alumno loginAlumno(String email, String pass) throws UsuarioException{
		
        TypedQuery <Alumno> query = em.createQuery("SELECT a FROM Alumno a "
	            + "WHERE a.Email_Personal LIKE :correo", Alumno.class);
		query.setParameter("correo", email);
		Alumno a = query.getSingleResult();
		
		return a;        
	}
	@Override
	public Personal_de_secretaria loginPersonal(String email, String pass) throws UsuarioException{
	
        TypedQuery <Personal_de_secretaria> query2 = em.createQuery("SELECT p FROM Personal_de_secretaria p "
	            + "WHERE p.Email_Institucional LIKE :correo", Personal_de_secretaria.class);
        query2.setParameter("correo", email);
		Personal_de_secretaria p = query2.getSingleResult();
		
		return p;        
	}

	@Override
	public void solicitarRecuperarContrasenia(String email) throws UsuarioException{
		if(email==null) {
			throw new UsuarioNullException();
		}
		
		TypedQuery <Alumno> query = em.createQuery("SELECT a FROM Alumno a "
	            + "WHERE a.Email_Personal LIKE :correo", Alumno.class);
		query.setParameter("correo", email);
		Alumno a = query.getSingleResult();	
		
		if(a==null) {
			throw new UsuarioNullException();
		}
	}

	@Override
	public void generarNuevaContrasenia(Usuario u, String contrasenia) throws UsuarioException {
		
		if(contrasenia==null) {
			throw new UsuarioNullException();
		}
		byte[] newPassword = null;
	    try {
	        newPassword = MessageDigest.getInstance("SHA").digest(contrasenia.getBytes("UTF-8"));
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }

	    String encriptado = Base64.getEncoder().encodeToString(newPassword);
	    Usuario usuario = em.find(Usuario.class, u.getID());
		if(usuario==null) {
			throw new UsuarioNullException();
		}
		usuario.setContrasenia(encriptado);
		em.merge(usuario);
	}
}
