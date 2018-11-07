package servicios;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.Alumno;

public class AlumnoService {
	
	public static Alumno obtenerAlumno(int legajo) {
        return Session.getSession().find(Alumno.class, legajo); 
	}

	public static Alumno obtenerAlumno(String username,String password){
		Alumno alumno = null; 
		try{
			Query query = Session.getSession().createQuery("SELECT a FROM Alumno a WHERE a.githubUser = :nomAlumno and a.password = :pass");
			query.setParameter("nomAlumno", username);
			query.setParameter("pass",password);
			query.setMaxResults(1);
			alumno = (Alumno) query.getSingleResult();
		}catch(NoResultException e){
			e.toString();
		}
		return alumno;
    }
	
	public static void persistirAlumno(Alumno alu) {
		Session.beginTransaction();
		try {
			Session.getSession().persist(alu);
			Session.commitTransaction();
		}catch(Exception e) {
			Session.rollbackTransaction();
		}		
	}
	
	public static void eliminar(Alumno al) {
		try {
			Session.beginTransaction();
			Session.getSession().remove(al);
			Session.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			Session.rollbackTransaction();
		}
	}
	
	public static Alumno obtenerAlumnoPorToken(String tok) {
		return (Alumno) Session.getSession().createQuery("from Alumno a where a.token=:tok")
							                .setParameter("tok", tok).getSingleResult();
	}
}
