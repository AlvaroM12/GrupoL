package es.uma.informatica.EJB;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import es.uma.informatica.Exception.AlumnoException;
import es.uma.informatica.Exception.AlumnoExistenteException;
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
	public void validarAcceso(String email, String pass) throws UsuarioException{
		
        if( email== null) {
            throw new UsuarioExistenteException();
        }
        TypedQuery <Alumno> query = em.createQuery("SELECT a FROM Alumno a "
	            + "WHERE a.Email_Personal LIKE :correo", Alumno.class);
		query.setParameter("correo", email);
		Alumno a = query.getSingleResult();
		if(!a.getContraseña().equalsIgnoreCase(pass)) {
			throw new UsuarioErrorException();
		}        
	}

	@Override
	public void solicitarRecuperarContraseña(String email) throws UsuarioException{
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
	public void generarNuevaContraseña(Usuario u, String contraseña) throws UsuarioException {
		
		if(contraseña==null) {
			throw new UsuarioNullException();
		}
		byte[] newPassword = null;
	    try {
	        newPassword = MessageDigest.getInstance("SHA").digest(contraseña.getBytes("UTF-8"));
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
		usuario.setContraseña(encriptado);
		em.merge(usuario);
	}
}
