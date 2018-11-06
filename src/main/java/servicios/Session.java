package servicios;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;


public class Session {
	@PersistenceContext
	private static EntityManager em = PerThreadEntityManagers.getEntityManager();
	private static EntityTransaction transaction = em.getTransaction();

    public static EntityManager getSession(){
        return em;
    }
    public static void beginTransaction(){
        transaction.begin();
    }
    public static void rollbackTransaction(){
        transaction.rollback();
    }
    public static void commitTransaction(){
        transaction.commit();
    }

}
