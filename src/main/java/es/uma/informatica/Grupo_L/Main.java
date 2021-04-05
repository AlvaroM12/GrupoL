package es.uma.informatica.Grupo_L;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Grupo_L");
		EntityManager em = emf.createEntityManager();
		emf.close();
		em.close();

	}

}
